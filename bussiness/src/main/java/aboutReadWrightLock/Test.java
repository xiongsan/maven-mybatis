package aboutReadWrightLock;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by hairui on 2018/10/24.
 */
public class Test {
    private Object data = null;//共享数据，只能有一个线程能写该数据，但可以有多个线程同时读该数据ReadWriteLock rwl = new ReentrantReadWriteLock(public void get(){
    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    public void get() {
        rwl.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " be ready to read data!");
            Thread.sleep((long)(Math.random()*1000));
            System.out.println(Thread.currentThread().getName() + " have read data :" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwl.readLock().unlock();
        }
    }

    public void put(Object data) {
        rwl.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " be ready to write data!");
            Thread.sleep(10000);
            this.data = data;
            System.out.println(Thread.currentThread().getName() + " have write data: " + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwl.writeLock().unlock();
        }
    }


    public static void main(String[] args) {
        Test test = new Test();
        for(int i=0;i<3;i++){
            new Thread(() -> {
                while (true){
                    test.get();
                }

            },"ReadThread "+i).start();
            new Thread(() -> {
                while (true){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.put(new Random().nextInt(10000));
                }
            },"WWWWWWWWWWWWWWWWWWWriteThread "+i).start();
        }
    }
}
