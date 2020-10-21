package dubbo.consumer;

import dubbo.DemoService;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

/**
 * @author hairui
 * @date 2020/5/20 14:22
 * @description
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        context.start();
        DemoService demoService = context.getBean("demoService", DemoService.class);
        String hello = demoService.sayHello("world");
        System.out.println("result: " + hello);
    }
}
