package com.cbo.audit.controller;

import com.cbo.audit.constants.URIs;
import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.service.AnnualPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnnualPlanController {
    @Autowired
    AnnualPlanService annualPlanService;
    @PostMapping(value = URIs.ANNUAL_PLAN_REGISTER, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AnnualPlanDTO>> annualPlanRegister(@RequestBody AnnualPlanDTO annualPlanDTO){

        ResultWrapper<AnnualPlanDTO> resultWrapper=annualPlanService.registerAnnualPlan(annualPlanDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = URIs.ANNUAL_PLAN_LIST_ALL,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<AnnualPlanDTO>>> listAllAnnualPlan(){

        ResultWrapper<List<AnnualPlanDTO>> resultWrapper=annualPlanService.getAllAnnualPlan();

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.ANNUAL_PLAN_BY_ID,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AnnualPlanDTO>> getAnnualPlanById(@RequestBody AnnualPlanDTO annualPlanDTO){

        ResultWrapper<AnnualPlanDTO> resultWrapper=annualPlanService.getAnnualPlanById(annualPlanDTO.getId());

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.ANNUAL_PLAN_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AnnualPlanDTO>> updateAnnualPlan(@RequestBody AnnualPlanDTO annualPlanDTO){

        ResultWrapper<AnnualPlanDTO> resultWrapper=annualPlanService.updateAnnualPlan(annualPlanDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }
}
