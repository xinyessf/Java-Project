package com.huanyu.fun.thread.base;

import java.util.concurrent.Semaphore;

/**
 * @author
 * @version 1.0
 * @date
 */
public class SempahopD {
    public static void main(String[] args) {
        //
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}
