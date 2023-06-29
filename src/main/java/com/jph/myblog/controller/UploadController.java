package com.jph.myblog.controller;

import com.jph.myblog.entity.Image;
import com.jph.myblog.entity.Result;
import com.jph.myblog.service.ImageService;
import com.jph.myblog.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private ImageService imageService;

    /**
     * 1、获取保存路径
     * 2、重新生成文件名
     * 3、保存到数据库
     * 4、保存图片
     * 5、返回数据
     */
    @RequestMapping("/img/{catId}")
    @ResponseBody
    public Result<Object> uploadImages(@RequestParam("files")MultipartFile[] files,
                                       @PathVariable("catId")Integer catId) throws IOException {
        int count = imageService.insertImage(files, catId);
        if (count == files.length) {
            return ResultUtil.success(count + "个文件已上传成功！");
        }
        return ResultUtil.error(500, "上传失败");
    }

}
