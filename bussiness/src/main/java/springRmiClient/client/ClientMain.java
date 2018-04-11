package springRmiClient.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springRmiClient.service.IRmiService;

/**
 * Created by 张少昆 on 2017/8/23.
 */
public class ClientMain {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        IRmiService object = context.getBean("rmiProxy",IRmiService.class);
        System.out.println("开始去执行");
    }
}
