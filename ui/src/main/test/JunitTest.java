import bean.TodoList;
import com.alibaba.fastjson.JSON;
import com.fable.enclosure.bussiness.entity.ServiceResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.imp.TodoListServiceIml;

import java.util.List;
import java.util.Map;

/**
 * Created by Wanghairui on 2017/6/9.
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring.xml")
public class JunitTest {
//    @Autowired
//    TodoListServiceIml todoListServiceIml;
    @Test
    public void test(){

        Map<String, Object> params = (Map) JSON.parse("{sex:'男'}");
        System.out.println(params);
    }
}
