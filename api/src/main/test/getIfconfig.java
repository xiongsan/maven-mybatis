import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :Hairui
 * Date :2018/3/26
 * Time :15:51
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class getIfconfig {
    public static void main(String[] args) {
        System.out.println(execShell());
    }
    public static String execShell(){
        String ip="";
        // 获取当前程序的运行进程对象
        Runtime runtime = Runtime.getRuntime();
        // 声明处理类对象
        Process process = null;
        // 返回行信息
        // 输入流
        InputStream is = null;
        // 字节流
        InputStreamReader isr = null;
        // 缓冲流
        BufferedReader br = null;
        // 结果
        try {
            // 运行PING命令
            process = runtime.exec("ifconfig|egrep 'Link|addr'");
            // 实例化输入流
            is = process.getInputStream();
            // 把输入流转换成字节流
            isr = new InputStreamReader(is);
            // 从字节中读取文本
            br = new BufferedReader(isr);
            String line="";
            while ((line = br.readLine()) != null) {
                ip+=line;
            }
            is.close();
            isr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            runtime.exit(1);
        }
        return ip;
    }
}
