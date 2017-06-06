package controller;

import bean.User;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.MyService;
import service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wanghairui on 2017/5/19.
 */
@Controller
public class TestController {

    @Autowired
    MyService myService;

    @Autowired
    UserService userService;

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

    @RequestMapping("/addUser")
    @ResponseBody
    public Map<String,Object> addUser(){
        userService.newUser();
        return new HashMap<String, Object>(){{put("message","添加成功");}};
    }

    @RequestMapping("/getUser/{id}")
    @ResponseBody
    public User getUser(@PathVariable String id){
       return myService.getUser(id);
    }
}
