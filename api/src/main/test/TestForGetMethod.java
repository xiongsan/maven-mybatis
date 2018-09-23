
import com.fable.enclosure.bussiness.entity.ServiceRequest;
import entity.User;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
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
    public void test1(User param) {

    }

    public void test1() {

    }

    public static void main(String[] args) throws NoSuchMethodException {

        Method[] methods = TestForGetMethod.class.getDeclaredMethods();
        for (Method method:methods){
            for (Type c : method.getGenericParameterTypes()) {
                System.out.println(c.getTypeName());
                System.out.println(TestForGetMethod.class.getName());
            }

        }
    }
}
