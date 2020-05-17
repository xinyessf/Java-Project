
package com.huanyu.fun.zk.lock;

//订单服务
public class OrderService implements Runnable {
	private OrderNumGenerator orderNumGenerator = new OrderNumGenerator();
	private static Object oj = new Object();
	private Lock lock=new ZookeeperDistrbuteLock();

	public void run() {
		getNumber();
	}

	public void getNumber() {
		// synchronized (oj) {
		lock.getLock();
		String number = orderNumGenerator.orderNumber();
		System.out.println(Thread.currentThread().getName() + ",生成订单号:" + number);
		lock.unLock();

	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(new OrderService()).start();
		}
	}

}
