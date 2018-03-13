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

    List<TodoList> getTodoList(TodoList todo);

    void updateTodoList(Map<String, Object> param);

    void insertTodo(TodoList todo);

    void deleteTodo(TodoList todo);
}
