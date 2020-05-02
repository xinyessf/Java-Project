package com.huanyu.fun.mapper;

import com.huanyu.fun.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    public User getUser(int id);

    public User delUser(int id);


    @Select("select * from users where id = ${id};")
    public User getUserI(@Param("id") String id);

}
