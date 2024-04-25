package com.cbo.audit.service.impl;

import com.cbo.audit.dto.*;
import com.cbo.audit.enums.AuditProgramStatus;
import com.cbo.audit.mapper.AuditProgramMapper;
import com.cbo.audit.mapper.AuditProgramObjectiveMapper;
import com.cbo.audit.mapper.EngagementMapper;
import com.cbo.audit.persistence.model.*;
import com.cbo.audit.persistence.repository.*;
import com.cbo.audit.service.AuditProgramService;
import com.cbo.audit.service.AuditScheduleService;
import com.cbo.audit.service.AuditUniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("auditProgramService")
@Transactional
public class AuditProgramServiceImpl implements AuditProgramService {

    @Autowired
    private AuditUniverseService annualPlanService;
@Autowired
AuditScheduleRepository auditScheduleRepository;
    @Autowired
    private AuditScheduleService auditScheduleService;
    @Autowired
    private AuditProgramRepository auditProgramRepository;
    @Autowired
    EngagementInfoRepository engagementInfoRepository;
    @Autowired
    AuditProgramObjectiveRepository auditProgramObjectiveRepository;




    @Override
    public ResultWrapper<AuditProgramDTO> registerAuditProgram(AuditProgramDTO auditProgramDTO) {
        ResultWrapper<AuditProgramDTO> resultWrapper = new ResultWrapper<>();
        EngagementInfo engagementInfoOpt=engagementInfoRepository.findById(auditProgramDTO.getEngagementInfo().getId()).orElse(null);

        System.out.println(auditProgramDTO.getObjectives()+"1");


        if (engagementInfoOpt == null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Engagement with the provided information is not available.");
            return resultWrapper;
        }

        AuditProgram auditProgram = AuditProgramMapper.INSTANCE.toEntity(auditProgramDTO);

        AuditSchedule auditSchedule= auditScheduleService.findAuditScheduleById(engagementInfoOpt.getAuditSchedule().getId());
        auditSchedule.setStatus(AuditProgramStatus.Draft.name());
        auditScheduleRepository.save(auditSchedule);
        engagementInfoOpt.setStatus(AuditProgramStatus.Draft.name());

        auditProgram.setEngagementInfo(engagementInfoRepository.save(engagementInfoOpt));


        auditProgram.setCreatedTimestamp(LocalDateTime.now());

        List<AuditProgramObjectiveDTO> objectives=auditProgramDTO.getObjectives();

        List<AuditProgramObjective> savedObjectives=new ArrayList<>();

for(AuditProgramObjectiveDTO auditProgramObjectiveDTO:objectives){
    savedObjectives.add(auditProgramObjectiveRepository.save(AuditProgramObjectiveMapper.INSTANCE.toEntity(auditProgramObjectiveDTO)));
}

if(savedObjectives.size() != auditProgramDTO.getObjectives().size()){
    resultWrapper.setStatus(false);
    resultWrapper.setMessage("Unsaved objectives");
    return resultWrapper;
}

        auditProgram.setObjectives(savedObjectives);
auditProgram.setStatus(AuditProgramStatus.Draft.name());
        AuditProgram savedProgram = auditProgramRepository.save(auditProgram);




        resultWrapper.setStatus(true);
        resultWrapper.setResult(AuditProgramMapper.INSTANCE.toDTO(savedProgram));
        resultWrapper.getResult().setEngagementInfo(auditProgramDTO.getEngagementInfo());
        resultWrapper.setMessage("Audit  Program  created successfully.");
        return resultWrapper;
    }


    @Override
    public ResultWrapper<List<AuditProgramDTO>> getAllAuditProgram() {
        ResultWrapper<List<AuditProgramDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditProgram> auditPrograms=auditProgramRepository.findAll();

        if (!auditPrograms.isEmpty()){


            List<AuditProgramDTO> auditProgramDTOS = AuditProgramMapper.INSTANCE.auditProgramsToAuditProgramDTOs(auditPrograms);
            resultWrapper.setResult(auditProgramDTOS);

            resultWrapper.setStatus(true);

        }
        return resultWrapper;
    }


    @Override
    public ResultWrapper<AuditProgramDTO> getAuditProgramById(Long id) {

        ResultWrapper<AuditProgramDTO> resultWrapper = new ResultWrapper<>();
        AuditProgram auditProgram = auditProgramRepository.findById(id).orElse(null);

        if (auditProgram != null){
            AuditProgramDTO auditProgramDTO = AuditProgramMapper.INSTANCE.toDTO(auditProgram);

            resultWrapper.setResult(auditProgramDTO);
            resultWrapper.setStatus(true);

            return resultWrapper;
        }

        return resultWrapper;
    }


