package com.cbo.audit.service.impl;

import com.cbo.audit.dto.*;
import com.cbo.audit.enums.AnnualPlanStatus;
import com.cbo.audit.enums.AuditProgramStatus;
import com.cbo.audit.mapper.AnnualPlanMapper;
import com.cbo.audit.mapper.AuditProgramMapper;
import com.cbo.audit.mapper.RiskScoreMapper;
import com.cbo.audit.persistence.model.*;
import com.cbo.audit.persistence.repository.AnnualPlanRepository;
import com.cbo.audit.persistence.repository.AuditProgramRepository;
import com.cbo.audit.persistence.repository.RiskLevelRepository;
import com.cbo.audit.persistence.repository.RiskScoreRepository;
import com.cbo.audit.service.AuditEngagementService;
import com.cbo.audit.service.AuditProgramService;
import com.cbo.audit.service.AuditUniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service("auditProgramService")
@Transactional
public class AuditProgramServiceImpl implements AuditProgramService {

    @Autowired
    private AuditUniverseService annualPlanService;

    @Autowired
    private AuditEngagementService auditEngagementService;

    @Autowired
    private AuditProgramRepository auditProgramRepository;

    @Override
    public ResultWrapper<AuditProgramDTO> registerAuditProgram(AuditProgramDTO auditProgramDTO) {
        ResultWrapper<AuditProgramDTO> resultWrapper = new ResultWrapper<>();


        Optional<AuditEngagement> auditEngagementOpt = auditEngagementService.getAuditEngagementById(auditProgramDTO.getAuditEngagement().getId());

        if (!auditEngagementOpt.isPresent()) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Engagement with the provided information is not available.");
            return resultWrapper;
        }

        //USE THIS IF THERE IS ANY PROPERTY THAT MUST BE INCLUDED

//        if (AuditProgramDTO.getSomething() == null) {
//            resultWrapper.setStatus(false);
//            resultWrapper.setMessage("Annual Plan name cannot be null.");
//            return resultWrapper;
//        }
//
//        if (AuditProgramDTO.getSomething() == null) {
//            resultWrapper.setStatus(false);
//            resultWrapper.setMessage("Annual Plan risk year cannot be null.");
//            return resultWrapper;
//        }


        AuditProgram auditProgram = AuditProgramMapper.INSTANCE.toEntity(auditProgramDTO);


        auditProgram.setCreatedTimestamp(LocalDateTime.now());
        auditProgram.setCreatedUser("TODO");
        auditProgram.setStatus(AuditProgramStatus.Draft.getType());


        AuditProgram savedProgram = auditProgramRepository.save(auditProgram);



        auditProgramRepository.save(savedProgram);
        resultWrapper.setStatus(true);
        resultWrapper.setResult(AuditProgramMapper.INSTANCE.toDTO(savedProgram));
        resultWrapper.setMessage("Audit  Program  created successfully.");
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AnnualPlanDTO>> getAllAnnualPlan() {
        return null;
    }

    @Override
    public ResultWrapper<AnnualPlanDTO> getAnnualPlanById(Long id) {
        return null;
    }

    @Override
    public AnnualPlan findAnnualPlanById(Long id) {
        return null;
    }

    @Override
    public ResultWrapper<List<AnnualPlanDTO>> getAnnualPlanByYear(String year) {
        return null;
    }

    @Override
    public ResultWrapper<AnnualPlanDTO> updateAnnualPlan(AnnualPlanDTO auditUniverseDTO) {
        return null;
    }

    @Override
    public ResultWrapper<List<AnnualPlanDTO>> getAnnualPlanByAuditUniverseId(Long id) {
        return null;
    }


}
