package com.jph.myblog;

import com.jph.myblog.utils.PathUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

@SpringBootApplication
@MapperScan("com.jph.myblog.mapper")
public class MyBlogApplication {

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(MyBlogApplication.class, args);
    }

}
