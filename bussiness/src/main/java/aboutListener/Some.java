package aboutListener;

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

    private IListener listener;

    @Override
    public void add(IListener listener) {
        this.listener = listener;
    }

    public void send(){
        for (int i=0;i<10;i++)
        {
            listener.onEvent("123546");
        }
    }
}
