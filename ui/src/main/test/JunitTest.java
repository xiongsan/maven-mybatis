import aboutSpringListener.MsgEvent;
import com.fable.enclosure.bussiness.util.SpringContextUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.todolist.ITodoListService;
/**
 * Created by Wanghairui on 2017/6/9.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring*.xml"})
public class JunitTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void test(){
        context.publishEvent(new MsgEvent("哈哈哈"));
    }
}
