package com.huanyu.fun.mycat.mapper;

import java.util.List;

import com.huanyu.fun.mycat.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {
	@Select("SELECT user_name as userName FROM  user ")
	public List<UserEntity> findUser();

	@Select("insert into user values (#{userName}); ")
	public List<UserEntity> insertUser(@Param("userName") String userName);
}
