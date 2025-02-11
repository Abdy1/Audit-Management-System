package com.cbo.audit.service;

import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.dto.EngagementDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.persistence.model.AuditSchedule;

import java.util.List;

public interface AuditScheduleService {


    ResultWrapper<AuditScheduleDTO> registerAuditSchedule(AuditScheduleDTO auditUniverseDTO);

    ResultWrapper<List<AuditScheduleDTO>> getAllAuditSchedule();

    ResultWrapper<AuditScheduleDTO> getAuditScheduleById(Long id);

    AuditSchedule findAuditScheduleById(Long id);

    ResultWrapper<List<AuditScheduleDTO>> getAllAuditScheduleByYear(String year);

    ResultWrapper<List<AuditScheduleDTO>> getAllAuditScheduleByQuarter(int quarter);

    ResultWrapper<AuditScheduleDTO> updateAuditSchedule(AuditScheduleDTO auditUniverseDTO);

    ResultWrapper<EngagementDTO> addAuditScheduleToEngagement(EngagementDTO engagementDTO);

    ResultWrapper<List<AuditScheduleDTO>> getAuditScheduleByAnnualPlanId(Long id);
}
