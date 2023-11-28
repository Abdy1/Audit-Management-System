package com.cbo.audit.service;

import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.FindingDTO;
import com.cbo.audit.dto.ResultWrapper;

import java.util.List;

public interface AuditProgramFindingService {
    ResultWrapper<FindingDTO> registerAuditProgramFinding(FindingDTO findingDTO);
    ResultWrapper<List<FindingDTO>> listAllFindingsByAuditProgramId(Long id);
    ResultWrapper<FindingDTO> updateAuditProgramFinding(FindingDTO findingDTO);

}
