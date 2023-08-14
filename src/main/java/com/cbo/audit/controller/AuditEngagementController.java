package com.cbo.audit.controller;

import com.cbo.audit.constants.URIs;
import com.cbo.audit.dto.AuditEngagementDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.service.AuditEngagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class AuditEngagementController {
    @Autowired
    AuditEngagementService auditEngagementService;
    @PostMapping(value = URIs.AUDIT_SCHEDULE_REGISTER, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditEngagementDTO>> auditEngagementRegister(@RequestBody AuditEngagementDTO auditEngagementDTO){

        ResultWrapper<AuditEngagementDTO> resultWrapper=auditEngagementService.registerAuditEngagement(auditEngagementDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = URIs.AUDIT_SCHEDULE_LIST_ALL,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<AuditEngagementDTO>>> listAllAuditEngagement(){

        ResultWrapper<List<AuditEngagementDTO>> resultWrapper=auditEngagementService.getAllAuditEngagement();

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = URIs.AUDIT_SCHEDULE_BY_ID,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditEngagementDTO>> getAuditEngagementById(@PathVariable(name = "id") Long id){

        ResultWrapper<AuditEngagementDTO> resultWrapper=auditEngagementService.getAuditEngagementById(id);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.AUDIT_SCHEDULE_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditEngagementDTO>> updateAuditEngagement(@RequestBody AuditEngagementDTO auditEngagementDTO){

        ResultWrapper<AuditEngagementDTO> resultWrapper=auditEngagementService.updateAuditEngagement(auditEngagementDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }
}
