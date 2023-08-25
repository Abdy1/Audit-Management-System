package com.cbo.audit.service.impl;

import com.cbo.audit.dto.*;
import com.cbo.audit.enums.AnnualPlanStatus;
import com.cbo.audit.mapper.AnnualPlanMapper;
import com.cbo.audit.mapper.WBSMapper;
import com.cbo.audit.persistence.model.AnnualPlan;
import com.cbo.audit.persistence.model.AuditProgram;
import com.cbo.audit.persistence.model.WBS;
import com.cbo.audit.persistence.repository.AuditProgramWBSRepository;
import com.cbo.audit.service.AuditProgramService;
import com.cbo.audit.service.WBSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service("wbsService")
@Transactional
public class WBSServiceImpl implements WBSService {
    @Autowired
    private AuditProgramWBSRepository  auditProgramWBSRepository;
    @Autowired
    private AuditProgramService auditProgramService;
    @Override
    public ResultWrapper<List<AuditProgramWBSDTO>> getAllWBSByAuditProgramId(Long auditProgram_id) {
        ResultWrapper<List<AuditProgramWBSDTO>> resultWrapper= new ResultWrapper<>();
        List<WBS> auditProgramWBSs  = auditProgramWBSRepository.findAllWBSByAuditProgramId(auditProgram_id);
        if (auditProgramWBSs != null){
            List<AuditProgramWBSDTO> auditProgramWBSDTOs = WBSMapper.INSTANCE.wbsToAuditProgramWBSDTOs(auditProgramWBSs);
            resultWrapper.setResult(auditProgramWBSDTOs);
            resultWrapper.setStatus(true);
        }

        return resultWrapper;
    }

    @Override
    public ResultWrapper<AuditProgramWBSDTO> registerAuditProgramWBS(AuditProgramWBSDTO auditProgramWBSDTO) {
            ResultWrapper<AuditProgramWBSDTO> resultWrapper = new ResultWrapper<>();

           // Optional<AuditUniverse> auditUniverseOpt = annualPlanService.findAuditUniverseById(annualPlanDTO.getAuditUniverse().getId());
        Optional<AuditProgram> auditProgramOpt = auditProgramService.findAuditProgramBy(auditProgramWBSDTO.getAuditProgram().getId());

        //add attributes to be checked if they are present in the audit program

            if (!auditProgramOpt.isPresent()) {
                resultWrapper.setStatus(false);
                resultWrapper.setMessage("Audit Program with the provided information is not available.");
                return resultWrapper;
            }

            if (auditProgramWBSDTO.getName() == null) {
                resultWrapper.setStatus(false);
                resultWrapper.setMessage("Audit WBS name cannot be null.");
                return resultWrapper;
            }



            //AnnualPlan annualPlan = AnnualPlanMapper.INSTANCE.toEntity(annualPlanDTO;

                    WBS wbs = WBSMapper.INSTANCE.toEntity(auditProgramWBSDTO);
            wbs.setCreatedTimestamp(LocalDateTime.now());

            wbs.setCreatedUser("TODO");
            wbs.setStatus(AnnualPlanStatus.Planned.getType());

            WBS savedWBS = auditProgramWBSRepository.save(wbs);


            resultWrapper.setStatus(true);
            resultWrapper.setResult(WBSMapper.INSTANCE.toDTO(savedWBS));
            resultWrapper.setMessage("Audit Program WBS created successfully.");
            return resultWrapper;
        }
    }



