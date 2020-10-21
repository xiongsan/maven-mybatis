package util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.jasypt.digest.config.StringDigesterConfig;

import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public class Convert {
    /**
     *
     * @param originalSql
     * @return
     */
    private static String convertSqlForEntitySelect(String originalSql){
        String[] strings=originalSql.split(",");
        String newString = "";
        for(int i=0;i<strings.length;i++){
            String string = strings[i];
            int index = string.indexOf("_");
            if(index!=-1){
                String old = string.charAt(index) + "" + string.charAt(index + 1);
                String newS = ("" + string.charAt(index + 1)).toUpperCase();
                if(i!=strings.length-1){
                    if(i==0){
                        newString +=string+" "+string.replace(old, newS).split(" ")[1] +",\n";
                    }
                    else{
                        newString += string +" " +string.replace(old, newS) +",\n";
                    }
                }
                else{
                    newString +=string.split(" ")[1]+" " +string.replace(old, newS);
                }
            }
            else{
                if(i!=strings.length-1){
                    newString += string +",\n";
                }
                else{
                    newString += string+"\n";
                }
            }
        }
        String test = newString.substring(0, newString.indexOf("from"));
        String string[] = test.split("\n");
        String result="";
        for(int i=0;i<string.length;i++){
            String[] strss=string[i].split(" ");
            if(strss.length==2){
                String s0=string[i].split(" ")[0];
                String s1=string[i].split(" ")[1];
                if(s1.contains("_")){
                    String s2 = stringConvert(s1);
                    result+=s0+" "+s2 +"\n";
                }
                else{
                    result+=string[i]+"\n";
                }
            }
            else{
                result+=string[i]+"\n";
            }

        }

        return result;
    }

    private static String stringConvert(String string){
        int index=string.indexOf("_");
        if(index!=-1){
            String old = string.charAt(index) + "" + string.charAt(index + 1);
            String newS = ("" + string.charAt(index + 1)).toUpperCase();
            string =string.replace(old, newS);
        }
        if(string.contains("_")){
            stringConvert(string);
        }
        return string;
    }

    private String convertSqlForEntityUpdate(String originalSql){
        String[] strings=originalSql.split(",");
        String newString = "";
        for(int i=0;i<strings.length;i++){
            String string = strings[i];
            int index = string.indexOf("_");
            if(index!=-1){
                String old = string.charAt(index) + "" + string.charAt(index + 1);
                String newS = ("" + string.charAt(index + 1)).toUpperCase();
                    if(i==0){
                        newString +=string+"=#{"+string.replace(old, newS).split(" ")[1] +"},\n";
                    }
                    else{
                        newString += string +"=#{" +string.replace(old, newS) +"},\n";
                    }
            }
            else{
                    newString += string +"=#{"+string +"},\n";
            }
        }
        return newString;
    }

    private static String convertSqlForEntityInsert(String originalSql){
        String[] strings=originalSql.split(",");
        String newString = "";
        for(int i=0;i<strings.length;i++){
            String string = strings[i];
            int index = string.indexOf("_");
            if(index!=-1){
                String old = string.charAt(index) + "" + string.charAt(index + 1);
                String newS = ("" + string.charAt(index + 1)).toUpperCase();
                if(i!=strings.length-1){
                    if(i==0){
                        newString +=string.replace(old, newS).split(" ")[1] +",";
                    }
                    else{
                        newString += string.replace(old, newS) +",";
                    }
                }
                else{
                    newString +=string.replace(old, newS);
                }
            }
            else{
                if(i!=strings.length-1){
                    newString += string +",";
                }
                else{
                    newString += string+"";
                }
            }
        }
        return newString;
    }
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
//    public static void main(String[] args) {
//        match();
//        System.out.println("说是我是是说说是我是是说说是我是是说说是我是是说说是我是是说说是我是是说".length());
////        System.out.println(convertForUpdate(ss));
//    }





      //反转字符串
     public static String reverse(String originStr) {
              if(originStr == null || originStr.length() <= 1)
                       return originStr;
              return reverse(originStr.substring(1)) + originStr.charAt(0);
          }

    //获取谁调用了我的方法
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

    //1!+2!+3!+....n!
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

    //判断是否偶数
    private static boolean function(int i){
            return i%2==0;
    }
    private static boolean isOdd(int i){
        return i % 2 == 1;
    }

    //json转化
    public  void test2() {
        String json ="{'name':'亲亲宝宝','address':'亲亲宝宝','array':['1','2','3']}";
        try {
            JSONObject jsonObject = JSONObject.parseObject(json);
            String name = jsonObject.getString("name");
            String address = jsonObject.getString("address");
            System.out.println("name is:" + name);
            System.out.println("address is:" + address);
            JSONArray jsonArray = jsonObject.getJSONArray("array");
            for (int i = 0; i < jsonArray.size(); i++) {
                System.out.println("item " + i + " :" + jsonArray.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    //冒泡排序
    private static void rank(int[] array) {
        //需要比较的次数为（array.length-1）
        for(int i=0;i<array.length-1;i++){
            //每次比较会出来一个最大或者最小，就无需再比较了所以减去i
            for(int j=0;j<array.length-1-i;j++){
                int temp;
                if(array[j]<array[j+1]){
                    temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }
            }
        }
        for(int i:array){
            System.out.print(i+",");
        }
    }

    //二分法查找元素，顺序排列
    public static int erFenfa(int[] arr,int number) {

        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (number < arr[middle]) {
                end = middle - 1;
            } else if (number > arr[middle]) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }


        //正则表达式
    public static void match(){
        //不能以_.-开头和结尾，包含0-9a-zA-Z中文-（）.。_1到30个字符
        Pattern pattern = Pattern.compile("^(?![-._])(?!.*?[-._]$)[a-zA-Z0-9_\\u4e00-\\u9fa5（）\\-.。]{1,30}$");
        Matcher matcher = pattern.matcher("sdfgsd我._是。-（）");
        boolean b=matcher.matches();

        Pattern pattern1 = Pattern.compile("((25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)|\\*))");

        boolean c= Pattern.matches("a*b", "aaaaab");
//        System.out.println(b);
        Matcher matcher1 = pattern1.matcher("192.168.20.12365");
        boolean d = matcher1.matches();
        System.out.println(d+"------------");
    }
    public int[] findCardPosition(int n){
        //原索引
        List<Integer> tempIndex = new ArrayList<>();
        //移动后的索引
        List<Integer> resultIndex = new ArrayList<>();
        //原排列数组
        int[] originalValue = new int[n];
        //原索引赋值
        for(int i=0;i<n;i++){
            tempIndex.add(i);
        }
        //计算移动后的索引
        while(tempIndex.size()>0){
            resultIndex.add(tempIndex.get(0));
            tempIndex.remove(0);
            if(tempIndex.size()>0){
                //原索引第二位放到末位（下面将首位移除，第二位变成了第一位）
                tempIndex.add(tempIndex.get(0));
                //从原索引中在移除第二位
                tempIndex.remove(0);
            }
        }
        //索引再和结果一一对应（此处的结果值是12345.。n顺序排列）
        for(int i=0,j=i+1;i<resultIndex.size();i++,j++){
            originalValue[resultIndex.get(i)]=j;
        }
        System.out.println(Arrays.toString(originalValue));
        return originalValue;


    }
    public static void main(String[] args) throws Exception{
         //插入
        System.out.println(convertForInsert(convertSqlForEntityInsert("id, unit_name, unit_address, social_credit_code, charge_person, phone_no, legal_person, email, create_date, state, unit_prop, central_dept, postal_code, cer_type").replaceAll(" ","")));
        //查询
    }

    public void url() throws Exception{
        URLDecoder.decode("", "UTF-8");
    }
    }
