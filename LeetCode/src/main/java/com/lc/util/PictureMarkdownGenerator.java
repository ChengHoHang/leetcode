package com.lc.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * @author chanhaoheng
 * @date 2022/9/30
 */
public class PictureMarkdownGenerator {

    private static final String TEMPLATE = "![a]({})\n\n";

    private static final String PATTERN = "(.*)\\.(jpg|bmp|gif|ico|pcx|jpeg|tif|png|raw|tga|JPG|BMP|GIF|ICO|PCX|JPEG|TIF|PNG|RAW|TGA)$";

    private static final Pattern R = Pattern.compile(PATTERN);

    private PictureMarkdownGenerator() {

    }

    public static void generate(File parentFile) throws IOException {
        if (Boolean.FALSE == FileUtil.isDirectory(parentFile)) {
            return;
        }

        List<File> joinFileList = new ArrayList<>();
        File[] files = Objects.requireNonNull(parentFile.listFiles());
        for (File curFile : files) {
            if (FileUtil.isDirectory(curFile)) {
                generate(curFile);
            } else if (R.matcher(curFile.getName()).find()){
                joinFileList.add(curFile);
            }
        }

        if (CollectionUtil.isEmpty(joinFileList)) {
            return;
        }

        List<String> contents = new ArrayList<>();
        for (File file : joinFileList) {
            String content = StrUtil.format(TEMPLATE, file.getAbsoluteFile().getAbsolutePath());
            contents.add(content);
        }
        Files.write(Paths.get(parentFile.getAbsolutePath() + "/generate.md"), contents, Charset.defaultCharset());
    }


    public static void main(String[] args) throws IOException {
        PictureMarkdownGenerator.generate(new File("C:\\Users\\chenhaoheng\\Desktop\\test"));
    }
}
