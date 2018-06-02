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
 * Time :10:33
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public abstract class Employee {
    public final String home = "dbss";
    abstract void doSomething();
   void sleep(){
       System.out.println("睡觉");
   }
}
