import java.util.Properties;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :Hairui
 * Date :2018/3/19
 * Time :13:10
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class TestCharater {
    public static void main(String[] args) {
        Properties pps=System.getProperties();
        pps.list(System.out);
        System.out.println("--------------------以上为JVM的所有属性值-------------");
        System.out.print("系统默认的字符集为：");
        String name=System.getProperty("sun.jnu.encoding");
        System.out.print(name);
    }
}
