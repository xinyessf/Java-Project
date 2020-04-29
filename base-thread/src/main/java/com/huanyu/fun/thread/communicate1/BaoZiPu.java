package com.huanyu.fun.thread.communicate1;


public class BaoZiPu extends Thread {
    private BaoZi baozi;

    public BaoZiPu(String name, BaoZi baozi) {
        super(name);
        this.baozi = baozi;
    }

    @Override
    public void run() {
        int count=0;
        //没有包子造
        while(true){
            synchronized (baozi){
                if(baozi.flag==true){
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //没有包子开始造
                System.out.println("包子铺开始做包子");
                baozi.flag=true;
                baozi.notify();

            }

        }

        


    }
}