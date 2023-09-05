package com.cbo.audit.controller;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.cbo.audit.constants.URIs;
import com.cbo.audit.dto.AuditProgramMainActivityDTO;

import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.service.AuditProgramMainActivityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class AuditProgramMainActivityController {

    @Autowired
    AuditProgramMainActivityService auditProgramMainActivityService;
    @GetMapping(value = URIs.LIST_MAIN_ACTIVITIES_BY_AUDIT_PROGRAM_ID,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<AuditProgramMainActivityDTO>>> listAllAuditProgramMainActivity(@PathVariable(name = "id") Long id){
        ResultWrapper<List<AuditProgramMainActivityDTO>> resultWrapper=auditProgramMainActivityService.getAllMainActivityByAuditProgramId(id);
        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);


    }
    @PostMapping(value = URIs.AUDIT_PROGRAM_MAIN_ACTIVITY_REGISTER,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditProgramMainActivityDTO>> auditProgramMainActivityRegister(@RequestBody AuditProgramMainActivityDTO auditProgramMainActivityDTO){
        ResultWrapper<AuditProgramMainActivityDTO> resultWrapper=auditProgramMainActivityService.registerAuditProgramMainActivity(auditProgramMainActivityDTO);
        return new ResponseEntity<>(resultWrapper,HttpStatus.CREATED);
    }
    @PostMapping(value = URIs.AUDIT_PROGRAM_MAIN_ACTIVITY_UPDATE,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditProgramMainActivityDTO>> auditProgramMainActivityUpdate(@RequestBody AuditProgramMainActivityDTO auditProgramMainActivityDTO){
        ResultWrapper<AuditProgramMainActivityDTO> resultWrapper=auditProgramMainActivityService.updateAuditProgramMainActivity(auditProgramMainActivityDTO);
        return new ResponseEntity<>(resultWrapper,HttpStatus.CREATED);
    }
}
