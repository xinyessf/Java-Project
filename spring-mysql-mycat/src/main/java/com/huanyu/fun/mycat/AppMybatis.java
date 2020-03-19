package com.huanyu.fun.mycat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.huanyu.fun.mycat.mapper")
public class AppMybatis {

	public static void main(String[] args) {
		SpringApplication.run(AppMybatis.class, args);
	}

}
