package com.jph.myblog;

import com.jph.myblog.utils.PathUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

@Slf4j
@SpringBootTest
public class PathTest {

    public static void main(String[] args) {
//        System.out.println(PathUtils.getImageSavePath());
    }

    @Test
    public void getPath() {
        String path = System.getProperty("java.class.path");
        System.out.println(path);
    }
}
