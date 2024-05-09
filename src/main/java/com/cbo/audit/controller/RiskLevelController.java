package com.cbo.audit.controller;

import com.cbo.audit.constants.URIs;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.RiskLevelDTO;
import com.cbo.audit.persistence.model.RiskLevel;
import com.cbo.audit.service.RiskLevelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RiskLevelController {

    private final RiskLevelService riskLevelService;

    public RiskLevelController(RiskLevelService riskLevelService) {
        this.riskLevelService = riskLevelService;
    }

    @PostMapping(value = URIs.RISK_LEVEL_REGISTER, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<RiskLevelDTO>> registerRiskLevel(@RequestBody RiskLevelDTO riskLevelDTO){
        ResultWrapper<RiskLevelDTO> resultWrapper = riskLevelService.registerRiskLevel(riskLevelDTO);
        return new ResponseEntity<>(resultWrapper, HttpStatus.CREATED);
    }

    @GetMapping(value = URIs.RISK_LEVEL_GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<RiskLevelDTO>>> getRiskLevel(){
        ResultWrapper<List<RiskLevelDTO>> resultWrapper = riskLevelService.getRiskLevel();

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.RISK_LEVEL_UPDATED, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<RiskLevelDTO>> updateRiskLevel(@RequestBody RiskLevelDTO riskLevelDTO){
        ResultWrapper<RiskLevelDTO> resultWrapper = riskLevelService.updateRiskLevel(riskLevelDTO);
        return new ResponseEntity<>(resultWrapper, HttpStatus.CREATED);
    }
}
