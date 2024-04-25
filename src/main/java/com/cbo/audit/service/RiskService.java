package com.cbo.audit.service;

import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.RiskItemDTO;
import com.cbo.audit.dto.RiskScoreDTO;
import com.cbo.audit.persistence.model.RiskLevel;

import java.util.List;

public interface RiskService {
    ResultWrapper<List<RiskScoreDTO>> getRiskScoreByAnnualPlanId(Long planId);

    ResultWrapper<List<RiskItemDTO>> getAllRiskItems();

    ResultWrapper<RiskLevel> getRiskLevelValues();
}
