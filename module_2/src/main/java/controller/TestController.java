package controller;

import bean.User;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.MyService;

import java.util.List;

/**
 * Created by Wanghairui on 2017/5/19.
 */
@Controller
public class TestController {

    @Autowired
    MyService myService;

//    @RequestMapping("/toGet")
//    @ResponseBody
//    public String getSomething(@RequestBody User user){
//        return JSON.toJSON(myService.getData(user)).toString();
//    }

    @RequestMapping("/toGet")
    @ResponseBody
    public List<User> getSomething(@RequestBody User user){
        return myService.getData(user);
    }
}
