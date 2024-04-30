package com.cbo.audit.service.impl;

import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.persistence.model.RiskLevel;
import com.cbo.audit.persistence.repository.RiskLevelRepository;
import com.cbo.audit.service.RiskLevelService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("riskLevelService")
@Transactional
public class RiskLevelServiceImpl implements RiskLevelService {

    private final RiskLevelRepository riskLevelRepository;

    public RiskLevelServiceImpl(RiskLevelRepository riskLevelRepository) {
        this.riskLevelRepository = riskLevelRepository;
    }

    @Override
    public ResultWrapper<RiskLevel> registerRiskLevel(RiskLevel riskLevel) {
        ResultWrapper<RiskLevel> resultWrapper = new ResultWrapper<>(riskLevel);
        riskLevelRepository.save(riskLevel);
        resultWrapper.setStatus(true);
        resultWrapper.setMessage("Registered successfully!");
        resultWrapper.setResult(riskLevel);
        return resultWrapper;
    }

    @Override
    public ResultWrapper<RiskLevel> updateRiskLevel(RiskLevel riskLevel) {
        ResultWrapper<RiskLevel> resultWrapper = new ResultWrapper<>(riskLevel);
        riskLevelRepository.save(riskLevel);

        resultWrapper.setStatus(true);
        resultWrapper.setMessage("Registered successfully!");
        resultWrapper.setResult(riskLevel);
        return resultWrapper;
    }
}
