package com.accenture.huaweigroup.service;

import com.accenture.huaweigroup.module.entity.User;
import com.accenture.huaweigroup.module.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    public boolean loginCheck(String userName, String userPwd) throws Exception {
        User user = userMapper.getUserByName(userName);
        if (user.getPwd().equals(userPwd)) {
            return true;
        }
        return false;
    }

    public boolean register(String userName, String userPwd) throws Exception {

        return false;
    }


    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    public void insert(User user) {
        //LOG.info("等待插入用户信息：", user);
        userMapper.insert(user);
    }
}
