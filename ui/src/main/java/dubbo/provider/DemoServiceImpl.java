package dubbo.provider;

import dubbo.DemoService;

/**
 * @author hairui
 * @date 2020/5/20 14:11
 * @description
 */
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello "+name;
    }
}
