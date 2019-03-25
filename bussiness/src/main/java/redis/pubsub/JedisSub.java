package redis.pubsub;

import redis.clients.jedis.Jedis;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :王海瑞 2016/12/13
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class JedisSub {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Jedis jedis = new Jedis("192.168.0.105", 6379);
                    jedis.subscribe(new RedisListener(), "CCTV-1");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}