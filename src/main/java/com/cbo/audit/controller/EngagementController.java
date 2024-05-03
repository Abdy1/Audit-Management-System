package com.cbo.audit.controller;

import com.cbo.audit.constants.URIs;
import com.cbo.audit.dto.EngagementDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.service.EngagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class EngagementController {

    @Autowired
    private EngagementService engagementService;

    @GetMapping(value = URIs.GET_AUDIT_ENGAGEMENT_BY_YEAR, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<EngagementDTO>>> getAllAuditEngagementByYear(@RequestParam(name = "year") String year) {

        ResultWrapper<List<EngagementDTO>> resultWrapper = engagementService.getAllAuditEngagementByYear(year);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = URIs.GET_AUDIT_ENGAGEMENT_BY_STATUS, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<EngagementDTO>>> getAllAuditEngagementByStatus(@PathVariable(name = "status") String status) {

        ResultWrapper<List<EngagementDTO>> resultWrapper = engagementService.getAllAuditEngagementByStatus(status);
        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }
}
