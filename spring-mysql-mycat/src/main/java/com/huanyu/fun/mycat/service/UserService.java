package com.huanyu.fun.mycat.service;

import java.util.List;

import com.huanyu.fun.mycat.entity.UserEntity;
import com.huanyu.fun.mycat.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	public List<UserEntity> findUser() {
		return userMapper.findUser();
	}

	public List<UserEntity> insertUser(String userName) {
		return userMapper.insertUser(userName);
	}

}
