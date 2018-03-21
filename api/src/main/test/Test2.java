
import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :Hairui
 * Date :2018/3/21
 * Time :9:54
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class Test2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "C:/Program Files/apache-tomcat-8.5.16/webapps/ui";
        System.out.println(str.indexOf("/webapps12"));
        str = str.substring(0, str.indexOf("/webapps12"));
        System.out.println(str.substring(0,str.lastIndexOf("/")));
    }
}
