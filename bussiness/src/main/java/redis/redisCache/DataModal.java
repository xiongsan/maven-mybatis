package redis.redisCache;

import entity.User;
import redis.pubsub.JunitTestPublish;

import java.util.ArrayList;
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
 * Time :13:39
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class DataModal {
    public static  List<User> queryUser(){
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setLoginName("1111");
        users.add(user1);
        User user2 = new User();
        user2.setLoginName("2222");
        users.add(user2);
        User user3 = new User();
        user3.setLoginName("3333");
        users.add(user3);
        return users;
    }
    public void addOrModifyOrdel(){
        //do ------------------
        //保持同步，删除缓存
        new JunitTestPublish().getJedisPool().getResource().hdel(GetData.hashKey, "users");
    }
}
