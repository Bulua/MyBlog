package com.jph.myblog;

import com.jph.myblog.entity.User;
import com.jph.myblog.mapper.UserMapper;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getUser() {
//        User user = User.builder().id(1).username("admin").password("123").roleId(0).build();
        User user = User.builder().username("admin").build();
        User result = userMapper.getUserByNameAndPwd(user);
        System.out.println(result);
    }

    @Test
    public void insertUser() {
        User user = User.builder().username("admin").password("123").roleId(0).build();
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), "salt", 5);
        System.out.println(md5Hash.toHex());
    }

}
