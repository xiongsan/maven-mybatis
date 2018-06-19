/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :Hairui
 * Date :2018/4/19
 * Time :9:07
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class HanoiTest {
    public static void main(String[] args) {
        function(3,'a','b','c');
    }

    public static void function(int i,char a,char b,char c){
        if(i==1){
            System.out.println("移动第 "+i+" 个盘子 from "+a+" to "+c);
        }
        else{
            function(i-1,a,c,b);
            System.out.println("移动第 "+i+" 个盘子 from "+a+" to "+c);
            function(i-1,b,a,c);
        }
    }
}