package com.cbo.audit.service.impl;

import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.dto.EngagementDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.service.EngagementService;

import java.util.List;

public class EngagementServiceImpl implements EngagementService {
    @Override
    public ResultWrapper<EngagementDTO> getAuditEngagementBySchedule(AuditScheduleDTO auditScheduleDTO) {
        return null;
    }

    @Override
    public ResultWrapper<List<EngagementDTO>> getAuditEngagements() {
        return null;
    }

    @Override
    public ResultWrapper<List<EngagementDTO>> getAllAuditEngagementByQuarter(int quarter) {
        return null;
    }

    @Override
    public ResultWrapper<List<EngagementDTO>> getAllAuditEngagementByYear(String year) {
        return null;
    }

    @Override
    public ResultWrapper<List<EngagementDTO>> getAllAuditEngagementByStatus(String status) {
        return null;
    }
}
