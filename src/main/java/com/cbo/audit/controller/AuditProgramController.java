package com.cbo.audit.controller;

import com.cbo.audit.constants.URIs;
import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.AuditProgramDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.service.AnnualPlanService;
import com.cbo.audit.service.AuditProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuditProgramController {
    @Autowired
    AuditProgramService  auditProgramService;
    @PostMapping(value = URIs.AUDIT_PROGRAM_REGISTER, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditProgramDTO>> auditProgramRegister(@RequestBody AuditProgramDTO auditProgramDTO){

        ResultWrapper<AuditProgramDTO> resultWrapper=auditProgramService.registerAuditProgram(auditProgramDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

//    @GetMapping(value = URIs.ANNUAL_PLAN_LIST_ALL,produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ResultWrapper<List<AnnualPlanDTO>>> listAllAnnualPlan(){
//
//        ResultWrapper<List<AnnualPlanDTO>> resultWrapper=annualPlanService.getAllAnnualPlan();
//
//        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
//    }
//
//    @GetMapping(value = URIs.ANNUAL_PLAN_BY_ID,produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ResultWrapper<AnnualPlanDTO>> getAnnualPlanById(@PathVariable(name = "id") Long id){
//
//        ResultWrapper<AnnualPlanDTO> resultWrapper=annualPlanService.getAnnualPlanById(id);
//
//        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
//    }
//
//    @PostMapping(value = URIs.ANNUAL_PLAN_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ResultWrapper<AnnualPlanDTO>> updateAnnualPlan(@RequestBody AnnualPlanDTO annualPlanDTO){
//
//        ResultWrapper<AnnualPlanDTO> resultWrapper=annualPlanService.updateAnnualPlan(annualPlanDTO);
//
//        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
//    }
}
