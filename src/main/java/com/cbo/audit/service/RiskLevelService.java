package com.cbo.audit.service;

import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.RiskLevelDTO;
import com.cbo.audit.persistence.model.RiskLevel;

public interface RiskLevelService {

    ResultWrapper<RiskLevelDTO> registerRiskLevel(RiskLevelDTO riskLevelDTO);

    ResultWrapper<RiskLevelDTO> updateRiskLevel(RiskLevelDTO riskLevelDTO);
}
