package com.jph.myblog.controller;

import com.jph.myblog.entity.Image;
import com.jph.myblog.entity.ImageCategory;
import com.jph.myblog.service.ImageCategoryService;
import com.jph.myblog.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageCategoryService imageCategoryService;

    @RequestMapping("/{id}")
    public ModelAndView selectImagesByYearAndCategory(
            @PathVariable("id") Integer id, ModelAndView mv) {
        List<Image> images = imageService.selectImagesByYearAndCategory(id);
        ImageCategory category = imageCategoryService.selectOneById(id);
        mv.setViewName("imgs");
        mv.addObject("category", category.getCategoryName());
        mv.addObject("categoryId", category.getId());
        mv.addObject("images", images);
        return mv;
    }

}
