package com.cbo.audit.service;

import com.cbo.audit.dto.AmendedFindingDTO;
import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.FindingDTO;
import com.cbo.audit.dto.ResultWrapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AuditProgramFindingService {
    ResultWrapper<FindingDTO> registerAuditProgramFinding(FindingDTO findingDTO) throws IOException;
    ResultWrapper<List<FindingDTO>> listAllFindingsByAuditProgramId(Long id);
    ResultWrapper<FindingDTO> updateAuditProgramFinding(FindingDTO findingDTO);
    ResultWrapper<List<AmendedFindingDTO>> getAllAmendedFindingsByFindingId(long id);

    ResultWrapper<String> attachFile(MultipartFile file, Long id) throws IOException;
}
