import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :Hairui
 * Date :2018/4/17
 * Time :12:01
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        final  CountDownLatch _latch = new CountDownLatch(3);
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("one complete");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    if(_latch != null) {
                        _latch.countDown();
                    }
                }
            }
        });
        while (true){
            if(_latch.getCount()==2){
                service.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                            System.out.println("two complete");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        finally {
                            if(_latch != null) {
                                _latch.countDown();
                            }
                        }
                    }

                });
                break;
            }
        }
      while (true){
          if(_latch.getCount()==1){
              service.execute(new Runnable() {
                  @Override
                  public void run() {
                      try {
                          Thread.sleep(2000);
                          System.out.println("three complete");
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                      finally {
                          if(_latch != null) {
                              _latch.countDown();
                          }
                      }
                  }
              });
              break;
          }
      }
        _latch.await();
        System.out.println("---------all complete-----------");
        service.shutdown();
    }
}
