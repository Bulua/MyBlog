package com.jph.myblog.service;

import com.jph.myblog.entity.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ImageService {

    public List<Image> selectImagesByYearAndCategory(Integer categoryId);

    int insertImage(MultipartFile[] images, Integer catId) throws IOException;

    int batchInsertImage(List<Image> images);
}
