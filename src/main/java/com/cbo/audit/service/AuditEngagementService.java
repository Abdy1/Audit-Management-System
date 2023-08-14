package com.cbo.audit.service;

import com.cbo.audit.persistence.model.AuditEngagement;

import java.util.Optional;

public interface AuditEngagementService {
//    ResultWrapper<AuditUniverseDTO> registerAuditUniverse(AuditUniverseDTO auditUniverseDTO);
//
//    ResultWrapper<List<AuditUniverseDTO>> getAllAuditUniverse();
//
//    Optional<AuditUniverse> findAuditUniverseById(Long id);

    Optional<AuditEngagement> getAuditEngagementById(Long id);

//    ResultWrapper<AuditUniverseDTO> updateAuditUniverse(AuditUniverseDTO auditUniverseDTO);
}
