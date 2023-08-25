package com.cbo.audit.service.impl;

import com.cbo.audit.dto.AuditEngagementDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.TeamMemberDTO;
import com.cbo.audit.enums.AuditEngagementStatus;
import com.cbo.audit.mapper.AuditEngagementMapper;
import com.cbo.audit.mapper.TeamMemberMapper;
import com.cbo.audit.persistence.model.*;
import com.cbo.audit.persistence.model.AuditEngagement;
import com.cbo.audit.persistence.repository.AuditEngagementRepository;
import com.cbo.audit.persistence.repository.TeamMemberRepository;
import com.cbo.audit.service.AnnualPlanService;
import com.cbo.audit.service.AuditEngagementService;
import com.cbo.audit.service.AuditEngagementService;
import com.cbo.audit.service.AuditScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service("auditEngagementService")
@Transactional
public class AuditEngagementServiceImpl implements AuditEngagementService {


    @Autowired
    private AuditEngagementRepository auditEngagementRepository;

    @Autowired
    private AuditScheduleService auditScheduleService;

    @Autowired
    private TeamMemberRepository teamMemberRepository;


    @Override
    public ResultWrapper<AuditEngagementDTO> registerAuditEngagement(AuditEngagementDTO auditEngagementDTO) {
        ResultWrapper<AuditEngagementDTO> resultWrapper = new ResultWrapper<>();

        AuditSchedule auditSchedule = auditScheduleService.findAuditScheduleById(auditEngagementDTO.getAuditScheduleId());

        if (auditSchedule == null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Engagement with the provided information is not available.");
            return resultWrapper;
        }

        AuditEngagement auditEngagement = AuditEngagementMapper.INSTANCE.toEntity(auditEngagementDTO);
        auditEngagement.setCreatedTimestamp(LocalDateTime.now());
        auditEngagement.setAuditScheduleId(auditSchedule.getId());
        auditEngagement.setCreatedUser("TODO");
        auditEngagement.setStatus(AuditEngagementStatus.InProgress);


        resultWrapper.setStatus(true);
        resultWrapper.setResult(AuditEngagementMapper.INSTANCE.toDTO(auditEngagement));
        resultWrapper.setMessage("Audit Engagement created successfully.");
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AuditEngagementDTO>> getAllAuditEngagement() {
        ResultWrapper<List<AuditEngagementDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditEngagement> auditEngagements=auditEngagementRepository.findAll();
        if (!auditEngagements.isEmpty()){
            List<AuditEngagementDTO> auditEngagementDTOS = AuditEngagementMapper.INSTANCE.auditEngagementsToAuditEngagementDTOs(auditEngagements);
            resultWrapper.setResult(auditEngagementDTOS);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }


    @Override
    public ResultWrapper<AuditEngagementDTO> getAuditEngagementById(Long id) {

        ResultWrapper<AuditEngagementDTO> resultWrapper = new ResultWrapper<>();
        AuditEngagement auditEngagement = auditEngagementRepository.findById(id).orElse(null);
        if (auditEngagement != null){
            AuditEngagementDTO auditEngagementDTO = AuditEngagementMapper.INSTANCE.toDTO(auditEngagement);
            resultWrapper.setResult(auditEngagementDTO);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public AuditEngagement findAuditEngagementById(Long id) {
        return auditEngagementRepository.findById(id).orElse(null);
    }

    @Override
    public ResultWrapper<List<AuditEngagementDTO>> getAllCompletedAuditEngagement() {
        ResultWrapper<List<AuditEngagementDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditEngagement> auditEngagements=auditEngagementRepository.findAuditEngagementByStatus(AuditEngagementStatus.Completed.name());
        if (!auditEngagements.isEmpty()){
            List<AuditEngagementDTO> auditEngagementDTOS = AuditEngagementMapper.INSTANCE.auditEngagementsToAuditEngagementDTOs(auditEngagements);
            resultWrapper.setResult(auditEngagementDTOS);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AuditEngagementDTO>> getAuditEngagementByAuditSchedule(Long id) {

        ResultWrapper<List<AuditEngagementDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditEngagement> auditEngagements = auditEngagementRepository.findAuditEngagementByAuditScheduleId(id);
        if (auditEngagements != null){
            List<AuditEngagementDTO> auditEngagementDTOS = AuditEngagementMapper.INSTANCE.auditEngagementsToAuditEngagementDTOs(auditEngagements);
            resultWrapper.setResult(auditEngagementDTOS);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<AuditEngagementDTO> updateAuditEngagement(AuditEngagementDTO auditEngagementDTO) {
        ResultWrapper<AuditEngagementDTO> resultWrapper = new ResultWrapper<>();

        Optional<AuditEngagement> oldAuditEngagement = auditEngagementRepository.findById(auditEngagementDTO.getId());


        if (!oldAuditEngagement.isPresent()) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit schedule must not be null.");
            return resultWrapper;
        }
        AuditEngagement auditEngagement = AuditEngagementMapper.INSTANCE.toEntity(auditEngagementDTO);
        auditEngagement.setCreatedUser(oldAuditEngagement.get().getCreatedUser());
        auditEngagement.setCreatedTimestamp(oldAuditEngagement.get().getCreatedTimestamp());
        auditEngagement.setAuditScheduleId(oldAuditEngagement.get().getAuditScheduleId());

        AuditEngagement savedSchedule = auditEngagementRepository.save(auditEngagement);

        resultWrapper.setStatus(true);
        resultWrapper.setResult(AuditEngagementMapper.INSTANCE.toDTO(savedSchedule));
        resultWrapper.setMessage("Audit Engagement updated successfully.");
        return resultWrapper;
    }

}
