package aboutJson;

import aboutBlockQueue.Test;
import com.fable.enclosure.bussiness.entity.PageRequest;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;

import javax.naming.Name;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :Hairui
 * Date :2018/5/23
 * Time :14:34
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class Normal {

    private int pageNo;

//    public int getPageNo() {
//        return pageNo;
//    }
//
//    public void setPageNo(int pageNo) {
//        this.pageNo = pageNo;
//    }

    public void test(PageRequest<User> baseI){
        User user = baseI.getParam();
        System.out.println(user);
        System.out.println(baseI);
    }

//    @Override
//    public String toString() {
//        return "Normal{" +
//                "pageNo=" + pageNo +
//                "name=" + this.getName()+
//                '}';
//    }

    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //年月日时分秒格式需要在实体类加一个注解指定，格式
        String json = "{\"age\":1,\"param\":{\"ID\":\"1\",\"cjsj\":\"2019-10-11 10:00:00\"}}";
        //默认实体类中不存在此属性会报错
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                for(Method method:Normal.class.getDeclaredMethods()){
                    for (Type type: method.getGenericParameterTypes()){
                        if (method.getName().equals("test")){
//                            Class[] classz= method.getParameterTypes();
                            JavaType type1 = mapper.getTypeFactory().constructType(type);
                            Object object = mapper.readValue(json, type1);
                            method.invoke(Normal.class.newInstance(),object);
                        }

                    }
                }
    }
}
