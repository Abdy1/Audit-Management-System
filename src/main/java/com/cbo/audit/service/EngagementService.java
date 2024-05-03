package com.cbo.audit.service;

import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.dto.EngagementDTO;
import com.cbo.audit.dto.ResultWrapper;

import java.util.List;

public interface EngagementService {

    ResultWrapper<EngagementDTO> getAuditEngagementBySchedule(AuditScheduleDTO auditScheduleDTO);

    ResultWrapper<List<EngagementDTO>> getAuditEngagements();

    ResultWrapper<List<EngagementDTO>> getAllAuditEngagementByQuarter(int quarter);

    ResultWrapper<List<EngagementDTO>> getAllAuditEngagementByYear(String year);

    ResultWrapper<List<EngagementDTO>> getAllAuditEngagementByStatus(String status);

}
