/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :Hairui
 * Date :2018/1/8
 * Time :9:33；
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class WaitNotifyTest {


    public static void main(String[] args) {
        Object o = new Object();
        WaitNotifyTest test = new WaitNotifyTest();
        new Thread(test.new T1(o)).start();
        new Thread(test.new T2(o)).start();
    }

    public class T1 implements Runnable{
        Object object;

        public T1(Object o){
            this.object = o;
        }

        @Override
        public void run() {
            try {
                synchronized (object){
                    object.wait();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(1111111111);
        }
    }

    public class T2 implements Runnable{

        Object object;

        public T2(Object o){
            this.object = o;
        }

        @Override
        public void run() {
            try {
                synchronized (object){
                    Thread.sleep(5000);
                    System.out.println(22222222);
                    object.notify();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
