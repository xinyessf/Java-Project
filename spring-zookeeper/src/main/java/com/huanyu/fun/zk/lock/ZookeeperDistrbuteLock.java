
package com.huanyu.fun.zk.lock;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;


public class ZookeeperDistrbuteLock extends ZookeeperAbstractLock {
	private CountDownLatch countDownLatch = null;

	@Override
	protected boolean tryLock() {
		try {
			zkClient.createEphemeral(PATH);
			return true;
		} catch (Exception e) {
		e.printStackTrace();
			return false;
		}
	}

	@Override
	protected void waitLock() {
		IZkDataListener zkDataListener = new IZkDataListener() {
			// 节点被删除的时候 事件通知
			public void handleDataDeleted(String path) throws Exception {
				// 唤醒被等待的线程
				if (countDownLatch != null) {
					countDownLatch.countDown();
				    System.out.println("删除节点.....");
				}
			}

			public void handleDataChange(String path, Object data) throws Exception {

			}
		};
		// 注册到zkclient进行监听
		zkClient.subscribeDataChanges(PATH, zkDataListener);
		if (zkClient.exists(PATH)) {
			countDownLatch = new CountDownLatch(1);
			try {
				countDownLatch.await();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		// 删除监听
		zkClient.unsubscribeDataChanges(PATH, zkDataListener);
	}

}
