package dubbo.provider;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

/**
 * @author hairui
 * @date 2020/5/20 14:16
 * @description
 */
public class Provider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-provider.xml");
        context.start();
        System.in.read();
    }

}