    @Override
    public ResultWrapper<AuditProgramDTO> updateAuditProgram(AuditProgramDTO auditProgramDTO) {
        ResultWrapper<AuditProgramDTO> resultWrapper = new ResultWrapper<>(auditProgramDTO);

        AuditProgram oldAuditProgramDTO = auditProgramRepository.findById(auditProgramDTO.getId()).orElse(null);

        if (oldAuditProgramDTO != null){
            if (auditProgramDTO.getStatus() == null){
                resultWrapper.setStatus(false);
                resultWrapper.setMessage("Audit Universe Status can not be empty.");
            }else if(auditProgramDTO.getObjectives() == null){
                resultWrapper.setStatus(false);
                resultWrapper.setMessage("Audit Universe Objectives can not be empty.");
            }else {

                AuditProgram auditProgram = AuditProgramMapper.INSTANCE.toEntity(auditProgramDTO);

                auditProgram.setCreatedTimestamp(oldAuditProgramDTO.getCreatedTimestamp());
                auditProgram.setCreatedUser(oldAuditProgramDTO.getCreatedUser());

                AuditProgram savedAuditProgram = auditProgramRepository.save(auditProgram);
                resultWrapper.setResult(AuditProgramMapper.INSTANCE.toDTO(savedAuditProgram));
                resultWrapper.setStatus(true);
                resultWrapper.setMessage("Updated Successfully.");
            }
        }else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Program  with the provided id is not available.");
        }

        return resultWrapper;
    }

    @Override
    public Optional<AuditProgram> findAuditProgramById(Long id) {
        return Optional.empty();
    }

    @Override
    public ResultWrapper<List<AuditProgramDTO>> getAllAuditProgramByEngagementId(Long engagement_id) {
        ResultWrapper<List<AuditProgramDTO>> resultWrapper=new ResultWrapper<>();
        List<AuditProgram> auditPrograms=auditProgramRepository.getAllAuditProgramByEngagementId(engagement_id);

        if(auditPrograms.isEmpty()){
            resultWrapper.setResult(null);
            resultWrapper.setMessage("Engagement does not have an Audit Program created for it");
            resultWrapper.setStatus(false);
            return resultWrapper;
        }
        resultWrapper.setResult(AuditProgramMapper.INSTANCE.auditProgramsToAuditProgramDTOs(auditPrograms));
        return resultWrapper;

    }

    @Override
    public ResultWrapper<AuditProgramDTO> changeStatusOfAuditProgramToEngagement(Long id) {
        ResultWrapper<AuditProgramDTO> resultWrapper = new ResultWrapper<>();
        AuditProgram auditProgram=auditProgramRepository.findById(id).orElse(null);
        if(auditProgram == null){
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Program with the provided id does not exist");
            resultWrapper.setResult(null);
            return resultWrapper;
        }
        EngagementInfo engagementInfo=engagementInfoRepository.findById(auditProgram.getEngagementInfo().getId()).orElse(null);
        if(engagementInfo == null){
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Engagement with the provided information does not exist");
            resultWrapper.setResult(null);
            return resultWrapper;
        }


        AuditSchedule auditSchedule= auditScheduleService.findAuditScheduleById(auditProgram.getEngagementInfo().getAuditSchedule().getId());

        if(auditSchedule == null){
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Schedule with the provided information does not exist");
            resultWrapper.setResult(null);
            return resultWrapper;
        }

        auditSchedule.setStatus(AuditProgramStatus.Approved.name());
        auditProgram.setStatus(AuditProgramStatus.Approved.name());
        engagementInfo.setStatus(AuditProgramStatus.Approved.name());
        engagementInfoRepository.save(engagementInfo);
        auditScheduleRepository.save(auditSchedule);
        auditProgramRepository.save(auditProgram);

     /*   EngagementInfo engagementInfo=engagementInfoRepository.findById(auditProgram.getEngagementInfo().getId()).orElse(null);
        if(engagementInfo == null){
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Program with the provided id does not have engagement related to it");
            resultWrapper.setResult(null);
            return resultWrapper;
        }
        engagementInfo.setStatus()
        */
        resultWrapper.setResult(AuditProgramMapper.INSTANCE.toDTO(auditProgram));
        resultWrapper.setStatus(true);
        resultWrapper.setMessage("success");
        return resultWrapper;


    }


}
