import cn.md.qingce.service.FileServiceImpl;
import org.junit.Test;

import java.io.File;

public class test {
    @Test
    public void aaa() {
        File file = new File("D:\\tts9\\apache-tomcat-7.0.67 - 8081\\webapps\\ROOT\\table新建 XLS 工作表.xls");

        FileServiceImpl ff = new FileServiceImpl();
        ff.downLoad("D:\\tts9\\apache-tomcat-7.0.67 - 8081\\webapps\\ROOT\\table新建 XLS 工作表.xls");
    }
}
