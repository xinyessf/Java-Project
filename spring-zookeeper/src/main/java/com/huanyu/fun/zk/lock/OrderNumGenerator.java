
package com.huanyu.fun.zk.lock;

import java.text.SimpleDateFormat;
import java.util.Date;

//生成订单号规则
public class OrderNumGenerator {
	private static int count = 0;

	//生成订单号规则方法
	public String orderNumber() {
		SimpleDateFormat simpt = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		return simpt.format(new Date()) + "-" + ++count;
	}

}
