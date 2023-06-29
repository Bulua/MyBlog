package com.jph.myblog.service.impl;

import com.jph.myblog.entity.Image;
import com.jph.myblog.entity.ImageCategory;
import com.jph.myblog.mapper.ImageMapper;
import com.jph.myblog.service.ImageCategoryService;
import com.jph.myblog.service.ImageService;
import com.jph.myblog.utils.FileUtils;
import com.jph.myblog.utils.PathUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageMapper imageMapper;

    @Autowired
    private ImageCategoryService imageCategoryService;

    /**
     * 查询照片
     * @param categoryId 照片的标签
     * @return 照片列表
     */
    @Override
    public List<Image> selectImagesByYearAndCategory(Integer categoryId) {
        return imageMapper.selectImagesByYearAndCategory(categoryId);
    }

    @Override
//    @Transactional()
    public int insertImage(MultipartFile[] images, Integer catId) throws IOException {
        String dirs = PathUtils.getDirs();
        ImageCategory category = imageCategoryService.selectOneById(catId);
        List<Image> imgs = new ArrayList<>();

        for (MultipartFile image: images) {
            if (Objects.isNull(image)) continue;
            // 随机文件名
            String filename = FileUtils.randomFilename(image);
            // 数据库图片url
            String url = Paths.get(PathUtils.getDatePath(), filename).toString();
            File file = new File(dirs, filename);
            Image img = Image.builder().imageName(filename)
                    .category(category).url(url).build();
            imgs.add(img);
            image.transferTo(file);
        }
        int count = imageMapper.batchInsertImage(imgs);

        log.info("insert image count:{}", count);
        return count;
    }

    @Override
    public int batchInsertImage(List<Image> images) {
        if (Objects.isNull(images) || images.isEmpty()) {
            return 0;
        }
        int count = imageMapper.batchInsertImage(images);
        log.info("batch insert image count:{}", count);
        return count;
    }
}
