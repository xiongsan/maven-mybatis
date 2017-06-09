package service;

import bean.TodoList;
import org.omg.CORBA.OBJ_ADAPTER;

import java.util.List;
import java.util.Map;

/**
 * Created by Wanghairui on 2017/6/9.
 */
public interface ITodoListService {
    List<TodoList> todoList();

    void modifyTodoList(Map<String, Object> param);

    void addTodo(TodoList todo);

    void cancelTodo(Map<String,String[]> param);
}
