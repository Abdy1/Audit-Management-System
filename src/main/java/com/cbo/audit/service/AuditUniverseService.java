package com.cbo.audit.service;

import com.cbo.audit.dto.AuditUniverseDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.persistence.model.AuditUniverse;

import java.util.List;
import java.util.Optional;

public interface AuditUniverseService {

    ResultWrapper<AuditUniverseDTO> registerAuditUniverse(AuditUniverseDTO auditUniverseDTO);

    ResultWrapper<List<AuditUniverseDTO>> getAllAuditUniverse();

    Optional<AuditUniverse> findAuditUniverseById(Long id);

    ResultWrapper<AuditUniverseDTO> getAuditUniverseById(Long id);

    ResultWrapper<AuditUniverseDTO> updateAuditUniverse(AuditUniverseDTO auditUniverseDTO);

}
