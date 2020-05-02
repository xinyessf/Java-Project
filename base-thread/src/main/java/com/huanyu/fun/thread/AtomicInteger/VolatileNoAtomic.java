package com.huanyu.fun.thread.AtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileNoAtomic extends Thread {
	static int count = 0;
	private static AtomicInteger atomicInteger = new AtomicInteger(0);

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			//等同于i++
			atomicInteger.incrementAndGet();
		}
		System.out.println(atomicInteger.get());
		//System.out.println(count);
	}

	public static void main(String[] args) {
		// 初始化10个线程
		VolatileNoAtomic[] volatileNoAtomic = new VolatileNoAtomic[10];
		for (int i = 0; i < 10; i++) {
			// 创建
			volatileNoAtomic[i] = new VolatileNoAtomic();
		}
		for (int i = 0; i < volatileNoAtomic.length; i++) {
			volatileNoAtomic[i].start();
		}
	}

}
