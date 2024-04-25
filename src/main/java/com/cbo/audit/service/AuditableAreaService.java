package com.cbo.audit.service;

import com.cbo.audit.dto.AuditableAreaDTO;
import com.cbo.audit.dto.ChecklistItemDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.persistence.model.AuditableArea;

import java.util.List;
import java.util.Optional;

public interface AuditableAreaService {

    ResultWrapper<AuditableAreaDTO> registerAuditableArea(AuditableAreaDTO auditableAreaDTO);

    ResultWrapper<List<AuditableAreaDTO>> getAllAuditableArea();

    ResultWrapper<List<AuditableAreaDTO>> getAuditableAreasByAuditObjectId(Long auditObjectId);

    ResultWrapper<List<ChecklistItemDTO>> getCheckListsByAuditObjectId(Long auditObjectId);

    ResultWrapper<AuditableAreaDTO> getAuditableAreaById(Long id);

    Optional<AuditableArea> findAuditableAreaById(Long id);

    ResultWrapper<AuditableAreaDTO> updateAuditableArea(AuditableAreaDTO auditableAreaDTO);

    ResultWrapper<AuditableAreaDTO> deleteAuditableArea(AuditableAreaDTO auditableAreaDTO);

}
