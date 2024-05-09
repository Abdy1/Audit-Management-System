package com.cbo.audit.service;

import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.RiskLevelDTO;
import com.cbo.audit.persistence.model.RiskLevel;

import java.util.List;

public interface RiskLevelService {

    ResultWrapper<RiskLevelDTO> registerRiskLevel(RiskLevelDTO riskLevelDTO);

    ResultWrapper<RiskLevelDTO> updateRiskLevel(RiskLevelDTO riskLevelDTO);

    ResultWrapper<List<RiskLevelDTO>> getRiskLevel();
}
