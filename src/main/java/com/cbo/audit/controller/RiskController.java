package com.cbo.audit.controller;

import com.cbo.audit.constants.URIs;
import com.cbo.audit.dto.*;
import com.cbo.audit.persistence.model.RiskLevel;
import com.cbo.audit.persistence.model.RiskScore;
import com.cbo.audit.service.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RiskController{

    @Autowired
    private RiskService riskService;

    @GetMapping(value = URIs.RISK_ITEM_LIST_ALL,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<RiskItemDTO>>> getAllRiskItems(){

        ResultWrapper<List<RiskItemDTO>> resultWrapper=riskService.getAllRiskItems();

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = URIs.GET_RISK_LEVEL,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<RiskLevel>> getRiskLevelValues(){

        ResultWrapper<RiskLevel> resultWrapper=riskService.getRiskLevelValues();

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.RISK_SCORE_BY_ANNUAL_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<RiskScoreDTO>>> getRiskScoreByAnnualPlanId(@RequestBody AnnualPlanDTO annualPlanDTO){

        ResultWrapper<List<RiskScoreDTO>> resultWrapper=riskService.getRiskScoreByAnnualPlanId(annualPlanDTO.getId());

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }
}
