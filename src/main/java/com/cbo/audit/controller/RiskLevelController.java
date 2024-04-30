package com.cbo.audit.controller;

import com.cbo.audit.constants.URIs;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.persistence.model.RiskLevel;
import com.cbo.audit.service.RiskLevelService;
import org.springframework.http.HttpStatus;
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

    @PostMapping(value = URIs.RISK_LEVEL_REGISTER)
    public ResponseEntity<ResultWrapper<RiskLevel>> registerRiskLevel(@RequestBody RiskLevel riskLevel){

        return new ResponseEntity<>(riskLevelService.registerRiskLevel(riskLevel), HttpStatus.CREATED);
    }

    @PutMapping(value = URIs.RISK_LEVEL_REGISTER)
    public ResponseEntity<ResultWrapper<RiskLevel>> updateRiskLevel(@RequestBody RiskLevel riskLevel){

        return new ResponseEntity<>(riskLevelService.updateRiskLevel(riskLevel), HttpStatus.CREATED);
    }
}
