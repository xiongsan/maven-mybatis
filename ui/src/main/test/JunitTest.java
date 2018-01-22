import com.alibaba.fastjson.JSON;
import org.junit.Test;

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
