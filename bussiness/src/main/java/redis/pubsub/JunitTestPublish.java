package redis.pubsub;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Random;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :王海瑞 2016/11/17
 * </p>
 * <p>
 * Department :
 * </p>¢
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class JunitTestPublish {

    private JedisPool jedisPool;

    public  JedisPool getJedisPool() {
        if (this.jedisPool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
//            String host = PluginProperties.getProperty("redis.host");
//            int port = PluginProperties.getInteger("redis.port");
            //第四个参数timeout，为10秒，四千万数据量集合上操作最多一次大概超时5秒
            //redis.clients.jedis.Protocol.DEFAULT_TIMEOUT = 2000 为两秒
            //通过以下构造方法，设置超时允许时间为10s，不太会出现socket timeout超时问题
            this.jedisPool = new JedisPool(config, "192.168.0.105", 6379, 10000);
        }
        return this.jedisPool;
    }

    //发布
//    @Test
    public void testPublish() {
        Random random = new Random();
        final Jedis jedis = this.getJedisPool().getResource();
        final String[] strings = new String[]{
                "topicId,CPOE_Haitai_001,endPublish, true",
                "topicId,AIMS_MDSD_001,endPush,true",
                "topicId,MNS_YuanZhuo_001,endPublish, false",
                "topicId,HIS_QiHang_001,endPublish, true",
                "topicId,HIS_ZBHZ_001,endPush, false",
                "topicId,QS_SZSH_001,endPush,true",
                "topicId,LIS_RuiMei_001,endPublish,false",
                "topicId,DIP_DongRuan_001,endPush,true",
                "topicId,EMR_HaiTai_001,endPush,false",
                "topicId,APP_ZHIKANG,endPush,false",
                "topicId,EMR_HaiTai_002,endPublish,true",
                "topicId,PACS_FeiTe_001,endPush,false",
                "topicId,PACS_JieShiDa_001,endPush,true",
                "topicId,JFW_DW,endPush,true",
                  "topicId,AITEST,endPush,false",
        };
        while (true) {
            try {
                Thread.sleep(500);
                jedis.publish("CCTV-1", strings[random.nextInt(strings.length)]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        final   Jedis jedis = new Jedis("192.168.0.105", 6379);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final String[] strings = new String[]{
                "topicId,CPOE_Haitai_001,endPublish, true",
                "topicId,AIMS_MDSD_001,endPush,true",
                "topicId,MNS_YuanZhuo_001,endPublish, false",
                "topicId,HIS_QiHang_001,endPublish, true",
                "topicId,HIS_ZBHZ_001,endPush, false",
                "topicId,QS_SZSH_001,endPush,true",
                "topicId,LIS_RuiMei_001,endPublish,false",
                "topicId,DIP_DongRuan_001,endPush,true",
                "topicId,EMR_HaiTai_001,endPush,false",
                "topicId,APP_ZHIKANG,endPush,false",
                "topicId,EMR_HaiTai_002,endPublish,true",
                "topicId,PACS_FeiTe_001,endPush,false",
                "topicId,PACS_JieShiDa_001,endPush,true",
                "topicId,JFW_DW,endPush,true",
                "topicId,AITEST,endPush,false",
        };
        new Thread(()->{
            while (true) {
                try {
                    Thread.sleep(50);
                    jedis.publish("CCTV-1", strings[random.nextInt(strings.length)]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();



    }
}


