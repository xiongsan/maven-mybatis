package service.todolist;

import bean.TodoList;
import com.fable.enclosure.bussiness.interfaces.BaseRequest;
import com.fable.enclosure.bussiness.interfaces.BaseResponse;
import org.omg.CORBA.OBJ_ADAPTER;

import java.util.List;
import java.util.Map;

/**
 * Created by Wanghairui on 2017/6/9.
 */
public interface ITodoListService {
    BaseResponse todoList();

    BaseResponse modifyTodoList(BaseRequest<Map<String, Object>> request);

    BaseResponse addTodo(BaseRequest<TodoList> todo);

    BaseResponse cancelTodo(BaseRequest<Map<String, Object>> request);
}
