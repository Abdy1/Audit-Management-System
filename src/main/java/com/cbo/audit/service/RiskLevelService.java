package com.cbo.audit.service;

import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.persistence.model.RiskLevel;

public interface RiskLevelService {

    ResultWrapper<RiskLevel> registerRiskLevel(RiskLevel riskLevel);

    ResultWrapper<RiskLevel> updateRiskLevel(RiskLevel riskLevel);
}
