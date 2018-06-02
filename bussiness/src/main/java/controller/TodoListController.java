package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.imp.TodoListServiceIml;
import util.ResultKit;
import util.ServiceResponse;

/**
 * Created by Wanghairui on 2017/6/9.
 */
@Controller
public class TodoListController {

    @Autowired
    private TodoListServiceIml todoListServiceIml;

    @RequestMapping("/todoList")
    @ResponseBody
    public ServiceResponse queryTodoList(){
        return ResultKit.serviceResponse(todoListServiceIml.todoList());
    }
}
