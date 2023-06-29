package com.jph.myblog.controller;

import com.jph.myblog.entity.Image;
import com.jph.myblog.entity.ImageCategory;
import com.jph.myblog.entity.TestEntity;
import com.jph.myblog.mapper.ImageMapper;
import com.jph.myblog.utils.FileUtils;
import com.jph.myblog.utils.PathUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Controller
public class TestController {

    @Autowired
    private ImageMapper imageMapper;

    @RequestMapping("/hello")
    public TestEntity handle01() {
        TestEntity obj = new TestEntity("jph", 789);
        log.info("请求进入测试控制器：/hello");
        return obj;
    }

    @PostMapping("/uploadFile")
    @ResponseBody
    public ModelAndView uploadFile(@RequestParam("files") MultipartFile[] imageFiles,
                                    ModelAndView mv) throws IOException {
        /**
         * 1、获取保存路径
         * 2、重新生成文件名
         * 3、保存到数据库
         * 4、保存图片
         * 5、返回数据
         */
        String savePath = PathUtils.getImageSavePath();
        String dataPath = PathUtils.getDatePath();
        String path = Paths.get(savePath, dataPath).toString();
        PathUtils.makeDirs(path);

        for (MultipartFile image: imageFiles) {
            if (Objects.isNull(image)) continue;
            String filename = UUID.randomUUID() +
                    FileUtils.getFileExtension(Objects.requireNonNull(image.getOriginalFilename()));
            File file = new File(path, filename);
            imageMapper.insertImage(
                    Image.builder()
                            .imageName(filename)
                            .category(ImageCategory.builder().id(1).build())
                            .url(Paths.get(dataPath, filename).toString())
                            .build()
            );
            image.transferTo(file);
        }
        return mv;
    }
}
