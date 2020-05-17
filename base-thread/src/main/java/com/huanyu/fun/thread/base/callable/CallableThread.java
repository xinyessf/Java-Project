package com.huanyu.fun.thread.base.callable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class CallableThread implements Callable<Map<String, Integer>> {
    //传递进来的参数
    int data;
    private Map<String, Integer> map = new HashMap<String, Integer>();//定义需要返回的map
    private final CountDownLatch latch;

    public CallableThread(int data, CountDownLatch latch) {
        this.data = data;
        this.latch = latch;
    }

    public Map<String, Integer> call() throws Exception {
        try {
            //每个参数手动增加100
            data += 100;
            map.put("data", data);
            System.out.println("线程：" + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
        return map;
    }
}
