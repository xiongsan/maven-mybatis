package aboutZookeeper.distribute_lock.dis_test;

import aboutZookeeper.distribute_lock.ZookeeperDisLock;

import java.util.concurrent.CountDownLatch;

/**
 * Created by hairui on 2019/3/10.
 */
public class ZooDisFinalTest {

    public void go() {
        try {
            CountDownLatch startSignal = new CountDownLatch(1);
            CountDownLatch doneSignal = new CountDownLatch(100);
            for (int i = 0; i <= 100; ++i) { // create and start threads
                new Thread(new Worker(startSignal, doneSignal,i)).start();
            }
            long startTime = System.currentTimeMillis();
            startSignal.countDown(); // let all threads proceed,fair

            doneSignal.await();
            System.out.println("All processors done. Shutdown connection");
            System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
            System.out.println("a 商品剩余：" + SimulationDatabase.sum);
            System.out.println("获得a商品的用户数量：" + SimulationDatabase.killA.size());
            System.out.println("获得a商品的用户：" + SimulationDatabase.killA);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new ZooDisFinalTest().go();
    }

    class Worker implements Runnable {
        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;
        private final int userId;


        Worker(CountDownLatch startSignal, CountDownLatch doneSignal,int userId) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
            this.userId = userId;
        }

        public void run() {
            try {
                startSignal.await();
//				distributedLocker.lock("test", () -> {doTask(commodityId, userId);return null;});
                ZookeeperDisLock.getZookeeperDisLock().getLock(Thread.currentThread().toString(),Lock_Path.CERTAIN_BUSINESS);
                doTask(userId);
                ZookeeperDisLock.getZookeeperDisLock().releaseLock(Lock_Path.CERTAIN_BUSINESS);
            } catch (Exception e) {

            }
        }

        void doTask(int userId) {

            new SecondKill().reduce(userId);

            doneSignal.countDown();
        }
    }
}
