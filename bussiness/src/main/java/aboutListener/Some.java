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
 * Time :16:09
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class Some implements ISome {
    @Override
    public void add(IListener listener) {
        User user = new User();
        user.setLoginName("123456666");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        listener.onEvent(user);
    }
}
