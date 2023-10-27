package com.cbo.audit.service;


import com.cbo.audit.dto.AuditTypeDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.persistence.model.AuditType;

import java.util.List;

public interface AuditTypeService {

    ResultWrapper<AuditTypeDTO> registerAuditType(AuditTypeDTO checklistItemDTO);

    ResultWrapper<List<AuditTypeDTO>> getAllAuditType();

    ResultWrapper<AuditTypeDTO> getAuditTypeById(Long id);

    AuditType findAuditTypeById(Long id);

    ResultWrapper<AuditTypeDTO> updateAuditType(AuditTypeDTO checklistItemDTO);

    ResultWrapper<AuditTypeDTO> deleteAuditType(AuditTypeDTO checklistItemDTO);

}
