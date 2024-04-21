package com.cbo.audit.service;

import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.AuditProgramWBSDTO;
import com.cbo.audit.dto.ResultWrapper;

import java.util.List;

public interface WBSService {
    ResultWrapper<List<AuditProgramWBSDTO>> getAllWBSByAuditProgramId(Long auditProgram_id);
    ResultWrapper<AuditProgramWBSDTO> registerAuditProgramWBS(AuditProgramWBSDTO auditProgramWBSDTO);
    ResultWrapper<AuditProgramWBSDTO> updateAuditProgramWBS(AuditProgramWBSDTO auditProgramWBSDTO);
}
