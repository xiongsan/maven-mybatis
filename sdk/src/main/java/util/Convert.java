package util;

import java.math.BigDecimal;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :王海瑞 2016/9/13
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏汇鑫融智软件科技有限公司 </p>
 */
public class Convert {
    public static String convertForUpdate(String s){
        String[] strings=s.split(",");
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<strings.length;i++){
            if(i<strings.length-1){
                sb.append(strings[i]+"="+"#" + "{" + strings[i] + "}"+","+"\n");
            }
            else{
                sb.append(strings[i]+"="+"#" + "{" + strings[i] + "}");
            }

        }
        return sb.toString();
    }

    public static String convertForInsert(String s){
        String[] strings=s.split(",");
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<strings.length;i++){
            if(i<strings.length-1){
                sb.append("#" + "{" + strings[i] + "}"+",");
            }
            else{
                sb.append("#" + "{" + strings[i] + "}");
            }

        }
        return sb.toString();
    }

    //eg
    static String ss = "reportId,a, b, c, e, f, g, h, i, l, m, n, o, q1, q2, q3, q4, x1, x2, x3, x4, y1, y2, y3, y4,modifor, modifyDate";
    public static void main(String[] args) {

        System.out.println(convertForUpdate(ss));
    }






public static String reverse(String originStr) {
              if(originStr == null || originStr.length() <= 1)
                       return originStr;
              return reverse(originStr.substring(1)) + originStr.charAt(0);
          }


    public static void function1(){
        StackTraceElement[] s = new Exception().getStackTrace();
        String getMethodName = s[1].getMethodName();
        System.out.println(getMethodName+"method");
    }
    public static void function2(){
        function1();
    }
    public static void function(){
        function1();
    }

    BigDecimal test(BigDecimal integer){
        if(integer.intValue()==1){
            return new BigDecimal(1);
        }
        return test(integer.subtract(new BigDecimal(1))).add(factorial(integer));
    }

    BigDecimal factorial(BigDecimal number) {
      if(number.intValue()==1){
          return new BigDecimal(1);
      }
       return number.multiply(factorial(number.subtract(new BigDecimal(1))));
    }

    private boolean function(int i){
            return i%2==0;
    }
    }
