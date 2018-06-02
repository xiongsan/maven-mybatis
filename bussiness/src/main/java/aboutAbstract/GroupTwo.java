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
 * Time :10:36
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class GroupTwo extends Employee {
    @Override
    void doSomething() {
        System.out.println("--发工资--");
        this.sleep();
        super.sleep();
    }

    public static void main(String[] args) {
        new GroupOne().doSomething();
        new GroupTwo().doSomething();
//        simple:
//        do {
//                if(1==2){
//                    break simple;
//                }
//        } while (true);
    }
}
