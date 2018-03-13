package service;

import bean.TodoList;
import com.fable.enclosure.bussiness.entity.ServiceRequest;
import com.fable.enclosure.bussiness.entity.ServiceResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Wanghairui on 2017/6/9.
 */
public interface ITodoListService {

    ServiceResponse getData();

    void modifyTodoList(Map<String, Object> param);

    ServiceResponse addTodo(ServiceRequest<TodoList> request);

    ServiceResponse deleteTodo(ServiceRequest<TodoList> request);
}
