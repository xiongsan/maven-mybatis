package aboutZookeeper.anotherWay;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :Hairui
 * Date :2018/4/14
 * Time :12:25
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class GlobalConstants {

    // zk服务器列表
    public static final String zkhosts = "192.168.20.197:2181";
    // 连接的超时时间
    public static final int sessionTimeout = 2000;
    // 服务在zk下的路径
    public static final String parentZnodePath = "/servers";

}
