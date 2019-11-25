package com.cloud.xue.demo.controller;

import com.cloud.xue.demo.entity.Result;

import com.cloud.xue.demo.enums.ResultEnum;
import com.cloud.xue.demo.utils.ResultUtil;
import com.cloud.xue.demo.utils.UploadUtil;
import com.sun.jersey.api.client.Client;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @Program qrcode
 * @Title: UploadFileController
 * @Description:
 * @Author: XueXiao
 * @Create: 2019-03-19 17:13:55
 */
@RestController
public class UploadFileController {

    private static final Logger logger = Logger.getLogger(UploadFileController.class);

    @Value(value="${imagePath}")
    private String imgPath;

    @Value(value="${uploadHost}")
    private String uploadHost;

    @Value(value="${fileHost}")
    private String fileHost;

    /**
     * 前后端分离，ajax形式上传图片
     * @param uploadFile
     * @return
     */
    //@CrossOrigin
    @RequestMapping(value="/uploadFile", method=RequestMethod.POST)
    public Result<String> uploadPicByAjax(@PathVariable("uploadFile") MultipartFile uploadFile){
        String uploadInfo=null;
        try {
            Client client = new Client();
            uploadInfo = UploadUtil.upload(client, uploadFile, fileHost, imgPath);
            if(!"".equals(uploadInfo)){    //上传成功
                return ResultUtil.success(uploadInfo);
            }else{    //上传失败
                return ResultUtil.error(ResultEnum.UPLOAD_ERROR);
            }
        }catch (Exception e) {
            //logger.error(e.getMessage());
            e.printStackTrace();
            return ResultUtil.error(ResultEnum.UNKNOW_ERROR);
        }
    }

    /**
     * 通过表单形式上传图片
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result uploadPicByForm(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        Result response = new Result();
//        if (!file.isEmpty()){
//            String absolutePathByWebXml = System.getProperty("qrcode.app");
//            log.info("通过web.xml配置获取绝对路径：" + absolutePathByWebXml);
//            log.info("====================");
//            String absolutePathByHttpRequest = request.getServletContext().getRealPath("/image");
//            log.info("通过request.getServletContext().getRealPath()获取绝对路径：" + absolutePathByHttpRequest);
//
//            try {
//                File dir = new File(absolutePathByHttpRequest + File.separator);
//                if (!dir.exists()){
//                    dir.mkdirs();
//                }
//                File serFile = new File(dir.getAbsolutePath()+File.separator+file.getOriginalFilename());
//                file.transferTo(serFile);
//                response.success(uploadHost + imgPath +File.separator+file.getOriginalFilename());
//            }catch (Exception e) {
//                response.failure("上传图片失败！");
//            }
//        }else{
//            response.failure("上传图片为空，请重新选择！");
//        }
        return response;
    }
}
