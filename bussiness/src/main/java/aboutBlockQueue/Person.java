package aboutBlockQueue;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPObject;
import kafka.utils.json.JsonObject;

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
 * Date :2018/5/17
 * Time :10:28
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class Person extends Thread {

    public void run(){
        System.out.println(123);
    }

    public static void main(String[] args) {
        new Person().run();
    }
}
