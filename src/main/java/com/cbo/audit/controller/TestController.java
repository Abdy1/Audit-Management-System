package com.cbo.audit.controller;

import com.cbo.audit.utils.FileUploadUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Controller
public class TestController {
    @PostMapping("/test-api/saveFile")
    public ResponseEntity<String> saveFileTester(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        saveFile(multipartFile);
        return new ResponseEntity<>("success",HttpStatus.ACCEPTED);

    }


    public void saveFile(MultipartFile multipartFile) throws IOException {

        String uploadDir = "findings/evidences";
        FileUploadUtil.saveFile(uploadDir, multipartFile.getOriginalFilename(), multipartFile);
        /*String fileName=multipartFile.getName();
        File uploadDir = new File("./uploadedFile");
        System.out.println("oin");
        if (!uploadDir.exists()) {
            System.out.println("in");
            uploadDir.mkdirs();
        }
        String filePath =  uploadDir+ File.separator + fileName;
        File file = new File(filePath);
        multipartFile.transferTo(file);
        System.out.println(filePath);
        System.out.println(file.getAbsolutePath());*/
    }

}
