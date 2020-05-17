package com.huanyu.jvm;

public class JvmDemo02 {

	 public static void main(String[] args) {
		//-Xms20m -Xmx20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
		 byte [] b = null;
		 for (int i = 0; i < 10; i++) {
			b =new byte[1*1024*1024];
		}
		 
	}




}
