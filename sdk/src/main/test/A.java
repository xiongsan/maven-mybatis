import jdk.nashorn.internal.objects.annotations.Function;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :Hairui
 * Date :2018/1/18
 * Time :15:05
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class A implements Ia{

    public void function(){
        try {
            Class<?> c=this.getClass();
            Method[] m=c.getDeclaredMethods();
            for (Method m1:m){
                if(m1.isAnnotationPresent(Transactional.class)){
                    System.out.println("???");
                }
                if(m1.getName().equals("doSomething")){
                    m1.invoke(this);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
