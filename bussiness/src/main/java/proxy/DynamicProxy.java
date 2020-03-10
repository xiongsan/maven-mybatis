package proxy;

import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 * Created by Wanghairui on 2017/6/1.
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;

    /**
     * 绑定委托对象并返回一个代理类
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        System.out.println("before");
        //执行方法
        result=method.invoke(target, args);
        System.out.println("after");
        return result;
    }

    public static void main(String[] args) throws Throwable {

        DynamicProxy proxy = new DynamicProxy();
        //生成代理对象
        Account account2= (Account )proxy.getInstance(new AccountImpl2());
        account2.query("爷哈哈");

    }
}
