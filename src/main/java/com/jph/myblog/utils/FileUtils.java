package com.jph.myblog.utils;

import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

public class FileUtils {

    public static String getFileExtension(String fileName) {
        if (Objects.isNull(fileName)) return "";
        if (fileName.lastIndexOf(".") != -1) {
            return fileName.substring(fileName.lastIndexOf("."));
        }
        return "";
    }

    public static String randomFilename(MultipartFile file) {
        String name = String.valueOf(System.currentTimeMillis());
        return name + FileUtils.getFileExtension(file.getOriginalFilename());
    }
}
