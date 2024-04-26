package com.cbo.audit.service;

import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.dto.ReportDTO;
import com.cbo.audit.dto.ResultWrapper;

import java.util.List;

public interface ReportService {
    ResultWrapper<ReportDTO> generateDefaultReport(AuditScheduleDTO auditScheduleDTO);
    ResultWrapper<ReportDTO> registerReport(com.cbo.audit.dto.ReportDTO reportDTO);
    ResultWrapper<ReportDTO> getReportById(Long id);

    ResultWrapper<ReportDTO> getReportByScheduleId(Long id);
    ResultWrapper<List<ReportDTO>> listAllReports();
}
