package service.imp;

import bean.TodoList;
import mapper.TodoListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ITodoListService;

import java.util.List;
import java.util.Map;

/**
 * Created by Wanghairui on 2017/6/9.
 */
@Service
public class TodoListServiceIml implements ITodoListService {

    @Autowired
    private TodoListMapper mapper;
    @Override
    public List<TodoList> todoList() {
        return mapper.getTodoList();
    }

    @Override
    public void modifyTodoList(Map<String, Object> param) {
         mapper.updateTodoList(param);
    }

    @Override
    public void addTodo(TodoList todo) {
        mapper.insertTodo(todo);
    }

    @Override
    public void cancelTodo(Map<String,String[]> param) {
        mapper.deleteTodo(param.get("ids"));
    }
}
