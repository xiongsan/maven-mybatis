package redis.pubsub;

import aboutZookeeper.distribute_lock.ZookeeperDisLock;
import redis.clients.jedis.BinaryJedisPubSub;
import redis.clients.jedis.JedisPubSub;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :王海瑞 2016 11 22
 * </p>
 * <p>
 * Department :研发部
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */

public class RedisListener extends JedisPubSub {

    @Override
    public void unsubscribe() {
        super.unsubscribe();
    }

    @Override
    public void unsubscribe(String... channels) {
        super.unsubscribe(channels);
    }

    //取消置顶频道的订阅
    @Override
    public void subscribe(String... channels) {
        super.subscribe(channels);
    }

    @Override
    public void psubscribe(String... patterns) {
        super.psubscribe(patterns);
    }

    @Override
    public void punsubscribe() {
        super.punsubscribe();
    }

    @Override
    public void punsubscribe(String... patterns) {
        super.punsubscribe(patterns);
    }

    //订阅方收到消息回调
    private int _int = 0;
    @Override
    public  void onMessage(String channel, String message) {
//        ZookeeperDisLock.getZookeeperDisLock().getLock(Thread.currentThread().toString(),"test");
        _int += 111;

        System.out.println("channel："+channel+" and message："+message+"  _int值为"+_int);

        _int -= 111;
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {

    }

    //频道被订阅时回调
    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("channel:" + channel + " is been subscribed:" + subscribedChannels);
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {

    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {

    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println("频道:" + channel + "被关闭:已经订阅的怕频道数量为" + subscribedChannels);
    }
}