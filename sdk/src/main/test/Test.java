import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

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
        //map转jsonstring
        Map map=new HashMap(){{put("1","2");}};
        System.out.println(JSONObject.toJSONString(map));

        //jsonstring转map
        String string="{\"1\":\"2\"}";
        JSONObject jsonObject = JSONObject.parseObject(string);
        Map<String,Object> map1=JSONObject.toJavaObject(jsonObject, Map.class);
        Map maps = (Map) JSON.parse(string);
        System.out.println(maps);
    }
}
