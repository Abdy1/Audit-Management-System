package com.cbo.audit.service.impl;

import com.cbo.audit.dto.*;
import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.enums.AnnualPlanStatus;
import com.cbo.audit.enums.AuditEngagementStatus;
import com.cbo.audit.mapper.AuditEngagementMapper;
import com.cbo.audit.mapper.AuditScheduleMapper;
import com.cbo.audit.mapper.TeamMemberMapper;
import com.cbo.audit.persistence.model.*;
import com.cbo.audit.persistence.repository.AuditEngagementRepository;
import com.cbo.audit.persistence.repository.AuditScheduleRepository;
import com.cbo.audit.persistence.repository.BudgetYearRepository;
import com.cbo.audit.persistence.repository.TeamMemberRepository;
import com.cbo.audit.service.AnnualPlanService;
import com.cbo.audit.service.AuditScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service("auditScheduleService")
@Transactional
public class AuditScheduleServiceImpl implements AuditScheduleService {

    @Autowired
    private AuditScheduleRepository auditScheduleRepository;
    @Autowired
    private AnnualPlanService annualPlanService;
    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @Autowired
    private AuditEngagementRepository auditEngagementRepository;

    @Autowired
    private BudgetYearRepository budgetYearRepository;

    @Override
    public ResultWrapper<AuditScheduleDTO> registerAuditSchedule(AuditScheduleDTO auditScheduleDTO) {

        ResultWrapper<AuditScheduleDTO> resultWrapper = new ResultWrapper<>();

        AnnualPlan annualPlan = annualPlanService.findAnnualPlanById(auditScheduleDTO.getAnnualPlan().getId());

        if (annualPlan == null){
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Annual Plan with the provided information is not available.");
            return resultWrapper;
        } else if (!annualPlan.getStatus().equals(AnnualPlanStatus.Approved.name())) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Annual Plan must be approved before scheduled.");
            return resultWrapper;
        }
        if (auditScheduleDTO.getStartOn() == null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit schedule start time cannot be null.");
            return resultWrapper;
        }

        AuditSchedule auditSchedule = AuditScheduleMapper.INSTANCE.toEntity(auditScheduleDTO);
        auditSchedule.setCreatedTimestamp(LocalDateTime.now());
        auditSchedule.setAnnualPlan(annualPlan);
        auditSchedule.setCreatedUser("TODO");
        auditSchedule.setStatus(null);

        AuditEngagement auditEngagement = new AuditEngagement();
        auditEngagement.setId(annualPlan.getId());
        auditEngagement.setYear(annualPlan.getYear());
        auditSchedule.setId(annualPlan.getId());

        auditSchedule.setAuditEngagementId(auditEngagement.getId());
        auditSchedule.setYear(annualPlan.getYear());
        AuditSchedule savedSchedule = auditScheduleRepository.save(auditSchedule);

