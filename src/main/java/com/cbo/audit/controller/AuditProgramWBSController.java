package com.cbo.audit.controller;

import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.AuditProgramWBSDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.persistence.model.WBS;
import com.cbo.audit.service.WBSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cbo.audit.constants.URIs;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AuditProgramWBSController {
    @Autowired
    WBSService wbsService;
    @GetMapping(value = URIs.List_WBS_BY_AUDIT_PROGRAM_ID,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<AuditProgramWBSDTO>>> listAllAuditProgramWBS(@PathVariable(name = "id") Long id){
        ResultWrapper<List<AuditProgramWBSDTO>> resultWrapper=wbsService.getAllWBSByAuditProgramId(id);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);


    }

}
