package com.cbo.audit.service;

import com.cbo.audit.dto.AuditProgramMainActivityDTO;

import com.cbo.audit.dto.AuditProgramWBSDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.persistence.model.AuditProgramMainActivity;

import java.util.List;

public interface AuditProgramMainActivityService {

    ResultWrapper<List<AuditProgramMainActivityDTO>> getAllMainActivityByAuditProgramId(Long auditProgram_id);
    ResultWrapper<AuditProgramMainActivityDTO> registerAuditProgramMainActivity(AuditProgramMainActivityDTO auditProgramMainActivityDTO);
}
