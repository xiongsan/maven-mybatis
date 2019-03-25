import org.springframework.util.StringUtils;
import sun.applet.Main;

/**
 * Created by hairui on 2019/3/9.
 */
public class LockTest {
    int _int = 0;
    //局部变量不会引发线程安全问题。
    public  synchronized    void test(String param){
        _int += param.length();
        try {
            System.out.println(Thread.currentThread()+" 进param = [" + param + "]");
            System.out.println("-------------------------");
            System.out.println("-------------------------");
            System.out.println("-------------------------");
            System.out.println("-------------------------");
            System.out.println(Thread.currentThread()+" 出param = [" + param + "]");
            _int -= param.length();
            System.out.println(_int+"              --------int_---------");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lockTest.test("参数1");
            }
        }).start();
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lockTest.test("参数2");
            }
        }).start();
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lockTest.test("参数3");
            }
        }).start();
    }
}
