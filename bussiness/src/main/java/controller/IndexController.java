package controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 主要负责路由
 */
@Controller
public class IndexController {

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/hanoi")
    public String pc() {
        return "hanoi";
    }

    @RequiresPermissions("/liveApproval")
    @RequestMapping("/liveApproval")
    public String liveApproval() {
        return "liveApproval";
    }

    @RequestMapping("/todolist")
    public String todolist() {
        return "todolist";
    }

    @RequestMapping("/picture")
    public String picture() {
        return "picture";
    }

    @RequestMapping("/error")
    public String error() {
        return "error";
    }


}
