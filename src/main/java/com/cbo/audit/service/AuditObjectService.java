package com.cbo.audit.service;

import com.cbo.audit.dto.AuditObjectDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.persistence.model.AuditObject;
import com.cbo.audit.persistence.model.AuditType;

import java.util.List;
import java.util.Optional;

public interface AuditObjectService {

    ResultWrapper<AuditObjectDTO> registerAuditObject(AuditObjectDTO auditObjectDTO);

    ResultWrapper<List<AuditObjectDTO>> getAllAuditObject();

    ResultWrapper<AuditObjectDTO> getAuditObjectById(Long id);

    Optional<AuditObject> findAuditObjectById(Long id);

    ResultWrapper<AuditObjectDTO> updateAuditObject(AuditObjectDTO auditObjectDTO);

    ResultWrapper<List<AuditType>> getAllAuditType();

    ResultWrapper<List<AuditObjectDTO>> getAuditObjectByAuditType(String auditType);
}
