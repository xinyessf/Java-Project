package com.huanyu.fun.thread.communicate1;


public class ChiHuo  extends Thread{

    private BaoZi baozi;

    public ChiHuo(String name, BaoZi baozi) {
        super(name);
        this.baozi = baozi;
    }

    @Override
    public void run() {
       while(true){
           synchronized (baozi){
               if(baozi.flag==false){//没有包子
                   try {

                       baozi.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }

               }
               //有包子
               System.out.println("吃货正在吃包子");
               baozi.flag=false;
               baozi.notify();

           }
       }

    }
}