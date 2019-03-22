package cn.md.qingce.service;

import cn.md.qingce.entity.ReadObject;
import cn.md.qingce.entity.WriterObject;
import cn.md.qingce.service.Ex.uploadException;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Service("fileService")
public class FileServiceImpl implements IFileService {
    @Override
    public String uploadFile(MultipartFile file, HttpServletRequest request) {
        System.out.println("uploadFile方法");
        File saveFile = null;

        if (!file.isEmpty()) {
            String saveFileName = file.getOriginalFilename();
            String realUrl = request.getSession().getServletContext().getRealPath("/table/") + saveFileName;
            saveFile = new File(realUrl);

            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
                out.write(file.getBytes());
                out.flush();
                out.close();


                return realUrl;
            } catch (FileNotFoundException e) {

                return "上传失败,";


            } catch (IOException e) {
                return "上传失败,";


            }
        } else {

            return "上传失败，因为文件为空.";

        }
    }

    @Override
    public byte[] downLoad(String fileReal) {
        File file = new File(fileReal);
        byte[] bytes = null;
        try {

            List<ReadObject> data = readIt(file);
            List<WriterObject> lists = fenxi(data);

            bytes = createExcel(lists);

        } catch (Exception e) {
            System.out.println(e);
        }
        return bytes;
    }

    private int count = 1;

    private WriterObject writerHead(ReadObject ro) {
        WriterObject wo = new WriterObject();
        wo.set(0, "序号");
        for (int i = 1; i < 34; i++) {
            String val = ro.get(i);
            wo.set(i, val);
        }
        wo.setU("设备类型是否一致");
        wo.setV("运行状态是否一致");
        wo.setW("电压等级是否一致");
        wo.setX("资产编码是否一致");
        wo.setY("是否有原值");
        wo.setZ("设备描述是否一致");
        wo.setAA("所属变电站是否一致");
        wo.setAB("设备分类与资产分类是否一致");
        wo.setAC("帐卡物是否一致");
        wo.setAD("否的数量");
        return wo;

    }

    private List<WriterObject> fenxi(List<ReadObject> roList) {
        List<WriterObject> writerObjectList = new ArrayList<>();
        count = 1;
        ReadObject ro = roList.get(0);
        //写出类的第一行（字段）
        WriterObject w = writerHead(ro);
        writerObjectList.add(w);

        //从第二行开始遍历
        for (int i = 1; i < roList.size(); i++) {
            ro = roList.get(i);
            WriterObject wo = writerLine(ro);


            writerObjectList.add(wo);
        }
        return writerObjectList;
    }

    private byte[] createExcel(List<WriterObject> list) throws Exception {
        //POI API 生成Excel
        XSSFWorkbook workbook = new XSSFWorkbook();
        //工作簿中创建一个工作表
        XSSFSheet sheet = workbook.createSheet("Demo");
        //创建行，参数是行号0，1，2，3
        for (int i = 0; i < list.size(); i++) {
            WriterObject data = list.get(i);
            XSSFRow row = sheet.createRow(i);
            //在行中创建数据格子
            for (int j = 0; j < 36; j++) {
                XSSFCell cell = row.createCell(j);
                cell.setCellValue(data.get(j));
            }
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();
        out.close();
        byte[] bytes = out.toByteArray();
        return bytes;
    }

    public WriterObject writerLine(ReadObject ro) {
        int wrongNum = 0;

        //当再次调用这个方法的时候(指的是传第二张表格的时候)，给count复原；

        WriterObject wo = new WriterObject();
        for (int i = 1; i < 35; i++) {
            wo.set(i, ro.get(i));
        }
        wo.setId(count + "");
        count++;
        StringBuilder sb = new StringBuilder("");
        //比设备类型
        String PMS = ro.getAH();
        String ERP = ro.getM();
        System.out.println("比较设备类型：" + PMS + "vs" + ERP);
        String newName = "";
        String ERPSub = ERP.substring(ERP.lastIndexOf("/") + 1);

        if (PMS.equals(ERPSub)) {
            wo.setU("是");
        } else {
            newName = PMS + "(" + ERP + ")";
            wo.setAH(newName);
            wo.setU("否");
            wrongNum++;
            sb.append("设备类型不一致，");

        }
        //比较运行状态
        PMS = ro.getH();
        ERP = ro.getP();
        System.out.println("比较运行状态：" + PMS + "vs" + ERP);
        if (PMS.equals(ERP)) {
            wo.setV("是");
        } else {
            wo.setV("否");
            newName = PMS + "(" + ERP + ")";
            wo.setH(newName);
            sb.append("运行状态不一致,");
            wrongNum++;
        }
        //比较电压等级
        PMS = ro.getC();
        ERP = ro.getQ();
        System.out.println("比较电压等级：" + PMS + "vs" + ERP);
        if (PMS.equals(ERP)) {
            wo.setW("是");
        } else {
            newName = PMS + "(" + ERP + ")";
            wo.setW("否");
            wo.setC(newName);
            sb.append("电压等级不一致，");
            wrongNum++;
        }
        //比较资产编码
        PMS = ro.getF();
        ERP = ro.getR();
        System.out.println("比较资产编码：" + PMS + "vs" + ERP);
        //设置一个开关，为了保证X的值是唯一的，wrongNum也是在“比较资产编码”的代码里面，最多走一次就行
        boolean flag = false;
        //如果PMS的资产值有效，并且ErP的资产值有效，并且这两个值相等
        if (PMS.length() > 8 && ERP.length() > 8 && PMS.equals(ERP)) {
            wo.setX("是");
        } else {
            //如果PMS的资产值为空
            if (PMS.length() < 8 || PMS == null || "".equals(PMS)) {

                sb.append("PMS无资产编号，");
                flag = true;
            }
            //如果ERP的资产值为空
            if (ERP.length() < 8 || ERP == null || "".equals(ERP)) {

                sb.append("ERP无资产编号，");
                flag = true;
            }
            //如果PMS有资产值，ERP有资产值，但两个值不相等
            if (PMS.length() > 8 && ERP.length() > 8 && !PMS.equals(ERP)) {
                sb.append("资产编码不一致，");
                flag = true;
            }
        }
        if (flag == true) {
            wo.setX("否");
            wrongNum++;
        }
        //是否有资产原值
        ERP = ro.getS();
        System.out.println("比较资产原值：" + ERP);
        flag = false;
        //如果原值是空
        if (null == ERP || "".equals(ERP)) {
            flag = true;
        } else {
            try {
                double num = Double.parseDouble(ERP);// 转换成功则是数字
                if (num > 1) {
                    wo.setY("是");
                } else {
                    flag = true;
                }
                //try catch 捕捉的是非法参数异常
            } catch (Exception e) {
                flag = true;
            }
        }
        if (flag == true) {
            sb.append("没有资产原值，");
            wo.setY("否");
            wrongNum++;
        }

        //比设备名字
        PMS = ro.getB();
        ERP = ro.getN();
        System.out.println("比较名字：" + PMS + "vs" + ERP);
        if (!PMS.equals(ERP)) {
            newName = PMS + "(" + ERP + ")";
            wo.setB(newName);
            wo.setZ("否");
            sb.append("设备名称不一致");
            wrongNum++;
        } else {
            wo.setZ("是");
        }
        //比较变电站是否一致
        PMS = ro.getJ();
        ERP = ro.getO();
        System.out.println("比较变电站：" + PMS + "vs" + ERP);

        if (PMS.equals(ERP)) {
            wo.setAA("是");

        } else {
            wo.setAA("否");
            newName = PMS + "(" + ERP + ")";
            wo.setJ(newName);
            sb.append("变电站名称不一致");
            wrongNum++;
        }

        //设备分类与资产分类是否一致
        wo.setAB("是");
        //帐卡物是否一致
        if (sb.length() < 2) {
            wo.setAC("是");
        } else {
            wo.setAC("否");

        }
        //否的数量
        wo.setAD(wrongNum + "");
        //备注
        if (wrongNum == 0) {
            sb = new StringBuilder("帐卡一致");
        }
        ERP = ro.getL();
        if (null == ERP || ERP.length() < 8) {
            sb = new StringBuilder("根据设备编码在ERP查不到该设备");
        }
        //把sb的内容写入到备注栏里面
        wo.setAJ(sb.toString());

        return wo;
    }

    private List<ReadObject> readIt(File file) throws Exception {
        List<ReadObject> list = new ArrayList<ReadObject>();
        Sheet sheet;
        Workbook book;
        book = Workbook.getWorkbook(file);
        //获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
        sheet = book.getSheet(0);
        int rows = sheet.getRows();
        for (int i = 0; i < rows; i++) {
            ReadObject ro = new ReadObject();
            for (int j = 0; j < 34; j++) {
                String value = sheet.getCell(j, i).getContents();
                ro.set(j, value);
            }
            list.add(ro);
        }


        return list;
    }

    @Override
    public byte[] handlerFile(MultipartFile file, HttpServletRequest request) {
        System.out.println("handlerFile方法");
        String result = uploadFile(file, request);
        if ("上传失败,".equals(result)) {
            throw new uploadException(result);
        } else if ("上传失败，因为文件为空.".equals(result)) {
            throw new uploadException(result);
        }

        return downLoad(result);
    }

}
