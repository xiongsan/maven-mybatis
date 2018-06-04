package util;

import java.io.*;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :王海瑞 2017/2/24
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件科技有限公司 </p>
 */
public class XLHTest implements Serializable{
    private static final long serialVersionUID=6546466156L;
    //当前序列化之后，生成一个文件对象流，包含此uid，
    //反序列化的时候会加载此类验证uid是否改变，uid改变，抛java.io.InvalidClassException异常
    public int age;
    public int height;
    public int weight;

    public XLHTest(int age, int height, int weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public static void main(String[] args) {
        XLHTest x = new XLHTest(20, 178, 70);
        FileOutputStream fs=null;
        ObjectOutputStream os=null;
        try{
            fs = new FileOutputStream("E:\\FileRecv\\x.ser");
            os = new ObjectOutputStream(fs);
            os.writeObject(x);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            if(os!=null)
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(fs!=null){
                try {
                    fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
