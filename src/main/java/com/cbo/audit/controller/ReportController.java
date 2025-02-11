package com.cbo.audit.controller;

import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.dto.ReportDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.service.impl.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.cbo.audit.constants.URIs.GENERATE_REPORT;
import static com.cbo.audit.constants.URIs.REPORT_REGISTRATION;

@Controller
public class ReportController {
    @Autowired
    private ReportServiceImpl reportService;

    @PostMapping(value = GENERATE_REPORT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<ReportDTO>> generateDefaultReport(@RequestBody AuditScheduleDTO scheduleDTO) {


        return new ResponseEntity<>(reportService.generateDefaultReport(scheduleDTO), HttpStatus.OK);
    }

    @PostMapping(value = REPORT_REGISTRATION, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<ReportDTO>> registerReport(@RequestBody ReportDTO reportDTO) {
        ResultWrapper<ReportDTO> resultWrapper = reportService.registerReport(reportDTO);


        return new ResponseEntity<>(resultWrapper, HttpStatus.CREATED);
    }

    @PostMapping("ams/report/findById")
    public ResponseEntity<ResultWrapper<ReportDTO>> getReportByReportId(@RequestBody ReportDTO reportDTO) {
        ResultWrapper<ReportDTO> resultWrapper = reportService.getReportById(reportDTO.getId());

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping("ams/report/findByAuditScheduleId")
    public ResponseEntity<ResultWrapper<ReportDTO>> getReportByAuditScheduleId(@RequestBody AuditScheduleDTO auditScheduleDTO) {
        ResultWrapper<ReportDTO> resultWrapper = reportService.getReportByScheduleId(auditScheduleDTO.getId());
        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping("/listAllReports")
    public ResponseEntity<ResultWrapper<List<ReportDTO>>> listAllReports() {
        ResultWrapper<List<ReportDTO>> resultWrapper = reportService.listAllReports();


        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }


}
