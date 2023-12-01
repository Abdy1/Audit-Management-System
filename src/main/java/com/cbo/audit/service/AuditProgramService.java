package com.cbo.audit.service;

import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.AuditProgramDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.persistence.model.AnnualPlan;
import com.cbo.audit.persistence.model.AuditProgram;

import java.util.List;
import java.util.Optional;

public interface AuditProgramService {
    ResultWrapper<AuditProgramDTO> registerAuditProgram(AuditProgramDTO auditProgramDTO);

    ResultWrapper<List<AuditProgramDTO>> getAllAuditProgram();

    ResultWrapper<AuditProgramDTO> getAuditProgramById(Long id);

    ResultWrapper<AuditProgramDTO> updateAuditProgram(AuditProgramDTO auditProgramDTO);


    Optional<AuditProgram> findAuditProgramById(Long id);
}
