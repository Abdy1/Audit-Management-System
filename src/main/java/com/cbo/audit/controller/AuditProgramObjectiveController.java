package com.cbo.audit.controller;

import com.cbo.audit.constants.URIs;

import com.cbo.audit.dto.AuditProgramObjectiveDTO;
import com.cbo.audit.dto.ResultWrapper;

import com.cbo.audit.service.AuditProgramObjectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AuditProgramObjectiveController {
    @Autowired
    AuditProgramObjectiveService auditProgramObjectiveService;

    @GetMapping(value = URIs.LIST_OBJECTIVES_BY_AUDIT_PROGRAM_ID,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<AuditProgramObjectiveDTO>>> listAllAuditProgramObjectives(@PathVariable(name = "id") Long id){
        ResultWrapper<List<AuditProgramObjectiveDTO>> resultWrapper=auditProgramObjectiveService.getAllAuditProgramObjectiveByAuditProgramId(id);
        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);


    }
}