        resultWrapper.setStatus(true);
        resultWrapper.setResult(AuditScheduleMapper.INSTANCE.toDTO(savedSchedule));
        resultWrapper.setMessage("Audit Schedule created successfully.");

        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AuditScheduleDTO>> getAllAuditSchedule() {
        String year = budgetYearRepository.findAll(Sort.by(Sort.Direction.DESC, "year")).stream().findFirst().get().getYear();

        ResultWrapper<List<AuditScheduleDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditSchedule> auditSchedules=auditScheduleRepository.findScheduleByYear(year);
        if (!auditSchedules.isEmpty()){
            List<AuditScheduleDTO> auditScheduleDTOS = AuditScheduleMapper.INSTANCE.auditSchedulesToAuditScheduleDTOs(auditSchedules);
            resultWrapper.setResult(auditScheduleDTOS);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }


    @Override
    public ResultWrapper<List<AuditScheduleDTO>> getAllAuditScheduleByYear(String year) {

        ResultWrapper<List<AuditScheduleDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditSchedule> auditSchedules=auditScheduleRepository.findScheduleByYear(year);
        if (!auditSchedules.isEmpty()){
            List<AuditScheduleDTO> auditScheduleDTOS = AuditScheduleMapper.INSTANCE.auditSchedulesToAuditScheduleDTOs(auditSchedules);
            resultWrapper.setResult(auditScheduleDTOS);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<AuditScheduleDTO> getAuditScheduleById(Long id) {

        ResultWrapper<AuditScheduleDTO> resultWrapper = new ResultWrapper<>();
        AuditSchedule auditSchedule = auditScheduleRepository.findById(id).orElse(null);
        if (auditSchedule != null){
            AuditScheduleDTO auditScheduleDTO = AuditScheduleMapper.INSTANCE.toDTO(auditSchedule);
            resultWrapper.setResult(auditScheduleDTO);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public AuditSchedule findAuditScheduleById(Long id) {
        return auditScheduleRepository.findById(id).orElse(null);
    }

    @Override
    public ResultWrapper<List<AuditScheduleDTO>> getAuditScheduleByAnnualPlanId(Long id) {

        ResultWrapper<List<AuditScheduleDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditSchedule> auditSchedules = auditScheduleRepository.findAuditScheduleByAnnualPlanId(id);
        if (auditSchedules != null){
            List<AuditScheduleDTO> auditScheduleDTOS = AuditScheduleMapper.INSTANCE.auditSchedulesToAuditScheduleDTOs(auditSchedules);
            resultWrapper.setResult(auditScheduleDTOS);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<AuditEngagementDTO> addToEngagement(AuditScheduleDTO auditScheduleDTO) {
        ResultWrapper<AuditEngagementDTO> resultWrapper = new ResultWrapper<>();

        Optional<AuditSchedule> oldAuditSchedule = auditScheduleRepository.findById(auditScheduleDTO.getId());


        if (!oldAuditSchedule.isPresent()) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit schedule must not be null.");
            return resultWrapper;
        }

        AuditEngagement auditEngagement = new AuditEngagement();
        auditEngagement.setAuditScheduleId(oldAuditSchedule.get().getId());
        auditEngagement.setStatus(AuditEngagementStatus.Scheduled);
        auditEngagement.setCreatedTimestamp(LocalDateTime.now());
        auditEngagement.setCreatedUser("TODO");
        AuditEngagement savedEngagement = auditEngagementRepository.save(auditEngagement);

        resultWrapper.setStatus(true);
        resultWrapper.setResult(AuditEngagementMapper.INSTANCE.toDTO(savedEngagement));
        resultWrapper.setMessage("Audit Engagement created successfully.");
        return resultWrapper;
    }

    @Override
    public ResultWrapper<AuditScheduleDTO> updateAuditSchedule(AuditScheduleDTO auditScheduleDTO) {
        ResultWrapper<AuditScheduleDTO> resultWrapper = new ResultWrapper<>();

        Optional<AuditSchedule> oldAuditSchedule = auditScheduleRepository.findById(auditScheduleDTO.getId());


        if (!oldAuditSchedule.isPresent()) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit schedule must not be null.");
            return resultWrapper;
        } else if (auditScheduleDTO.getStartOn() == null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit schedule start time cannot be null.");
            return resultWrapper;
        }

        AuditSchedule auditSchedule = AuditScheduleMapper.INSTANCE.toEntity(auditScheduleDTO);
        auditSchedule.setCreatedUser(oldAuditSchedule.get().getCreatedUser());
        auditSchedule.setCreatedTimestamp(oldAuditSchedule.get().getCreatedTimestamp());
        auditSchedule.setAuditEngagementId(oldAuditSchedule.get().getAuditEngagementId());
        auditSchedule.setAnnualPlan(oldAuditSchedule.get().getAnnualPlan());


        AuditSchedule savedSchedule = auditScheduleRepository.save(auditSchedule);

        resultWrapper.setStatus(true);
        resultWrapper.setResult(AuditScheduleMapper.INSTANCE.toDTO(savedSchedule));
        resultWrapper.setMessage("Audit Schedule updated successfully.");
        return resultWrapper;
    }



}
