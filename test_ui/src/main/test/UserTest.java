import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wanghairui on 2017/6/6.
 */
public class UserTest {
    public static void main(String[] args) {

        //map转jsonstring
        Map map=new HashMap(){{put("1","2");}};
        System.out.println(JSONObject.toJSONString(map));

        //jsonstring转map
        String string="{\"1\":\"2\"}";
        JSONObject jsonObject = JSONObject.parseObject(string);
        Map map1=JSONObject.toJavaObject(jsonObject, Map.class);
        System.out.println(map1);
    }
}
