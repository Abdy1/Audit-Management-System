package com.cbo.audit.service.impl;

import com.cbo.audit.dto.AuditProgramWBSDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.mapper.WBSMapper;
import com.cbo.audit.persistence.model.AuditProgram;
import com.cbo.audit.persistence.model.WBS;
import com.cbo.audit.persistence.repository.AuditProgramRepository;
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
    private AuditProgramWBSRepository auditProgramWBSRepository;
    @Autowired
    private AuditProgramService auditProgramService;
    @Autowired
    private AuditProgramRepository auditProgramRepository;

    @Override
    public ResultWrapper<List<AuditProgramWBSDTO>> getAllWBSByAuditProgramId(Long auditProgram_id) {
        ResultWrapper<List<AuditProgramWBSDTO>> resultWrapper = new ResultWrapper<>();
        System.out.println(auditProgram_id);
        List<WBS> auditProgramWBSs = auditProgramWBSRepository.findAllWBSByAuditProgramId(auditProgram_id);
        if (auditProgramWBSs != null) {
            List<AuditProgramWBSDTO> auditProgramWBSDTOs = WBSMapper.INSTANCE.wbsToAuditProgramWBSDTOs(auditProgramWBSs);
            resultWrapper.setResult(auditProgramWBSDTOs);
            resultWrapper.setStatus(true);
        }

        return resultWrapper;
    }

    @Override
    public ResultWrapper<AuditProgramWBSDTO> registerAuditProgramWBS(AuditProgramWBSDTO auditProgramWBSDTO) {
        ResultWrapper<AuditProgramWBSDTO> resultWrapper = new ResultWrapper<>();

        Optional<AuditProgram> auditProgramOpt = auditProgramRepository.findById(auditProgramWBSDTO.getAuditProgram().getId());
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

        resultWrapper.setStatus(true);
        resultWrapper.setResult(WBSMapper.INSTANCE.toDTO(saveWBS(auditProgramWBSDTO, auditProgramOpt.get())));

        resultWrapper.setMessage("Audit Program WBS created successfully.");
        return resultWrapper;
    }

    @Override
    public ResultWrapper<AuditProgramWBSDTO> updateAuditProgramWBS(AuditProgramWBSDTO auditProgramWBSDTO) {
        ResultWrapper<AuditProgramWBSDTO> resultWrapper = new ResultWrapper<>(auditProgramWBSDTO);
        WBS oldWBS = auditProgramWBSRepository.findById(auditProgramWBSDTO.getId()).orElse(null);
        if (oldWBS != null) {
            if (auditProgramWBSDTO.getStartOn() == null) {
                resultWrapper.setStatus(false);
                resultWrapper.setMessage("Audit WBS Starting Date  cannot be null.");

            } else if (auditProgramWBSDTO.getEndOn() == null) {
                resultWrapper.setStatus(false);
                resultWrapper.setMessage("Audit WBS Ending Date  cannot be null.");

            } else if (auditProgramWBSDTO.getName() == null) {
                resultWrapper.setStatus(false);
                resultWrapper.setMessage("Audit WBS name cannot be null.");

            } else {

                resultWrapper.setResult(WBSMapper.INSTANCE.toDTO(updateRecord(auditProgramWBSDTO, oldWBS)));
                resultWrapper.setStatus(true);
                resultWrapper.setMessage("Audit Program WBS updated successfully.");
            }
        } else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Program WBS with the provided id is not available.");
        }
        return resultWrapper;

    }

    private WBS saveWBS(AuditProgramWBSDTO auditProgramWBSDTO, AuditProgram auditProgram){
        WBS wBS = WBSMapper.INSTANCE.toEntity(auditProgramWBSDTO);
        wBS.setCreatedTimestamp(LocalDateTime.now());
        wBS.setModifiedTimestamp(LocalDateTime.now());
        wBS.setEndOn(null);
        wBS.setStartOn(null);

        wBS.setAuditProgram(auditProgram);
        return auditProgramWBSRepository.save(wBS);
    }

    private WBS updateRecord(AuditProgramWBSDTO auditProgramWBSDTO, WBS oldWBS){
        WBS wbs = WBSMapper.INSTANCE.toEntity(auditProgramWBSDTO);

        wbs.setCreatedTimestamp(oldWBS.getCreatedTimestamp());
        wbs.setCreatedUser(oldWBS.getCreatedUser());
        wbs.setAuditProgram(oldWBS.getAuditProgram());

        return auditProgramWBSRepository.save(wbs);
    }
}



