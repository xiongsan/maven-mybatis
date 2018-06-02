package aboutJson;

import com.fable.enclosure.bussiness.interfaces.BaseRequest;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;
import org.apache.kafka.common.utils.Java;
import org.springframework.expression.spel.ast.NullLiteral;

import java.io.IOException;
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
public class Normal extends BaseI {

    private int pageNo;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    @Override
    public String toString() {
        return "Normal{" +
                "pageNo=" + pageNo +
                "name=" + this.getName()+
                '}';
    }

    public static void main(String[] args) {
        String json = "{\"@class\":\"aboutJson.BaseI\",\"age\":1}";
        //默认实体类中不存在此属性会报错
        ObjectMapper mapper = new ObjectMapper();
        //mapper.configure(Feature.IGNORE_UNKNOWN,false);//设置为false忽略多余的属性！
        Base base=null;
        try {
             base=mapper.readValue(json, Base.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(base);
    }
}
