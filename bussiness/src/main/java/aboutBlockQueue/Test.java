package aboutBlockQueue;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :Hairui
 * Date :2018/5/14
 * Time :14:23
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
    new Thread(new Runnable() {
        @Override
        public void run() {
            while (true){
                String value= null;
                try {
                    Thread.sleep(300);
                    value = Constants.queue.take();//阻塞方法
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费队列数据"+value);
            }
        }
    }).start();
            Thread.sleep(3000);
        new Thread(new Runnable() {
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(500);
                    Constants.queue.put(String.valueOf(System.currentTimeMillis()));//阻塞方法
                    System.out.println("queue size="+Constants.queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }).start();
    }

}
