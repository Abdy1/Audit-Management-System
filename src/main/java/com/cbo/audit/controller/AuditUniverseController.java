package com.cbo.audit.controller;


import com.cbo.audit.constants.URIs;
import com.cbo.audit.dto.AuditUniverseDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.service.AuditUniverseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuditUniverseController {
    @Autowired
    AuditUniverseService auditUniverseService;
    @PostMapping(value = URIs.AUDIT_UNIVERSE_REGISTER, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditUniverseDTO>> auditUniverseRegister(@RequestBody AuditUniverseDTO auditUniverseDTO){

    ResultWrapper<AuditUniverseDTO> resultWrapper=auditUniverseService.registerAuditUniverse(auditUniverseDTO);

    return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = URIs.AUDIT_UNIVERSE_LIST_ALL,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<AuditUniverseDTO>>> listAllAuditUniverse(){
        ResultWrapper<List<AuditUniverseDTO>> resultWrapper=auditUniverseService.getAllAuditUniverse();

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.AUDIT_UNIVERSE_BY_ID,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditUniverseDTO>> getAuditUniverseById(@RequestBody AuditUniverseDTO auditUniverseDTO){

        ResultWrapper<AuditUniverseDTO> resultWrapper=auditUniverseService.getAuditUniverseById(auditUniverseDTO.getId());

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.AUDIT_UNIVERSE_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditUniverseDTO>> updateAuditUniverse(@RequestBody AuditUniverseDTO auditUniverseDTO){

        ResultWrapper<AuditUniverseDTO> resultWrapper=auditUniverseService.updateAuditUniverse(auditUniverseDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.AUDIT_UNIVERSE_APPROVE, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditUniverseDTO>> approveAuditUniverse(@RequestBody AuditUniverseDTO auditUniverseDTO){

        ResultWrapper<AuditUniverseDTO> resultWrapper=auditUniverseService.approveAuditUniverse(auditUniverseDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }


}
