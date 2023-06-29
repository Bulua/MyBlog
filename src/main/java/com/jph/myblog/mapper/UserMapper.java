package com.jph.myblog.mapper;

import com.jph.myblog.entity.User;

public interface UserMapper {

    public User getUserByNameAndPwd(User user);
}
