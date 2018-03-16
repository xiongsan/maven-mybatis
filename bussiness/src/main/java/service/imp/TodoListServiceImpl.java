package service.imp;

import bean.TodoList;
import com.fable.enclosure.bussiness.entity.ResultKit;
import com.fable.enclosure.bussiness.entity.ServiceRequest;
import com.fable.enclosure.bussiness.entity.ServiceResponse;
import com.fable.enclosure.bussiness.service.impl.BaseServiceImpl;
import com.fable.enclosure.bussiness.util.Tool;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import mapper.TodoListMapper;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ITodoListService;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Wanghairui on 2017/6/9.
 */
@Service
public class TodoListServiceImpl extends BaseServiceImpl implements ITodoListService{

    @Autowired
    private TodoListMapper mapper;

    @Autowired
    private CacheManager cacheManager;

    private String[] names=new String[]{"张三","李四","王二麻","赵六","傻根","来福","二狗子","小花"};

    @SuppressWarnings("unchecked")
    public ServiceResponse getData() {
        Cache cache=cacheManager.getCache("test");
        if(cache.get("todolist")!=null){
            return ResultKit.serviceResponse(cache.get("todolist").getValue());
        }
        List<TodoList> list = mapper.getTodoList(new TodoList());
        Element element = new Element("todolist",list);
        cache.put(element);
        return ResultKit.serviceResponse(list);
    }

    public ServiceResponse getPageData(ServiceRequest<TodoList> param){
        Page<TodoList> result = PageHelper.startPage(param.getPageNo(),param.getPageSize());
        mapper.getTodoList(param.getParam());
        return ServiceResponse.wrap(result);
    }

    @Override
    public void modifyTodoList(Map<String,Object> param) {
         mapper.updateTodoList(param);
    }

    @Override
    @SuppressWarnings("unchecked")
    /*事物处理*/
    public ServiceResponse addTodo(ServiceRequest<TodoList> request) {
        Tool.startTransaction();
        try{
            TodoList todo = request.getParam();
            todo.setTitle(names[new Random().nextInt(names.length)]);
            todo.setId(Tool.newGuid());
            todo.setChecked(1);
            mapper.insertTodo(todo);
            todo.setTitle(names[new Random().nextInt(names.length)]);
            todo.setId(Tool.newGuid());
            todo.setChecked(0);
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
    public ServiceResponse deleteTodo(ServiceRequest<TodoList> request) {
        mapper.deleteTodo(request.getParam());
        return ResultKit.success();
    }
}
