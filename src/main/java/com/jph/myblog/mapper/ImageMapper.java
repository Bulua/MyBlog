package com.jph.myblog.mapper;

import com.jph.myblog.entity.Image;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ImageMapper {

    @Select("select * from images")
    List<Image> getAll();

    List<Image> selectImagesByYearAndCategory(@Param("categoryId") Integer categoryId);

    @Transactional
    int insertImage(Image image);

    @Transactional
    int batchInsertImage(List<Image> images);
}
