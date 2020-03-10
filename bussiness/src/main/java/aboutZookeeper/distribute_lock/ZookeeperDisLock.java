package aboutZookeeper.distribute_lock;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

/**
 * Created by hairui on 2019/3/9.
 */
public class ZookeeperDisLock implements Watcher{

    private ZooKeeper zoo;

    private String lockPrefix = "/dis_lock_";

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    private static ZookeeperDisLock zookeeperDisLock = null;

    private ZookeeperDisLock(){

    }

    public static ZookeeperDisLock getZookeeperDisLock(){
        if (zookeeperDisLock==null){
            zookeeperDisLock = new ZookeeperDisLock();
            zookeeperDisLock.connect();
            return zookeeperDisLock;
        }
        return zookeeperDisLock;
    }
    private void connect(){
        this.releaseConnection();
        try {
            zoo = new ZooKeeper("192.168.0.107:2181", 10000, this);
            countDownLatch.await();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 关闭ZK连接
     */
    public void releaseConnection() {
        if (this.zoo != null) {
            try {
                this.zoo.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void getLock(String thread,String lockId) {
        String path = lockPrefix + lockId;
        try {
            zoo.create(path, "***".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            System.out.println("ZookeeperDisLock.releaseLock thread:"+thread+"lockId:"+lockId+"   锁业务已经开始");
        }
        catch (Exception e){
            while (true){
                try{
                    zoo.create(path, "***".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                    System.out.println("ZookeeperDisLock.releaseLock thread:"+thread+"lockId:"+lockId+"   锁业务已经开始");
                    break;
                }
                catch (Exception e1){
                    ;
                }
            }
        }
    }

    public void releaseLock(String lockId){
        String path = lockPrefix + lockId;
        try {
            zoo.delete(path,-1);
            System.out.println("ZookeeperDisLock.releaseLock    "+lockId+"   锁业务已经完成,现在释放");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (Watcher.Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            this.countDownLatch.countDown();
            System.out.println("zookeeper 已经连接");
        }

    }
}
