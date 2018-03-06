package util;

import bean.TodoList;
import com.alibaba.fastjson.*;
import com.fable.enclosure.bussiness.entity.ServiceRequest;

import java.math.BigDecimal;
import java.util.Map;
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
    private boolean function(int i){
            return i%2==0;
    }
    private boolean function1(int i){
        return !(i%2==1);
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

    //二分法查找元素
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

        boolean c= Pattern.matches("a*b", "aaaaab");
        System.out.println(b);
    }
    public static void main(String[] args) {
//        try {
//           Ia ia= (Ia) new Test().getClass().getClassLoader().loadClass("ForTest").newInstance();
//           ia.function();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        ServiceRequest<TodoList> param = JSON.parseObject("{serviceId: \"test\", method: \"getPageData\", pageNo: 1, pageSize: 10, param: {id:'1'}}", new TypeReference<ServiceRequest<bean.TodoList>>(){});
//        ServiceRequest<Map<String,Object>> param1= JSON.parseObject("{serviceId: \"test\", method: \"addTodo\", param: {sex: \"男\"}}", new TypeReference<ServiceRequest<Map<String,Object>>>(){});
//        System.out.println(param1);
        String json = "{id:123,name:456}";
        JSONObject jsonObject = JSONObject.parseObject(json);
        System.out.println(jsonObject.remove("id"));
        System.out.println(jsonObject);
    }
    }
