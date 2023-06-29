package com.jph.myblog.controller;

//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jph.myblog.entity.Image;
import com.jph.myblog.enums.ImageType;
import com.jph.myblog.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * 该Controller主要负责页面的跳转
 */
@Controller
public class HtmlController {

    @Autowired
    private ImageService imageService;

    @RequestMapping("/")
    public ModelAndView index(ModelAndView mv) {
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView login(ModelAndView mv) {
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("/test")
    public ModelAndView test(ModelAndView mv) {
        mv.setViewName("test");
        return mv;
    }

    @RequestMapping("/editor")
    public ModelAndView editor(ModelAndView mv) {
        mv.setViewName("editor");
        return mv;
    }

    @RequestMapping("/gallery")
    public ModelAndView gallery(ModelAndView mv) throws IOException {
        List<Image> coverImages =
                imageService.selectImagesByYearAndCategory(ImageType.COVER_IMAGE.getValue());
        mv.setViewName("gallery");
        mv.addObject("coverImages", coverImages);
        return mv;
    }
}
