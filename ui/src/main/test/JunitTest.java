import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.imp.ITodoListService;

/**
 * Created by Wanghairui on 2017/6/9.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring*.xml"})
public class JunitTest {

    @Autowired
    ITodoListService iTodoListService;

    @Test
    public void test(){
        System.out.println("data======="+iTodoListService.getData());
    }
}
