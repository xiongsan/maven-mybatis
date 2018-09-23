package aboutJson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
 * Date :2018/5/23
 * Time :14:44
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseI<T>{

    private User name;

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User getName() {
        return name;
    }

    public void setName(User name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BaseI{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}
