package com.huanyu.fun.thread.base.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(5);
        ExecutorService pool = Executors.newFixedThreadPool(5);
        List list = new ArrayList();
        try {
            for (int j = 0; j < 5; j++) {
                Callable<Map<String, Integer>> c1 = new CallableThread(j, latch);
                Future<Map<String, Integer>> f1 = pool.submit(c1);
                list.add(f1);
            }
            latch.await();
            for (int i = 0; i < list.size(); i++) {
                Future<Map<String, Integer>> f1 = (Future<Map<String, Integer>>) list.get(i);
                System.out.println((Integer) f1.get().get("data"));
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
