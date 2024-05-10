package com.cbo.audit.controller;

import com.cbo.audit.dto.FindingCommentDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.service.impl.FindingCommentServiceImpl;
import com.cbo.audit.utils.FileUploadUtil;
import io.github.pixee.security.Filenames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.cbo.audit.constants.URIs.*;

@RestController
public class FindingCommentController {

    @Autowired
    private FindingCommentServiceImpl findingCommentService;

    @PostMapping(value = AUDIT_PROGRAM_FINDING_COMMENT_REGISTER, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<FindingCommentDTO>> addCommentOnFinding(@RequestBody FindingCommentDTO findingCommentDTO) {
        ResultWrapper<FindingCommentDTO> resultWrapper = findingCommentService.addCommentToFinding(findingCommentDTO);
        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = LIST_ALL_COMMENTS_BY_FINDING_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<FindingCommentDTO>>> listAllCommentByFindingId(@PathVariable Long id) {
        ResultWrapper<List<FindingCommentDTO>> resultWrapper = findingCommentService.listAllFindingCommentByFindingId(id);
        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = AUDIT_PROGRAM_FINDING_COMMENT_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<FindingCommentDTO>> updateFindingComment(@RequestBody FindingCommentDTO findingCommentDTO) {

        ResultWrapper<FindingCommentDTO> resultWrapper = findingCommentService.updateCommentFinding(findingCommentDTO);
        return new ResponseEntity<>(resultWrapper, HttpStatus.CREATED);
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("finding/files") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String originalFilename = Filenames.toSimpleFileName(file.getOriginalFilename());
            FileUploadUtil.saveFile("sample/", "1" + originalFilename, file);

        } else {
            return "No file uploaded.";
        }

        return "Not received";
    }

}
