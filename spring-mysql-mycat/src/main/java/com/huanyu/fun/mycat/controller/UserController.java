package com.huanyu.fun.mycat.controller;

import java.util.List;

import com.huanyu.fun.mycat.entity.UserEntity;
import com.huanyu.fun.mycat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/findUser")
	public List<UserEntity> findUser() {
		return userService.findUser();
	}

	@RequestMapping("/insertUser")
	public List<UserEntity> insertUser(String userName) {
		return userService.insertUser(userName);
	}

}
