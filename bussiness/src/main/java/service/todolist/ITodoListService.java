package service.todolist;

import bean.TodoList;
import com.fable.enclosure.bussiness.entity.PageRequest;
import com.fable.enclosure.bussiness.interfaces.BaseRequest;
import com.fable.enclosure.bussiness.interfaces.BaseResponse;

import java.util.Map;

/**
 * Created by Wanghairui on 2017/6/9.
 */
public interface ITodoListService {

    BaseResponse getData();

    void modifyTodoList(Map<String, Object> param);

    BaseResponse addTodo(TodoList todo);

    BaseResponse deleteTodo(TodoList request);

    BaseResponse getPageData(PageRequest<TodoList> param);
    BaseResponse addTodoTest(TodoList param);
}
