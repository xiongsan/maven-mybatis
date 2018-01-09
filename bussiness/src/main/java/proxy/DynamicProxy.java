package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 * Created by Wanghairui on 2017/6/1.
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }
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

    public static void main(String[] args) {
        //第一种方式
        DynamicProxy proxy = new DynamicProxy();
        // 在这里进行真正的对象传入,你们才是熊孩子，我现在已经是熊大人了
        Account account= (Account )proxy.getInstance(new AccountImpl());
        account.query("娃哈哈");

        //第二种方式不需要用Proxy.newProxyInstance，反射的事我们自己来实现
        DynamicProxy proxy1 = new DynamicProxy();
        proxy1.setTarget(new AccountImpl());
        try {
            proxy1.invoke(proxy, Class.forName("proxy.AccountImpl").getMethod("query", String.class),new Object[]{"爹哈哈"});
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        //代理AccountImpl2
        DynamicProxy proxy2 = new DynamicProxy();
        // 在这里进行真正的对象传入,你们才是熊孩子，我现在已经是熊大人了
        Account account2= (Account )proxy.getInstance(new AccountImpl2());
        account2.query("爷哈哈");
    }
}
