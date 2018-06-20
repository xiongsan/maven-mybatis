package service.imp;

import bean.TodoList;
import mapper.TodoListMapper;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ITodoListService;
import java.util.List;
import java.util.Map;

/**
 * Created by Wanghairui on 2017/6/9.
 */
@Service
public class TodoListServiceIml implements ITodoListService {

    @Autowired
    private TodoListMapper mapper;

    @Autowired
    private CacheManager cacheManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<TodoList> todoList() {
//        Cache cache=cacheManager.getCache("test");
//        if(cache.get("todolist")!=null){
//            return (List<TodoList>)cache.get("todolist").getValue();
//        }
        List<TodoList> list = mapper.getTodoList();
//        Element element = new Element("todolist",list);
//        cache.put(element);
        return list;
    }

    @Override
    public void modifyTodoList(Map<String, Object> param) {
         mapper.updateTodoList(param);
    }

    @Override
    public void addTodo(TodoList todo) {
        mapper.insertTodo(todo);
    }

    @Override
    public void cancelTodo(Map<String,Object> param) {
        mapper.deleteTodo(param);
    }
}
