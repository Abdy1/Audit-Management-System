package com.cbo.audit.service.impl;

import com.cbo.audit.dto.AuditProgramMainActivityDTO;
import com.cbo.audit.dto.AuditProgramObjectiveDTO;
import com.cbo.audit.dto.AuditProgramWBSDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.mapper.AuditProgramMainActivityMapper;
import com.cbo.audit.mapper.AuditProgramObjectiveMapper;
import com.cbo.audit.mapper.WBSMapper;
import com.cbo.audit.persistence.model.AuditProgram;
import com.cbo.audit.persistence.model.AuditProgramMainActivity;
import com.cbo.audit.persistence.model.AuditProgramObjective;
import com.cbo.audit.persistence.model.WBS;
import com.cbo.audit.persistence.repository.AuditProgramObjectiveRepository;
import com.cbo.audit.service.AuditProgramObjectiveService;
import com.cbo.audit.service.AuditProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service("auditProgramObjectiveService")
@Transactional

public class AuditProgramObjectiveServiceImpl implements AuditProgramObjectiveService {
    @Autowired
    AuditProgramObjectiveRepository auditProgramObjectiveRepository;
    @Autowired
    AuditProgramService auditProgramService;


    @Override
    public ResultWrapper<List<AuditProgramObjectiveDTO>> getAllAuditProgramObjectiveByAuditProgramId(Long auditProgram_id) {
        ResultWrapper<List<AuditProgramObjectiveDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditProgramObjective> auditProgramObjectives = auditProgramObjectiveRepository.findAllObjectiveByAuditProgramId(auditProgram_id);
        if (auditProgramObjectives != null) {
            List<AuditProgramObjectiveDTO> auditProgramObjectiveDTOS = AuditProgramObjectiveMapper.INSTANCE.auditProgramObjectiveToAuditProgramObjectiveDTOs(auditProgramObjectives);
            resultWrapper.setResult(auditProgramObjectiveDTOS);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<AuditProgramObjectiveDTO> registerAuditProgramObjective(AuditProgramObjectiveDTO auditProgramObjectiveDTO) {
        ResultWrapper<AuditProgramObjectiveDTO> resultWrapper = new ResultWrapper<>();


        Optional<AuditProgram> auditProgramOpt =auditProgramService.findAuditProgramById(auditProgramObjectiveDTO.getAuditProgram().getId());


        if (!auditProgramOpt.isPresent()) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Program with the provided information is not available.");
            return resultWrapper;
        }

        if (auditProgramObjectiveDTO.getDescription() == null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Program Objective cannot be null.");
            return resultWrapper;
        }


        //AnnualPlan annualPlan = AnnualPlanMapper.INSTANCE.toEntity(annualPlanDTO;

        AuditProgramObjective auditProgramObjective = AuditProgramObjectiveMapper.INSTANCE.toEntity(auditProgramObjectiveDTO);
        auditProgramObjective.setCreatedTimestamp(LocalDateTime.now());


        auditProgramObjective.setCreatedUser("TODO");
        auditProgramObjective.setModifiedUser("TODO");
        auditProgramObjective.setAuditProgram(auditProgramOpt.get());
        //wbs.setStatus(AnnualPlanStatus.Planned.getType());

        AuditProgramObjective savedAuditProgramObjective = auditProgramObjectiveRepository.save(auditProgramObjective);


        resultWrapper.setStatus(true);
        resultWrapper.setResult(AuditProgramObjectiveMapper.INSTANCE.toDTO(savedAuditProgramObjective));
        resultWrapper.setMessage("Audit Program Objective created successfully.");
        return resultWrapper;
    }

    @Override
    public ResultWrapper<AuditProgramObjectiveDTO> updateAuditProgramObjective(AuditProgramObjectiveDTO auditProgramObjectiveDTO) {
        ResultWrapper<AuditProgramObjectiveDTO> resultWrapper = new ResultWrapper<>(auditProgramObjectiveDTO);
        AuditProgramObjective oldAuditProgramObjective = auditProgramObjectiveRepository.findById(auditProgramObjectiveDTO.getId()).orElse(null);
        if (oldAuditProgramObjective != null) {
            if (auditProgramObjectiveDTO.getDescription() == null) {
                resultWrapper.setStatus(false);
                resultWrapper.setMessage("Audit Program Objective Can not be Empty!");
            }
            else {

                AuditProgramObjective auditProgramObjective = AuditProgramObjectiveMapper.INSTANCE.toEntity(auditProgramObjectiveDTO);

                auditProgramObjective.setCreatedTimestamp(oldAuditProgramObjective.getCreatedTimestamp());
                auditProgramObjective.setCreatedUser(oldAuditProgramObjective.getCreatedUser());
                auditProgramObjective.setAuditProgram(oldAuditProgramObjective.getAuditProgram());

                AuditProgramObjective savedAuditProgramObjective = auditProgramObjectiveRepository.save(auditProgramObjective);
                resultWrapper.setResult(AuditProgramObjectiveMapper.INSTANCE.toDTO(savedAuditProgramObjective));
                resultWrapper.setStatus(true);
                resultWrapper.setMessage("Audit Program Objective updated successfully.");
            }
        }
        else {
                resultWrapper.setStatus(false);
                resultWrapper.setMessage("Audit Program WBS with the Provided id is not available");
    }

        return resultWrapper;
    }

}