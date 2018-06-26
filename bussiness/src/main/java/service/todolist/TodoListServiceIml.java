package service.todolist;

import bean.TodoList;
import com.fable.enclosure.bussiness.interfaces.BaseRequest;
import com.fable.enclosure.bussiness.interfaces.BaseResponse;
import com.fable.enclosure.bussiness.service.impl.BaseServiceImpl;
import com.fable.enclosure.bussiness.util.ResultKit;
import com.fable.enclosure.bussiness.util.Tool;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import mapper.TodoListMapper;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Wanghairui on 2017/6/9.
 */
@Service
public class TodoListServiceIml extends BaseServiceImpl implements ITodoListService {

    @Autowired
    private TodoListMapper mapper;

    @Autowired
    private CacheManager cacheManager;

    @Override
    @SuppressWarnings("unchecked")
    public BaseResponse todoList() {
//        Cache cache=cacheManager.getCache("test");
//        if(cache.get("todolist")!=null){
//            return ResultKit.serviceResponse((List<TodoList>) cache.get("todolist").getValue());
//        }
        List<TodoList> list = mapper.getTodoList();
//        Element element = new Element("todolist",list);
//        cache.put(element);
        return ResultKit.serviceResponse(list);
    }

    @Override
    public BaseResponse modifyTodoList(BaseRequest<Map<String, Object>> request) {
         mapper.updateTodoList(request.getParam());
        return ResultKit.success();
    }

    public BaseResponse addTodo(BaseRequest<TodoList> request) {
        Tool.startTransaction();
        try{
            TodoList todo = request.getParam();
            todo.setId(Tool.newGuid());
            todo.setChecked("1");
            todo.setSex("男");
            mapper.insertTodo(todo);
            Tool.endTransaction();
            return ResultKit.success();
        }catch(Exception e){
            Tool.rollBack();
            e.printStackTrace();
            return ResultKit.fail(e.getMessage());
        }
    }

    @Override
    public BaseResponse cancelTodo(BaseRequest<Map<String, Object>> request) {
        mapper.deleteTodo(request.getParam());
        return ResultKit.success();
    }

    public BaseResponse getPageData(BaseRequest<TodoList> param){
        Page<TodoList> result = PageHelper.startPage(param.getPageNo(),param.getPageSize());
        mapper.getTodoList();
        return ResultKit.wrap(result);
    }
}
