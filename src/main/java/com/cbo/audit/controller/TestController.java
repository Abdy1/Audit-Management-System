package com.cbo.audit.controller;

import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.service.impl.AuditProgramFindingServiceImpl;
import com.cbo.audit.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class TestController {
    @Autowired
    AuditProgramFindingServiceImpl service;
    @PostMapping("/test-api/saveFile")
    public ResponseEntity<String> saveFileTester(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        saveFile(multipartFile);
        return new ResponseEntity<>("success",HttpStatus.ACCEPTED);

    }
    @GetMapping("test-api/getEvidences/{id}")
    public ResponseEntity<ResultWrapper<List<Path>>> getAllEvidencesById(@PathVariable("id") Long id){
        ResultWrapper<List<Path>> resultWrapper=service.getFillesAttachedByFindingId(id);

        return new ResponseEntity<>(resultWrapper,HttpStatus.OK);
    }

    @GetMapping("/download/{filename}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String filename) {

        ByteArrayResource resource = service.downloadFile(filename);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }
    public void saveFile(MultipartFile multipartFile) throws IOException {

        String uploadDir = "findings/evidences";
        FileUploadUtil.saveFile(uploadDir, "1"+multipartFile.getOriginalFilename(), multipartFile);
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
