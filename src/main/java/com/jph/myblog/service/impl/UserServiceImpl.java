package com.jph.myblog.service.impl;

import com.jph.myblog.entity.User;
import com.jph.myblog.mapper.UserMapper;
import com.jph.myblog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByNameAndPwd(User user) {
        return userMapper.getUserByNameAndPwd(user);
    }
}
