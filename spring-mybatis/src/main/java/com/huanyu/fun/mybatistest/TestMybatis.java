package com.huanyu.fun.mybatistest;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

import com.huanyu.fun.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestMybatis {
    public static void main(String[] args) throws IOException {

    }

    public static void select() throws IOException {
        String resource = "mybatis.xml";
        // 读取配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        // 获取会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession openSession = sqlSessionFactory.openSession();
        // 查询
        String sql = "com.huanyu.fun.mapper.UserMapper.getUser";
        // 调用api查询
        User user = openSession.selectOne(sql, 1);
        System.out.println(user.toString());
    }

    static public void delUser() throws IOException{
        String resource = "mybatis.xml";
        // 读取配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        // 获取会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession openSession = sqlSessionFactory.openSession();
        // 查询
        String sql = "com.huanyu.fun.mapper.UserMapper.delUser";
        int reuslt = openSession.delete(sql,1);
        System.out.println(reuslt);
    }


}
