import bean.TodoList;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
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
 * Date :2018/3/5
 * Time :19:25
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class Generic {

    public static void test01(HttpServletRequest request,TodoList map) {
        System.out.println("Generic.test01()");
    }

    public Map<Integer,TodoList>test02(){
        System.out.println("Generic.test02()");
        return null;
    }

    public static void main(String[] args) {
        try {

            Method m = Generic.class.getMethod("test01", HttpServletRequest.class,TodoList.class);
            Type [] t = m.getGenericParameterTypes();//获取参数泛型
            Type paramType;
            if(t.length>1){
                paramType = t[1];
            }
            else{
                paramType = t[0];
            }
            System.out.println("参数###"+paramType);
            Object param= JSON.parseObject("{sex: \"男\"}", paramType);
//            if(paramType instanceof ParameterizedType){
//                Type[] genericTypes = ((ParameterizedType)paramType).getActualTypeArguments();
//                for(final Type genericType:genericTypes){
//                    JSON.parseObject("{serviceId: \"test\", method: \"getPageData\", pageNo: 1, pageSize: 10, param: {id:'1'}}", new TypeReference<genericType>(){});
//                    JSON.parseObject("", paramType);
//                    System.out.println("泛型类型"+genericType);
//                }
//            }
//            else{
//
//            }
            System.out.println(JSON.toJSONString(param));
            Object o=JSON.parseObject(JSON.toJSONString(param), paramType);
            System.out.println(o);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}
