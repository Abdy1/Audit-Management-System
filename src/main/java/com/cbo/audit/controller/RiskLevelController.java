package com.cbo.audit.controller;

import com.cbo.audit.constants.URIs;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.RiskLevelDTO;
import com.cbo.audit.persistence.model.RiskLevel;
import com.cbo.audit.service.RiskLevelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PutMapping(value = URIs.RISK_ITEM_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<RiskLevelDTO>> updateRiskLevel(@RequestBody RiskLevelDTO riskLevelDTO){
        ResultWrapper<RiskLevelDTO> resultWrapper = riskLevelService.updateRiskLevel(riskLevelDTO);
        return new ResponseEntity<>(resultWrapper, HttpStatus.CREATED);
    }
}
