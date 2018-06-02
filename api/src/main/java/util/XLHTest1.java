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
 * <p> Copyright : 江苏汇鑫融智软件科技有限公司 </p>
 */
public class XLHTest1 implements Serializable{
    public int age;
    public int height;
    public int weight;

    public XLHTest1(int age, int height, int weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public static void main(String[] args) {
        FileInputStream fs=null;
        ObjectInputStream os=null;
        try{
            fs = new FileInputStream("E:\\FileRecv\\x.ser");
            os = new ObjectInputStream(fs);
            XLHTest X=(XLHTest) os.readObject();
            System.out.println(X.age+","+X.height+","+ X.weight);
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
