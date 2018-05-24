package aboutBlockQueue;

import java.lang.reflect.ParameterizedType;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :Hairui
 * Date :2018/5/15
 * Time :10:46
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public abstract class SomClass<T> extends Thread {

    public SomClass() {

    }

    private Class<T> getTClass() {
        Class<T> tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return tClass;
    }
    public void run(){
        Class classs = getTClass();
//        if (classs == String.class) {
            System.out.println(classs.getCanonicalName()+"      "+classs.getName()+"     "+classs.getSimpleName());
//        }
    }
}
