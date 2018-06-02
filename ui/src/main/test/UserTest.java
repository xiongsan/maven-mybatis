import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wanghairui on 2017/6/6.
 */
public class UserTest {
    public static void main(String[] args) {
        Map map=new HashMap(){{put("1","2");}};
        System.out.println(JSONObject.toJSONString(map));
    }
}
