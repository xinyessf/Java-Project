
package com.huanyu.service.impl;


import com.huanyu.service.UserService;

public class UserServiceImpl implements UserService {

    public String getUserId(Integer id) {
        System.out.println("被客户端(消费者)消费....id:" + id);
        if (id == 1) {
            return "111";
        }
        if (id == 2) {
            return "222";
        }
        if (id == 1) {
            return "333";
        }
        return "未找到...";
    }

}
