package controller;

import bean.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.imp.TodoListServiceIml;
import util.ResultKit;
import util.ServiceResponse;
import util.Tool;

import java.util.Map;

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

    @RequestMapping("/changeState")
    @ResponseBody
    public ServiceResponse complete(@RequestBody Map<String,Object> param){
        try{
            todoListServiceIml.modifyTodoList(param);
            return ResultKit.success();
        }
        catch (Exception e){
            e.printStackTrace();
            return ResultKit.fail("内部运行错误");
        }
    }

    @RequestMapping("/newTodo")
    @ResponseBody
    public ServiceResponse newTodo(@RequestBody TodoList todo){
        try {
            todo.setId(Tool.newGuid().toString());
            todoListServiceIml.addTodo(todo);
            return ResultKit.success();
        }
        catch (Exception e){
            e.printStackTrace();
            return ResultKit.fail("添加任务异常");
        }
    }

    @RequestMapping("/killTodo")
    @ResponseBody
    public ServiceResponse killTodo(@RequestBody Map<String,String[]> param){
        try {
            todoListServiceIml.cancelTodo(param);
            return ResultKit.success();
        }
        catch (Exception e){
            e.printStackTrace();
            return ResultKit.fail("删除任务异常");
        }
    }
}
