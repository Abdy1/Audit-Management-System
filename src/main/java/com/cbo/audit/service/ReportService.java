package com.cbo.audit.service;

import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.dto.ReportDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.persistence.model.Report;

import java.util.List;

public interface ReportService {
    ResultWrapper<ReportDTO> generateDefaultReport(AuditScheduleDTO auditScheduleDTO);
    ResultWrapper<ReportDTO> registerReport(com.cbo.audit.dto.ReportDTO reportDTO);
    ResultWrapper<ReportDTO> getReportById(Long id);

    ResultWrapper<Report> getReportById1(Long id);

    ResultWrapper<ReportDTO> getReportByScheduleId(Long id);
    ResultWrapper<List<ReportDTO>> listAllReports();
}
