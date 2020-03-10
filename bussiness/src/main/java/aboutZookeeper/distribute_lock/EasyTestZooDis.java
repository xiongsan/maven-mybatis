package aboutZookeeper.distribute_lock;

/**
 * Created by hairui on 2019/3/9.
 */
public class EasyTestZooDis {
    public static void main(String[] args) {
        final EasyTestZooDis easyTestZooDis = new EasyTestZooDis();

        new Thread(() -> {
            while (true){
                easyTestZooDis.function("123");
            }
        }).start();

        new Thread(() -> {
            while (true){
                easyTestZooDis.function("456");
            }
        }).start();

        new Thread(() -> {
            while (true){
                easyTestZooDis.function("789");
            }
        }).start();


    }

    private int num = 200;
    public void function(String userId){
        ZookeeperDisLock zookeeperDisLock = ZookeeperDisLock.getZookeeperDisLock();
        zookeeperDisLock.getLock(Thread.currentThread().toString(),"bussiness1");

        if(num>=20){
            num--;
            System.out.println(userId+":抢购完了一个");
        }
        else{
            System.out.println("抢购完,剩余"+num);
            zookeeperDisLock.releaseConnection();
        }
        zookeeperDisLock.releaseLock("bussiness1");
    }
}
