package aboutAbstract;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :Hairui
 * Date :2018/5/25
 * Time :10:35
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class GroupOne extends Employee{
    @Override
    void doSomething() {
        System.out.println("--流水线--");
        System.out.println(super.home);
    }
}
