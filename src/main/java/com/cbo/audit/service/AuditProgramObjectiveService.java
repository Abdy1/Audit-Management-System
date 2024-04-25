package com.cbo.audit.service;

import com.cbo.audit.dto.AuditProgramObjectiveDTO;
import com.cbo.audit.dto.ResultWrapper;

import java.util.List;

public interface AuditProgramObjectiveService {

    ResultWrapper<List<AuditProgramObjectiveDTO>> getAllAuditProgramObjectiveByAuditProgramId(Long auditProgram_id);

    ResultWrapper<AuditProgramObjectiveDTO> registerAuditProgramObjective(AuditProgramObjectiveDTO auditProgramObjectiveDTO);

    ResultWrapper<AuditProgramObjectiveDTO> updateAuditProgramObjective(AuditProgramObjectiveDTO auditProgramObjectiveDTO);
}
