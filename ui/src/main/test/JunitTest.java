import bean.TodoList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.imp.TodoListServiceIml;

import java.util.List;

/**
 * Created by Wanghairui on 2017/6/9.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class JunitTest {
    @Autowired
    TodoListServiceIml todoListServiceIml;
    @Test
    public void test(){

        List<TodoList> list = todoListServiceIml.todoList();
        for(TodoList todoList:list){
            System.out.println(todoList);
        }
    }
}
