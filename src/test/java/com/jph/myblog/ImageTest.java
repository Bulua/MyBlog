package com.jph.myblog;

import com.jph.myblog.entity.Image;
import com.jph.myblog.entity.ImageCategory;
import com.jph.myblog.mapper.ImageMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
public class ImageTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ImageMapper imageMapper;

    @Test
    void insertImage() {
        Image image1 = Image.builder().imageName("测试图2")
                .url("D:\\ProjectWorkspace\\Idea\\MyBlog\\imgs\\2023\\04\\0fbb917635e0e5e1e9ff1618d7b02122.jpeg")
                .category(new ImageCategory(1)).build();
        Image image2 = Image.builder().imageName("测试图3")
                .url("D:\\ProjectWorkspace\\Idea\\MyBlog\\imgs\\2023\\04\\0fbb917635e0e5e1e9ff1618d7b02122.jpeg")
                .category(new ImageCategory(2)).build();
        List<Image> images = new ArrayList<>();
        images.add(image1);
        images.add(image2);
        int count = imageMapper.batchInsertImage(images);
        System.out.println(count);
    }

    @Test
    void selectImagesByYearAndCategory() {
//        Page<Image> page = new Page<>(1, 13);
        List<Image> images = imageMapper.selectImagesByYearAndCategory(1);
        for (Image image : images) {
            System.out.println(image);
        }
    }

    @Test
    void selectAllImages() {
        List<Image> images = jdbcTemplate.query("select * from image where YEAR(image_data) = 2023", new BeanPropertyRowMapper<>(Image.class));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/hh");
        for (Image image : images) {
            System.out.println(image);
        }
    }
}
