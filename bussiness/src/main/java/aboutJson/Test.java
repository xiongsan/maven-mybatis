package aboutJson;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :Hairui
 * Date :2018/5/23
 * Time :13:26
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class Test {
    private BaseParam getResponse(){
        return new GeneralResponse("123");
    }

    public static void main(String[] args) {
        System.out.println(new Test().getResponse());
    }
}
