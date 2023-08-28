package com.cbo.audit.service.impl;

import com.cbo.audit.dto.AuditProgramObjectiveDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.mapper.AuditProgramObjectiveMapper;
import com.cbo.audit.persistence.model.AuditProgramObjective;
import com.cbo.audit.persistence.repository.AuditProgramObjectiveRepository;
import com.cbo.audit.service.AuditProgramObjectiveService;
import com.cbo.audit.service.AuditProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("auditProgramObjectiveService")
@Transactional

public class AuditProgramObjectiveServiceImpl implements AuditProgramObjectiveService {
    @Autowired
AuditProgramObjectiveRepository auditProgramObjectiveRepository;
    @Override
    public ResultWrapper<List<AuditProgramObjectiveDTO>> getAllAuditProgramObjectiveByAuditProgramId(Long auditProgram_id) {
        ResultWrapper<List<AuditProgramObjectiveDTO>> resultWrapper= new ResultWrapper<>();
        List<AuditProgramObjective> auditProgramObjectives=auditProgramObjectiveRepository.findAllObjectiveByAuditProgramId(auditProgram_id);
        if(auditProgramObjectives!= null){
            List<AuditProgramObjectiveDTO> auditProgramObjectiveDTOS= AuditProgramObjectiveMapper.INSTANCE.auditProgramObjectiveToAuditProgramObjectiveDTOs(auditProgramObjectives);
            resultWrapper.setResult(auditProgramObjectiveDTOS);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }
}
