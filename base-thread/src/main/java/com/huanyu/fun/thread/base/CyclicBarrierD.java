package com.huanyu.fun.thread.base;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author
 * @version 1.0
 * @date
 */
public class CyclicBarrierD {

    public static void main(String[] args) {
        //可以循环使用
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        //放行;如果达到临界就放行吧
        startBarrier(cyclicBarrier);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startBarrier(cyclicBarrier);

    }
    private static void startBarrier(CyclicBarrier cyclicBarrier) {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "开始===b");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + "结束===b");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("b线程:" + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
