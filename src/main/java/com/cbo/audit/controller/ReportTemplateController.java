package com.cbo.audit.controller;

import com.cbo.audit.constants.URIs;
import com.cbo.audit.dto.*;
import com.cbo.audit.service.AnnualPlanService;
import com.cbo.audit.service.AuditScheduleService;
import com.cbo.audit.service.ReportTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReportTemplateController {

    @Autowired
    private ReportTemplateService reportTemplateService;




    @GetMapping(value = URIs.GET_REPORT_TEMPLATE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<ReportTemplateDTO>>> listAllReportTemplate() {

        ResultWrapper<List<ReportTemplateDTO>> resultWrapper = reportTemplateService.getReportTemplate();

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }
}
