package service.imp;

import bean.TodoList;
import com.fable.enclosure.bussiness.interfaces.BaseRequest;
import com.fable.enclosure.bussiness.interfaces.BaseResponse;

import java.util.Map;

/**
 * Created by Wanghairui on 2017/6/9.
 */
public interface ITodoListService {

    BaseResponse getData();

    void modifyTodoList(Map<String, Object> param);

    BaseResponse addTodo(BaseRequest<TodoList> request);

    BaseResponse deleteTodo(BaseRequest<TodoList> request);

    BaseResponse getPageData(BaseRequest<TodoList> param);
}
