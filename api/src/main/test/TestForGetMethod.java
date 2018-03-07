import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xpath.internal.operations.String;

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
 * Date :2018/3/7
 * Time :12:48
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class TestForGetMethod {

    public void test1(Map<String, Integer> param) {

    }
    public void test1(String param) {

    }

    public void test1() {

    }

    public static void main(String[] args) throws NoSuchMethodException {
        //ServiceRequest
        //null

//        Method m1=TestForGetMethod.class.getMethod("test1", null);
//        System.out.println(m1);
//
//        Method m2 = TestForGetMethod.class.getMethod("test1", Map.class);
//        System.out.println(m2);
//        Map<String, Object> map = new HashMap<>();

        Method[] methods = TestForGetMethod.class.getDeclaredMethods();
        for (Method method:methods){
            System.out.println(method.getName());

        }
    }
}
