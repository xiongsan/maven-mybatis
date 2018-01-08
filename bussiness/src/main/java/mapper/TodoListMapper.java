package mapper;

import bean.TodoList;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Wanghairui on 2017/5/22.
 */
@Repository
public interface TodoListMapper {

    List<TodoList> getTodoList();

    void updateTodoList(Map<String, Object> param);

    void insertTodo(Map<String,Object> todo);

    void deleteTodo(Map<String,Object> param);
}
