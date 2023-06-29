package com.jph.myblog.mapper;

import com.jph.myblog.entity.ImageCategory;
import org.apache.ibatis.annotations.Select;

public interface ImageCategoryMapper {

    @Select("select * from image_category where id=#{id}")
    public ImageCategory selectOneById(Integer id);
}
