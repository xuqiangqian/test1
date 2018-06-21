package com.xqq.three.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author xuqiangqiang
 * @Date: 2018/6/14 15:51
 * @Description:
 */
@Controller
public class UploadController {
    private Logger logger = LoggerFactory.getLogger(UploadController.class);

    /**
     * 初始化上传文件界面
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/upload", produces = "text/plain;charset=UTF-8", method = RequestMethod.POST)
    public @ResponseBody
    String upload(MultipartFile file) {
        String str = "上传成功";
        try {
            //上传目录地址
            String uploadDir = "D:/upload/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            executeUpload(uploadDir, file);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("上传失败");
            return "上传失败";
        }
        logger.info("上传成功");
        return str;
    }

    @RequestMapping(value = "/uploads", produces = "text/plain;charset=UTF-8", method = RequestMethod.POST)
    public @ResponseBody
    String uploads(MultipartFile[] file) {
        String str = "上传成功";
        try {
            //上传目录地址
            String uploadDir = "D:/upload/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            //遍历文件数组上传
            for (int i = 0; i < file.length; i++) {
                if (file[i] != null) {
                    executeUpload(uploadDir, file[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("上传失败");
            return "上传失败";
        }
        logger.info("上传成功");
        return str;
    }


    private void executeUpload(String uploadDir, MultipartFile file) throws IOException {
        //文件名
        String fileName = file.getOriginalFilename();
        //文件后缀名
        String suffix = fileName.substring(file.getOriginalFilename().lastIndexOf("."));
        //文件前缀名
        String prefix = fileName.substring(0, fileName.lastIndexOf("."));
        //上传文件名
        String name = System.currentTimeMillis() + prefix + suffix;
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir + name);
        //将上传的文件写入到服务器端文件中
        file.transferTo(serverFile);
    }
}
