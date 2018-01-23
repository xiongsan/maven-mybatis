package service.imp;

import bean.TodoList;
import com.fable.enclosure.bussiness.entity.PageResponse;
import com.fable.enclosure.bussiness.entity.ResultKit;
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
@Service("test")
public class TodoListServiceIml extends BaseServiceImpl implements ITodoListService{

    @Autowired
    private TodoListMapper mapper;

    @Autowired
    private CacheManager cacheManager;

    private String[] names=new String[]{"张三","李四","王二麻"};

    @SuppressWarnings("unchecked")
    public ServiceResponse getData() {
        Cache cache=cacheManager.getCache("test");
        if(cache.get("todolist")!=null){
            return ResultKit.serviceResponse(cache.get("todolist").getValue());
        }
        List<TodoList> list = mapper.getTodoList();
        Element element = new Element("todolist",list);
        cache.put(element);
        return ResultKit.serviceResponse(list);
    }

    public ServiceResponse getPageData(Map<String, Object> param){
        Page<TodoList> result = PageHelper.startPage(Integer.parseInt(param.get("pageNo").toString()),Integer.parseInt(param.get("pageSize").toString()));
        mapper.getTodoList();
        return ResultKit.serviceResponse(PageResponse.wrap(result));
    }

    @Override
    public void modifyTodoList(Map<String, Object> param) {
         mapper.updateTodoList(param);
    }

    @Override
    @SuppressWarnings("unchecked")
    /*事物处理*/
    public ServiceResponse addTodo(Map<String,Object> todo) {
        Tool.startTransaction();
        try{
            todo.put("id","123");
            todo.put("checked", 0);
            todo.put("title", names[new Random().nextInt(names.length)]);
            mapper.insertTodo(todo);
            todo.put("id", "123456");
            todo.put("checked", 1);
            todo.put("title", names[new Random().nextInt(names.length)]);
            mapper.insertTodo(todo);
            Tool.endTransaction();
            return ResultKit.success();
        }catch(Exception e){
            Tool.rollBack();
            e.printStackTrace();
            return ResultKit.fail();
        }
    }

    @Override
    public void cancelTodo(Map<String,Object> param) {
        mapper.deleteTodo(param);
    }
}
