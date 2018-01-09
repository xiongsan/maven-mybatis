package service;

import com.fable.enclosure.bussiness.entity.ServiceResponse;

import java.util.Map;

/**
 * Created by Wanghairui on 2017/6/9.
 */
public interface ITodoListService {

    ServiceResponse getData();

    void modifyTodoList(Map<String, Object> param);

    ServiceResponse addTodo(Map<String,Object> todo);

    void cancelTodo(Map<String,Object> param);
}
