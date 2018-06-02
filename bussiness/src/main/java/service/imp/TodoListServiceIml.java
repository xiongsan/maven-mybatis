package service.imp;

import bean.TodoList;
import mapper.TodoListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ITodoListService;

import java.util.List;

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
}
