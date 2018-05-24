package service.imp;

import bean.TodoList;
import com.fable.enclosure.bussiness.entity.ServiceRequest;
import com.fable.enclosure.bussiness.entity.ServiceResponse;
import com.fable.enclosure.bussiness.interfaces.BaseRequest;
import com.fable.enclosure.bussiness.interfaces.BaseResponse;

import javax.servlet.http.HttpServletRequest;
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
