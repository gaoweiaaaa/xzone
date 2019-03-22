package cn.md.qingce.controller;

import cn.md.qingce.service.Ex.uploadException;
import cn.md.qingce.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.UnsupportedEncodingException;

@Controller
public class baseController {
    @Autowired
    private IFileService fileService;

    @RequestMapping("/qingce.htm")
    private String hello() {

        return "qingce";
    }

    @RequestMapping("handler.htm")
    @ResponseBody
    private byte[] handler(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        byte[] bytes = new byte[]{};
        try {
            bytes = fileService.handlerFile(file, request);
            String saveFileName = file.getOriginalFilename();
            response.setContentType(
                    "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
            );
            System.out.println(saveFileName);
            response.setHeader("Content-Disposition", "attachment; filename='" + saveFileName + "'");
            System.out.println("完成");
        } catch (uploadException e) {
            //todoResultUtils
        }

        return bytes;
    }

    private byte[] putFile(File saveFile, HttpServletResponse response) {
// 下载Excel文件


        return null;
    }

}
