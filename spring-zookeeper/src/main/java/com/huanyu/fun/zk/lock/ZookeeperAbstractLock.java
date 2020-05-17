
package com.huanyu.fun.zk.lock;

import org.I0Itec.zkclient.ZkClient;

//将重复的代码,具体业务逻辑有子类去实现.
public abstract class ZookeeperAbstractLock implements Lock {
	private static final String CONNECT_ADDRES = "192.168.73.128:2181,192.168.73.129:2181,192.168.73.130:2181";
	protected ZkClient zkClient = new ZkClient(CONNECT_ADDRES);
	protected static final String PATH = "/lock";

	public void getLock() {
		// tryLock() 创建zk临时节点 如果创建成功返回true 否则返回false
		if (tryLock()) {
			System.out.println("获取到锁的资源 get lock");
		} else {
			// 等待
			waitLock();
			// 重写获取锁的资源
			getLock();
		}

	}

	protected abstract boolean tryLock();

	protected abstract void waitLock();

	// 释放锁
	public void unLock() {
		if (zkClient != null) {
			zkClient.close();
		}
		System.out.println("释放锁的资源..");

	}

}
