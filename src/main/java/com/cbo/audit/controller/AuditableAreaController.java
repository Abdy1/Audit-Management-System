package com.cbo.audit.controller;

import com.cbo.audit.constants.URIs;
import com.cbo.audit.dto.AuditableAreaDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.service.AuditableAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuditableAreaController {

    @Autowired
    AuditableAreaService auditableAreaService;
    @PostMapping(value = URIs.AUDITABLE_AREA_REGISTER, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditableAreaDTO>> auditableAreaRegister(@RequestBody AuditableAreaDTO auditableAreaDTO){

        ResultWrapper<AuditableAreaDTO> resultWrapper=auditableAreaService.registerAuditableArea(auditableAreaDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }


    @GetMapping(value = URIs.AUDITABLE_AREA_LIST_ALL,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<AuditableAreaDTO>>> listAllAuditableArea(){

        ResultWrapper<List<AuditableAreaDTO>> resultWrapper=auditableAreaService.getAllAuditableArea();

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.AUDITABLE_AREA_BY_ID, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditableAreaDTO>> getAuditableAreaById(@RequestBody AuditableAreaDTO auditableAreaDTO){

        ResultWrapper<AuditableAreaDTO> resultWrapper=auditableAreaService.getAuditableAreaById(auditableAreaDTO.getId());

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.AUDITABLE_AREA_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditableAreaDTO>> updateAuditableArea(@RequestBody AuditableAreaDTO auditableAreaDTO){

        ResultWrapper<AuditableAreaDTO> resultWrapper=auditableAreaService.updateAuditableArea(auditableAreaDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }
}
