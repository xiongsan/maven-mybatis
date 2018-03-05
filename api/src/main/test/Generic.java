import bean.TodoList;
import com.sun.xml.internal.bind.v2.TODO;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
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
 * Date :2018/3/5
 * Time :19:25
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class Generic {

    public static void test01(Map<String, TodoList>map, List<TodoList>list){
        System.out.println("Generic.test01()");
    }

    public Map<Integer,TodoList>test02(){
        System.out.println("Generic.test02()");
        return null;
    }

    public static void main(String[] args) {
        try {

            Method m = Generic.class.getMethod("test01", Map.class,List.class);
            Type [] t = m.getGenericParameterTypes();//获取参数泛型
            for(Type paramType:t){
                System.out.println("#"+paramType);
                if(paramType instanceof ParameterizedType){
                    Type[]genericTypes = ((ParameterizedType)paramType).getActualTypeArguments();
                    for(Type genericType:genericTypes){
                        System.out.println("泛型类型"+genericType);
                    }
                }
            }

            Method m2 =Generic.class.getMethod("test02", null);
            Type returnType = m2.getGenericReturnType();//获取返回类型的泛型
            if(returnType instanceof ParameterizedType){
                Type [] genericTypes2 =((ParameterizedType)returnType).getActualTypeArguments();
                for(Type genericType2:genericTypes2){
                    System.out.println("返回值，泛型类型"+genericType2);
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}
