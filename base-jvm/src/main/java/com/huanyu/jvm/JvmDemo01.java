package com.huanyu.jvm;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * jvm参数设置
 * 
 * @author Administrator
 *
 */
public class JvmDemo01 {

	public static void main(String[] args) throws Exception {
		byte[] b1 = new byte[1 * 1024 * 1024];
		System.out.println("分配了1m");
		jvmInfo();
		Thread.sleep(3000);
		byte[] b2 = new byte[4 * 1024 * 1024];
		System.out.println("分配了4m");
		Thread.sleep(3000);
		jvmInfo();
		System.out.println("test2========");
		test2();

	}
	static public void test2() throws  Exception{

		List<Object> list = new ArrayList<>();
		Thread.sleep(3000);
		jvmInfo();
		for (int i = 0; i < 10; i++) {
			System.out.println("i:"+i);
			Byte [] bytes=	new Byte[1*1024*1024];
			list.add(bytes);
			jvmInfo();
		}
		System.out.println("添加成功...");

	}


	/**
	 * 转换为m
	 * 
	 * @param maxMemory
	 * @return
	 */
	static private String toM(long maxMemory) {
		float num = (float) maxMemory / (1024 * 1024);
		DecimalFormat df = new DecimalFormat("0.00");// 格式化小数
		String s = df.format(num);// 返回的是String类型
		return s;
	}

	static private void jvmInfo() {
		// 最大内存
		long maxMemory = Runtime.getRuntime().maxMemory();
		System.out.println("maxMemory:" + maxMemory + ",转换为M:" + toM(maxMemory));
		// 当前空闲内存
		long freeMemory = Runtime.getRuntime().freeMemory();
		System.out.println("freeMemory:" +freeMemory+",转换为M:"+toM(freeMemory));
		// 已经使用内存
		long totalMemory = Runtime.getRuntime().totalMemory();
		System.out.println("totalMemory:" +totalMemory+",转换为M"+toM(totalMemory));
	}

}
