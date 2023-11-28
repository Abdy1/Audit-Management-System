package com.cbo.audit.controller;

import com.cbo.audit.dto.FindingCommentDTO;
import com.cbo.audit.dto.FindingDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.service.FindingCommentService;
import com.cbo.audit.service.impl.FindingCommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FindingCommentController {
    @Autowired
    private FindingCommentServiceImpl findingCommentService;
    @PostMapping("ams/auditProgram/finding/comment/add")
public ResponseEntity<ResultWrapper<FindingCommentDTO>> addCommentOnFinding(@RequestBody FindingCommentDTO findingCommentDTO){
        ResultWrapper<FindingCommentDTO> resultWrapper=findingCommentService.addCommentToFinding(findingCommentDTO);
    return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
}

}
