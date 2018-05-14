package redis.redisCache;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import entity.User;
import org.junit.Test;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.pubsub.JunitTestPublish;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :Hairui
 * Date :2018/4/19
 * Time :13:38
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class GetData {
    public static final String hashKey = "whatever";
    static Jedis jedis=new JunitTestPublish().getJedisPool().getResource();
    public List<User> getUser(){
        String users = jedis.hget(hashKey, "users");
        if(!StringUtils.isEmpty(users)){
            return JSONObject.parseArray(users, User.class);
        }
        List<User> userList= DataModal.queryUser();
        jedis.hset(hashKey, "users", JSONArray.toJSONString(userList));
        return userList;
    }
    @Test
    public void test() throws IOException {
        List<User> users=getUser();
        System.out.println(users);
    }
}
