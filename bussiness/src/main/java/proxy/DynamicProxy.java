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
        //第一种方式
        DynamicProxy proxy = new DynamicProxy();
        Class claszz = AccountImpl.class;
        Method m = claszz.getMethod("query", String.class);
        Account object=(Account)proxy.getInstance(new AccountImpl());
//        Assert.notNull(m.getAnnotation(Transactional.class),"这个不能为空");
        proxy.invoke(proxy,m,new Object[]{"test"});

        AccountImpl account=new AccountImpl();
        System.out.println(account);
//
//        Account account2= (Account )proxy.getInstance(new AccountImpl2());
//        account2.query("爷哈哈");
//
//        DynamicProxy clasz =
//        DynamicProxy.class.newInstance();
//        Account account1=(Account)clasz.getInstance(new AccountImpl());
//        account1.query("123");

    }
}
