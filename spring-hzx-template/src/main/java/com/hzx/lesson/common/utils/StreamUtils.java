package com.hzx.lesson.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.charset.StandardCharsets;


/**
 * @author shenzh
 */
@Slf4j
public class StreamUtils {

    /**
     * 读取流中前面的字符，看是否有bom，如果有bom，将bom头先读掉丢弃
     * (opencsv 按列名获取bean对象，第一列缺失的情况)
     * InputStreamReader is = new InputStreamReader(
     * CsvUtil.getInputStream(new  FileInputStream(fileName)), "utf-8");
     */
    public static InputStream getInputStream(InputStream in) {
        PushbackInputStream testin = null;
        try {
            testin = new PushbackInputStream(in);
            int ch = testin.read();
            if (ch != 0xEF) {
                testin.unread(ch);
            } else if ((ch = testin.read()) != 0xBB) {
                testin.unread(ch);
                testin.unread(0xef);
            } else if ((ch = testin.read()) != 0xBF) {
                throw new IOException("错误的UTF-8格式文件");
            } else {
                throw new IOException("错误的格式文件");
            }
        } catch (Exception e) {
            log.error("解析csv文件失败", e);
        }

        return testin;
    }

    public static String getJsonString(String jsonPath) {
        try {
            ClassPathResource classPathResource = new ClassPathResource(jsonPath);
            InputStream inputStream = classPathResource.getInputStream();
            Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            int ch;
            StringBuilder sb = new StringBuilder();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            reader.close();
            return sb.toString();

        } catch (IOException e) {
            log.error("StreamUtil 解析失败", e);
            return null;
        }
    }
}
