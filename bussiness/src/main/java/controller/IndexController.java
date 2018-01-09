package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import java.io.File;
import java.io.IOException;


/**
 * 主要负责路由，上传，下载
 */
@Controller
public class IndexController {

    @RequestMapping("/hanoi")
    public String pc() {
        return "hanoi";
    }

    @RequestMapping("/uploadImg")
    public void uploadImg(@RequestParam("file") CommonsMultipartFile file) throws IllegalStateException, IOException {
        String home = System.getProperties().getProperty("user.home");
        String savePath = home+File.separator+"monitor-icons";
        file.transferTo(new File(savePath,file.getOriginalFilename()));
    }
}
