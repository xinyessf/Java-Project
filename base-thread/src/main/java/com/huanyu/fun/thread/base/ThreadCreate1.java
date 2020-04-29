package com.huanyu.fun.thread.base;

/**
 * @author
 * @version 1.0
 * @date
 */
public class ThreadCreate1 {

    static class MyThread extends Thread{
        //重写run()方法
        public void run(){
            for(int i = 0;i < 10; i++){
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void testCreate(){
        //lambda
        //设置线程名字
        MyThread myThread = new MyThread();
        Thread.currentThread().setName("main thread");
        myThread.setName("子线程:");
        //开启线程
        myThread.start();
        for(int i = 0;i<5;i++){
            System.out.println(Thread.currentThread().getName());
        }

    }
    public static void testCreate2(){
        //lambda
        new Thread(() -> {
            for (int b = 0; b < 5; b++) {
                System.out.println(Thread.currentThread().getName() + " " + b);
            }
        },"线程1").start();

    }
    public static void main(String[] args) {
        testCreate();
        //testCreate2();
    }
}
