import bean.TodoList;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.fable.enclosure.bussiness.entity.ServiceRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :Hairui
 * Date :2018/1/8
 * Time :9:33
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class Test {

    public static void main(String[] args) {
//        try {
//           Ia ia= (Ia) new Test().getClass().getClassLoader().loadClass("ForTest").newInstance();
//           ia.function();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        ServiceRequest<TodoList> param = JSON.parseObject("{serviceId: \"test\", method: \"getPageData\", pageNo: 1, pageSize: 10, param: {}}", new TypeReference<ServiceRequest<TodoList>>(){});
    }
}
