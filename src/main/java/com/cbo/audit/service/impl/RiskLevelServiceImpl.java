package com.cbo.audit.service.impl;

import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.RiskLevelDTO;
import com.cbo.audit.mapper.RiskLevelMapper;
import com.cbo.audit.persistence.model.RiskLevel;
import com.cbo.audit.persistence.repository.RiskLevelRepository;
import com.cbo.audit.service.RiskLevelService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("riskLevelService")
@Transactional
public class RiskLevelServiceImpl implements RiskLevelService {

    private final RiskLevelRepository riskLevelRepository;

    public RiskLevelServiceImpl(RiskLevelRepository riskLevelRepository) {
        this.riskLevelRepository = riskLevelRepository;
    }

    @Override
    public ResultWrapper<RiskLevelDTO> registerRiskLevel(RiskLevelDTO riskLevelDTO) {
        ResultWrapper<RiskLevelDTO> resultWrapper = new ResultWrapper<>(riskLevelDTO);
        RiskLevel riskLevel = RiskLevelMapper.INSTANCE.toEntity(riskLevelDTO);
        riskLevelRepository.save(riskLevel);
        resultWrapper.setStatus(true);
        resultWrapper.setMessage("Registered successfully!");
        resultWrapper.setResult(riskLevelDTO);
        return resultWrapper;
    }

    @Override
    public ResultWrapper<RiskLevelDTO> updateRiskLevel(RiskLevelDTO riskLevelDTO) {
        ResultWrapper<RiskLevelDTO> resultWrapper = new ResultWrapper<>(riskLevelDTO);
        RiskLevel riskLevel = RiskLevelMapper.INSTANCE.toEntity(riskLevelDTO);
        riskLevelRepository.save(riskLevel);

        resultWrapper.setStatus(true);
        resultWrapper.setMessage("Updated successfully!");
        resultWrapper.setResult(riskLevelDTO);
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<RiskLevelDTO>> getRiskLevel() {
        ResultWrapper<List<RiskLevelDTO>> resultWrapper = new ResultWrapper<>();
        List<RiskLevel> riskLevelList = riskLevelRepository.findAll();

        if(riskLevelList.isEmpty()){
            resultWrapper.setResult(new ArrayList<>());
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("No item");

        }else{
            resultWrapper.setResult(RiskLevelMapper.INSTANCE.riskLevelsToRiskLevelDTOs(riskLevelList));
            resultWrapper.setStatus(true);

        }

        return resultWrapper;

    }
}
