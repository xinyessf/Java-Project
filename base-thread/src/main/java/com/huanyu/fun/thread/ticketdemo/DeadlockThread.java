package com.huanyu.fun.thread.ticketdemo;

class ThreadTrain6 implements Runnable {
	// 这是货票总票数,多个线程会同时共享资源
	private int trainCount = 100;
	public boolean flag = true;
	private Object mutex = new Object();

	@Override
	public void run() {
		if (flag) {
			while (true) {
				synchronized (mutex) {
					// 锁(同步代码块)在什么时候释放？ 代码执行完， 自动释放锁.
					// 如果flag为true 先拿到 obj锁,在拿到this 锁、 才能执行。
					// 如果flag为false先拿到this,在拿到obj锁，才能执行。
					// 死锁解决办法:不要在同步中嵌套同步。
					sale();
				}
			}
		} else {
			while (true) {
				sale();
			}
		}
	}
	public synchronized void sale() {
		synchronized (mutex) {
			if (trainCount > 0) {
				try {
					Thread.sleep(40);
				} catch (Exception e) {

				}
				System.out.println(Thread.currentThread().getName() + ",出售 第" + (100 - trainCount + 1) + "张票.");
				trainCount--;
			}
		}
	}
}
public class DeadlockThread {
	public static void main(String[] args) throws InterruptedException {
		ThreadTrain6 threadTrain = new ThreadTrain6(); // 定义 一个实例
		Thread thread1 = new Thread(threadTrain, "一号窗口");
		Thread thread2 = new Thread(threadTrain, "二号窗口");
		thread1.start();
		Thread.sleep(40);
		threadTrain.flag = false;
		thread2.start();
	}

}
