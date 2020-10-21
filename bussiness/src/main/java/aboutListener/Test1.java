package aboutListener;

import entity.User;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :Hairui
 * Date :2018/5/30
 * Time :9:59
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class  Test1 {
    public static void main(String[] args) {
        Some iSome = new Some();
//        iSome.add(new IListener() {
//            @Override
//            public void onEvent(String message) {
//                System.out.println(message);
//            }
//        });
//        iSome.add(message -> System.out.println(message));
        //jdk8lamb表达式
        iSome.add(System.out::println);
        iSome.send();

    }
}
