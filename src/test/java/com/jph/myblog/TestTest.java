package com.jph.myblog;

import com.jph.myblog.controller.TestController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@Slf4j
@SpringBootTest
public class TestTest {
    
    @Autowired
    private TestController testController;
    
    @Test
    public void uploadFile() throws IOException {

    }
}
