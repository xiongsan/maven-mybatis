package proxy;

/**
 * description:静态代理；缺点是如果有很多接口，要去实现很多
 * Created by Wanghairui on 2017/6/1.
 */
public class AccountProxy implements Account {

    private Account accountImpl;

    public AccountProxy(Account accountImpl) {
        this.accountImpl = accountImpl;
    }

    //效果就是在执行被代理类方法之前，可以干一些其他事情，来增强方法功能性
    public void query(String id) {
        System.out.println("查询之前我要干一些事情");
    accountImpl.query(id);
        System.out.println("查询之后我要干一些事情");
    }

    public static void main(String[] args) {
        AccountProxy accountProxy = new AccountProxy(new AccountImpl());
        accountProxy.query("哇哈哈");

        AccountProxy accountProxy1 = new AccountProxy(new AccountImpl2());
        accountProxy1.query("哇哈哈");
    }
}
