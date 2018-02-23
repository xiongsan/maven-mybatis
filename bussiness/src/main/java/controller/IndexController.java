package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import java.io.File;
import java.io.IOException;


/**
 * 主要负责路由
 */
@Controller
public class IndexController {

    @RequestMapping("/hanoi")
    public String pc() {
        return "hanoi";
    }

}
