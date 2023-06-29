package com.jph.myblog.utils;

import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PathUtils {

    /**
     * 获取图片保存的路径，例如：D:/ProjectWorkspace/Idea/MyBlog/target/classes/
     * @return 图片保存的路径
     */
    public static String getImageSavePath() throws FileNotFoundException {
        return ResourceUtils.getURL("classpath:").getPath().substring(1)
                + "public";
    }

    public static String getDatePath() {
        SimpleDateFormat format = new SimpleDateFormat("/yyyy/MM");
        return format.format(new Date());
    }

    public static String getDirs() throws IOException {
        Path dirs = Paths.get(getImageSavePath(), getDatePath());
        if (!Files.exists(dirs)) {
            Files.createDirectories(dirs);
        }
        return dirs.toString();
    }

    public static void makeDirs(String path) throws IOException {
        Path dirs = Paths.get(path);
        if (!Files.exists(dirs)) {
            Files.createDirectories(dirs);
        }
    }

}
