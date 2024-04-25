package com.cbo.audit.service.impl;

import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.RiskItemDTO;
import com.cbo.audit.dto.RiskScoreDTO;
import com.cbo.audit.mapper.RiskItemMapper;
import com.cbo.audit.mapper.RiskScoreMapper;
import com.cbo.audit.persistence.model.RiskLevel;
import com.cbo.audit.persistence.repository.RiskItemRepository;
import com.cbo.audit.persistence.repository.RiskLevelRepository;
import com.cbo.audit.persistence.repository.RiskScoreRepository;
import com.cbo.audit.service.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("riskService")
@Transactional
public class RiskServiceImpl implements RiskService {

    @Autowired
    private RiskScoreRepository riskScoreRepository;

    @Autowired
    private RiskLevelRepository riskLevelRepository;
    @Autowired
    private RiskItemRepository riskItemRepository;

    @Override
    public ResultWrapper<List<RiskScoreDTO>> getRiskScoreByAnnualPlanId(Long planId) {
        ResultWrapper<List<RiskScoreDTO>> resultWrapper = new ResultWrapper<>();

        resultWrapper.setResult(RiskScoreMapper.INSTANCE.riskScoresToRiskScoreDTOs(riskScoreRepository.findRiskScoreByAnnualPlanId(planId)));

        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<RiskItemDTO>> getAllRiskItems() {
        ResultWrapper<List<RiskItemDTO>> resultWrapper = new ResultWrapper<>();

        resultWrapper.setResult(RiskItemMapper.INSTANCE.riskItemsToRiskItemDTOs(riskItemRepository.findAll()));

        return resultWrapper;
    }

    @Override
    public ResultWrapper<RiskLevel> getRiskLevelValues() {
        ResultWrapper<RiskLevel> resultWrapper = new ResultWrapper<>();

        Optional<RiskLevel> riskLevel = riskLevelRepository.findAll().stream().findFirst();

        riskLevel.ifPresent(resultWrapper::setResult);
        return resultWrapper;
    }
}
