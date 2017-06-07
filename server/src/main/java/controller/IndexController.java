package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;



@Controller
public class IndexController {

    @RequestMapping("/")
    public String pc() {
        return "pc";
    }

    @RequestMapping("/uploadImg")
    public void uploadImg(@RequestParam("file") CommonsMultipartFile file,HttpSession session) throws IllegalStateException, IOException {
        String home = System.getProperties().getProperty("user.home");
        String savePath = home+File.separator+"monitor-icons";
        file.transferTo(new File(savePath,file.getOriginalFilename()));
    }
}
