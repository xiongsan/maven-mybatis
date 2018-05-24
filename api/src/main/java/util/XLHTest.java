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
    private int age;
    private int height;
    private int weight;

    public XLHTest(int age, int height, int weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public static void main(String[] args) throws IOException {
        XLHTest x = new XLHTest(20, 178, 70);
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        File file = new File("E:/FileRecv/x.ser");
        if(!file.exists()){
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdir();
                file.createNewFile();
            }
        }
        try{
            fos = new FileOutputStream("E:/FileRecv/x.ser");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(x);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            if(oos!=null)
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
            FileInputStream fis=null;
            ObjectInputStream ois=null;
            try{
                fis = new FileInputStream("E:\\FileRecv\\x.ser");
                ois = new ObjectInputStream(fis);
                XLHTest X=(XLHTest) ois.readObject();
                System.out.println(X);
            }catch(Exception ex){
                ex.printStackTrace();
            }
            finally {
                if(ois!=null)
                    try {
                        ois.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                if(fis!=null){
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
    }

    @Override
    public String toString() {
        return "XLHTest{" +
                "age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
