package com.huanyu.fun.thread.base;

import java.util.concurrent.CountDownLatch;

/**
 * @author
 * @version 1.0
 * @date
 */
public class CountDownLatchD {

    public static void main(String[] args) throws Exception {
        System.out.println("等待子线程执行完毕...");
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("子线程," + Thread.currentThread().getName() + "开始执行...");
                countDownLatch.countDown();// 每次减去1
                System.out.println("子线程," + Thread.currentThread().getName() + "结束执行...");
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("子线程," + Thread.currentThread().getName() + "开始执行...");
                countDownLatch.countDown();
                System.out.println("子线程," + Thread.currentThread().getName() + "结束执行...");
            }
        }).start();

        countDownLatch.await();// 调用当前方法主线程阻塞  countDown结果为0, 阻塞变为运行状态
        System.out.println("两个子线程执行完毕....");
        System.out.println("继续主线程执行..");
    }
}
