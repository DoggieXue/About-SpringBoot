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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Program qrcode
 * @Title: UploadFileController
 * @Description:
 * @Author: XueXiao
 * @Create: 2019-03-19 17:13:55
 */
@Controller
public class UploadFileController {

    private static final Logger logger = Logger.getLogger(UploadFileController.class);

    @Value(value="${file.tempPath}")
    private String UPLOAD_FOLDER;

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
    @ResponseBody
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

    @GetMapping("/")
    public String index(){
        return "uploadByForm";
    }

    /**
     * 通过表单形式上传图片
     * @param file
     * @param redirectAttributes
     * @return
     */
    @PostMapping(value = "/upload")
    public String uploadPicByForm(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){
        if (file.isEmpty()){
            redirectAttributes.addFlashAttribute("message","Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER+ UploadUtil.generateFileName(file));

            Files.write(path, bytes);
            //如果使用addAttribute进行参数传递，URL显示参数，同时只能使用为String类型的对象。
            //redirectAttributes.addAttribute("message","You successfully uploaded '" + file.getOriginalFilename() + "'");
            //如果使用addFlashAttribute进行参数传递，在URL是不显示参数的，同时可以使用Bean对象传递。
            redirectAttributes.addFlashAttribute("message","You successfully uploaded '" + file.getOriginalFilename() + "'");
        } catch (IOException e){
            e.printStackTrace();
        }
        return "redirect:uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
}
