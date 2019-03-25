package aboutZookeeper;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :Hairui
 * Date :2018/4/13
 * Time :16:10
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class RegistryTest {
    public static void main(String[] args) throws InterruptedException {
        new ServiceRegistryImpl("192.168.0.105:2181").register("TestService","192.168.0.100:8089");
        Thread.sleep(Long.MAX_VALUE);
    }
}
