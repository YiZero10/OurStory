package com.yiling.ourstory.util;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FileUpload {

    public static List<String> writeUploadFile(MultipartFile file) {
        List<String> fileMsg = new ArrayList<>();
        String filename = file.getOriginalFilename();
        String realpath = "E:/项目学习/ourstory/src/main/resources/static/webapp" + "/";
        File fileDir = new File(realpath);
        if (!fileDir.exists())
            fileDir.mkdirs();
        String extname = FilenameUtils.getExtension(filename);
        String allowImgFormat = "gif,jpg,jpeg,png";
        if (!allowImgFormat.contains(extname.toLowerCase())) {
            fileMsg.add("NOT_IMAGE");
            return fileMsg;
        }
        String fileId =Math.abs(file.getOriginalFilename().hashCode()) + RandomUtils.createRandomString(4);
        filename =  fileId + "." + extname;
        InputStream input = null;
        FileOutputStream fos = null;
        try {
            input = file.getInputStream();
            fos = new FileOutputStream(realpath + "/" + filename);
            IOUtils.copy(input, fos);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            IOUtils.closeQuietly(input);
            IOUtils.closeQuietly(fos);
        }
        fileMsg.add(0,fileId);
        fileMsg.add(1,filename);

        return fileMsg;
    }
}
