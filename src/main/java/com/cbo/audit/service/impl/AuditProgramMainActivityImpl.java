package com.cbo.audit.service.impl;

import com.cbo.audit.dto.AuditProgramMainActivityDTO;
import com.cbo.audit.dto.AuditProgramWBSDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.enums.AnnualPlanStatus;
import com.cbo.audit.mapper.AuditProgramMainActivityMapper;
import com.cbo.audit.mapper.WBSMapper;
import com.cbo.audit.persistence.model.AuditProgram;
import com.cbo.audit.persistence.model.AuditProgramMainActivity;
import com.cbo.audit.persistence.model.WBS;
import com.cbo.audit.persistence.repository.AuditProgramMainActivityRepository;
import com.cbo.audit.service.AuditProgramMainActivityService;
import com.cbo.audit.service.AuditProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service("auditProgramMainActivityService")
@Transactional
public class AuditProgramMainActivityImpl implements AuditProgramMainActivityService
{


    @Autowired
    private AuditProgramMainActivityRepository auditProgramMainActivityRepository;
@Autowired
AuditProgramService auditProgramService;
    public ResultWrapper<List<AuditProgramMainActivityDTO>> getAllMainActivityByAuditProgramId(Long auditProgram_id) {
        ResultWrapper<List<AuditProgramMainActivityDTO>> resultWrapper= new ResultWrapper<>();

        List<AuditProgramMainActivity> auditProgramMainActivities  = auditProgramMainActivityRepository.findAllMainActivityByAuditProgramId(auditProgram_id);
        if (auditProgramMainActivities != null){
            List<AuditProgramMainActivityDTO> auditProgramMainActivityDTOS = AuditProgramMainActivityMapper.INSTANCE.auditProgramMainActivityToAuditProgramMainActivityDTOs(auditProgramMainActivities);
            resultWrapper.setResult(auditProgramMainActivityDTOS);
            resultWrapper.setStatus(true);
        }

        return resultWrapper;
    }



    @Override
    public ResultWrapper<AuditProgramMainActivityDTO> registerAuditProgramMainActivity(AuditProgramMainActivityDTO auditProgramMainActivityDTO) {
        ResultWrapper<AuditProgramMainActivityDTO> resultWrapper = new ResultWrapper<>();

        // Optional<AuditUniverse> auditUniverseOpt = annualPlanService.findAuditUniverseById(annualPlanDTO.getAuditUniverse().getId());
        Optional<AuditProgram> auditProgramOpt = null;//auditProgramService.findAuditProgramBy(auditProgramMainActivityDTO.getAuditProgram().getId());

        //add attributes to be checked if they are present in the audit program

        if (!auditProgramOpt.isPresent()) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Program with the provided information is not available.");
            return resultWrapper;
        }

        if (auditProgramMainActivityDTO.getName() == null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Main Activity name cannot be null.");
            return resultWrapper;
        }



        //AnnualPlan annualPlan = AnnualPlanMapper.INSTANCE.toEntity(annualPlanDTO;

        AuditProgramMainActivity auditProgramMainActivity = AuditProgramMainActivityMapper.INSTANCE.toEntity(auditProgramMainActivityDTO);
        auditProgramMainActivity.setCreatedTimestamp(LocalDateTime.now());

        auditProgramMainActivity.setCreatedUser("TODO");


        AuditProgramMainActivity savedMainActivity = auditProgramMainActivityRepository.save(auditProgramMainActivity);


        resultWrapper.setStatus(true);
        resultWrapper.setResult(AuditProgramMainActivityMapper.INSTANCE.toDTO(savedMainActivity));
        resultWrapper.setMessage("Audit Program WBS created successfully.");
        return resultWrapper;
    }

}
