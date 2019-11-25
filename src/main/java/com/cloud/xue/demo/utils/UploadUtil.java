package com.cloud.xue.demo.utils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Program
 * @Title: 上传文件工具类
 * @Description:
 * @Author: XueXiao
 * @Create: 2019-03-20 09:53:45
 */
public class UploadUtil {

    private final static Logger logger =LoggerFactory.getLogger(UploadUtil.class);

    /**
     *
     * @param client
     * @param file
     * @param serverPath WEB 服务器地址
     * @param path  WEB服务器图片报文路径
     * @return
     */
    public static String upload(Client client, MultipartFile file, String serverPath, String path){
        // 文件名称生成策略（UUID uuid = UUID.randomUUID()）
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String formatDate = format.format(d);
        String str = "";
        for(int i=0 ;i <5; i++){
            int n = (int)(Math.random()*90)+10;
            str += n;
        }
        // 获取文件的扩展名
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        // 文件名
        String fileName = formatDate + str + "." + extension;
        //相对路径
        String relaPath = path + File.separator + fileName;

        String a = serverPath + path;
        File file2 = new File(a);
        if(!file2.exists()){
            boolean mkdirs = file2.mkdirs();
        }

        // WEB服务器的URL（真实路径）
        String realPath = serverPath + relaPath;
        // 设置请求路径
        WebResource resource = client.resource(realPath);
        // 发送开始post get put（基于put提交）
        try {
            resource.put(String.class, file.getBytes());
            return realPath;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
