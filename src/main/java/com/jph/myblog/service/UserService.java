package com.jph.myblog.service;

import com.jph.myblog.entity.User;

public interface UserService {

    User getUserByNameAndPwd(User user);
}
