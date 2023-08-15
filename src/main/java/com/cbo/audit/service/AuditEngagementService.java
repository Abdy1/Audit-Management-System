package com.cbo.audit.service;

import com.cbo.audit.dto.AuditEngagementDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.persistence.model.AuditEngagement;

import java.util.List;

public interface AuditEngagementService {

    ResultWrapper<AuditEngagementDTO> registerAuditEngagement(AuditEngagementDTO auditEngagementDTO);

    ResultWrapper<List<AuditEngagementDTO>> getAllAuditEngagement();

    ResultWrapper<AuditEngagementDTO> getAuditEngagementById(Long id);

    AuditEngagement findAuditEngagementById(Long id);

    /*    ResultWrapper<List<AuditEngagementDTO>> getAuditEngagementByYear(String year);*/

    ResultWrapper<AuditEngagementDTO> updateAuditEngagement(AuditEngagementDTO auditEngagementDTO);

    ResultWrapper<List<AuditEngagementDTO>> getAuditEngagementByAuditSchedule(Long id);

}
