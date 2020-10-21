package exceptiontest;

/**
 * @author hairui
 * @date 2020/3/11 22:58
 * @description
 */
public class Test {
    public static void main(String[] args) throws MyException {
        try {
            new Test().test1();
        } catch (MyException e) {
            e.printStackTrace();
            throw new MyException("123");
        }
        System.out.println(123);
    }



    public void test1() throws MyException{
        throw new MyException("test1()出现异常了");
    }

    public void test3() throws MyException{
        throw new MyException("test3()出现异常了");
    }
}
