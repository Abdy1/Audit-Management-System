package com.cbo.audit.controller;

import com.cbo.audit.constants.URIs;
import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.service.AuditScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScheduleController {
    @Autowired
    AuditScheduleService auditScheduleService;

    @PostMapping(value = URIs.AUDIT_SCHEDULE_REGISTER, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditScheduleDTO>> auditScheduleRegister(@RequestBody AuditScheduleDTO auditScheduleDTO){

        ResultWrapper<AuditScheduleDTO> resultWrapper=auditScheduleService.registerAuditSchedule(auditScheduleDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = URIs.AUDIT_SCHEDULE_LIST_ALL,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<AuditScheduleDTO>>> listAllAuditSchedule(){

        ResultWrapper<List<AuditScheduleDTO>> resultWrapper=auditScheduleService.getAllAuditSchedule();

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = URIs.AUDIT_SCHEDULE_BY_ID,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditScheduleDTO>> getAuditScheduleById(@PathVariable(name = "id") Long id){

        ResultWrapper<AuditScheduleDTO> resultWrapper=auditScheduleService.getAuditScheduleById(id);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = URIs.AUDIT_SCHEDULE_BY_YEAR,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<AuditScheduleDTO>>> getAllAuditScheduleByYear(@PathVariable(name = "year") String year){

        ResultWrapper<List<AuditScheduleDTO>> resultWrapper=auditScheduleService.getAllAuditScheduleByYear(year);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = URIs.AUDIT_SCHEDULE_BY_YEAR_AND_QUARTER,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<AuditScheduleDTO>>> getAllAuditScheduleByQuarter(@PathVariable(name = "quarter") int quarter){

        ResultWrapper<List<AuditScheduleDTO>> resultWrapper=auditScheduleService.getAllAuditScheduleByQuarter(quarter);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }
    @PostMapping(value = URIs.AUDIT_SCHEDULE_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditScheduleDTO>> updateAuditSchedule(@RequestBody AuditScheduleDTO auditScheduleDTO){

        ResultWrapper<AuditScheduleDTO> resultWrapper=auditScheduleService.updateAuditSchedule(auditScheduleDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

}
