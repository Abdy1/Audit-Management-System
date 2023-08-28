package com.cbo.audit.service.impl;

import com.cbo.audit.dto.*;

import com.cbo.audit.mapper.WBSMapper;

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

        Optional<AuditProgram> auditProgramOpt =auditProgramService.findAuditProgramById(auditProgramWBSDTO.getAuditProgram().getId());
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

        if (auditProgramWBSDTO.getStartOn() == null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit WBS Starting Date  cannot be null.");
            return resultWrapper;
        }
        if (auditProgramWBSDTO.getEndOn() == null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit WBS Ending Date  cannot be null.");
            return resultWrapper;
        }
        if (auditProgramWBSDTO.getEndOn() == null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit WBS Ending Date  cannot be null.");
            return resultWrapper;
        }

            //AnnualPlan annualPlan = AnnualPlanMapper.INSTANCE.toEntity(annualPlanDTO;

                    WBS wbs = WBSMapper.INSTANCE.toEntity(auditProgramWBSDTO);
            wbs.setCreatedTimestamp(LocalDateTime.now());

            wbs.setCreatedUser("TODO");
            //wbs.setStatus(AnnualPlanStatus.Planned.getType());

            WBS savedWBS = auditProgramWBSRepository.save(wbs);


            resultWrapper.setStatus(true);
            resultWrapper.setResult(WBSMapper.INSTANCE.toDTO(savedWBS));
            resultWrapper.setMessage("Audit Program WBS created successfully.");
            return resultWrapper;
        }

    @Override
    public ResultWrapper<AuditProgramWBSDTO> updateAuditProgramWBS(AuditProgramWBSDTO auditProgramWBSDTO) {
        ResultWrapper<AuditProgramWBSDTO> resultWrapper=new ResultWrapper<>(auditProgramWBSDTO);
        WBS oldWBS=auditProgramWBSRepository.findById(auditProgramWBSDTO.getId()).orElse(null);
        if(oldWBS !=null){
            if (auditProgramWBSDTO.getStartOn() == null) {
                resultWrapper.setStatus(false);
                resultWrapper.setMessage("Audit WBS Starting Date  cannot be null.");

            }

           else if (auditProgramWBSDTO.getEndOn() == null) {
                resultWrapper.setStatus(false);
                resultWrapper.setMessage("Audit WBS Ending Date  cannot be null.");

            }
           else if (auditProgramWBSDTO.getName() == null) {
                resultWrapper.setStatus(false);
                resultWrapper.setMessage("Audit WBS name cannot be null.");

            }
            else {

                WBS wbs = WBSMapper.INSTANCE.toEntity(auditProgramWBSDTO);

                wbs.setCreatedTimestamp(oldWBS.getCreatedTimestamp());
                wbs.setCreatedUser(oldWBS.getCreatedUser());
                wbs.setAuditProgram(oldWBS.getAuditProgram());

                WBS savedWBS = auditProgramWBSRepository.save(wbs);
                resultWrapper.setResult(WBSMapper.INSTANCE.toDTO(savedWBS));
                resultWrapper.setStatus(true);
                resultWrapper.setMessage("Audit Program WBS updated successfully.");
            }
        }
        else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Program WBS with the provided id is not available.");
        }
return resultWrapper;

    }
}



