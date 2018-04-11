package springRmiClient.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import springRmiClient.service.IRmiService;

/**
 * Created by 张少昆 on 2017/8/23.
 */
@Configuration
public class RmiClientConfig {
    //创建rmi的代理

    @Bean( name = "rmiProxy" )
    public RmiProxyFactoryBean rmiProxyFactoryBean(){
        RmiProxyFactoryBean proxy = new RmiProxyFactoryBean();
        //访问rmi，ip，端口，和rmi名字
        proxy.setServiceUrl("rmi://localhost:9999/IRmiService");
        //设置代理类代理的接口
        proxy.setServiceInterface(IRmiService.class);

        proxy.afterPropertiesSet();

        return proxy;
    }
}
