package com.jph.myblog.service.impl;

import com.jph.myblog.entity.ImageCategory;
import com.jph.myblog.mapper.ImageCategoryMapper;
import com.jph.myblog.service.ImageCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ImageCategoryServiceImpl implements ImageCategoryService {

    @Autowired
    private ImageCategoryMapper imageCategoryMapper;

    @Override
    public ImageCategory selectOneById(Integer id) {
        return imageCategoryMapper.selectOneById(id);
    }
}
