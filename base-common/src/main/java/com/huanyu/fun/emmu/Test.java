package com.huanyu.fun.emmu;

public class Test {

    public static void main(String[] args) {

        new Thread(()->{
            while (true){
                System.out.println(123456);
            }
        }).start();
        new Thread(()->{
            while (true){
                System.out.println(123456);
            }
        }).start();
        new Thread(()->{
            while (true){
                System.out.println(123456);
            }
        }).start();

    }
}
