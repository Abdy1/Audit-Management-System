package com.cbo.audit.controller;

import com.cbo.audit.constants.URIs;
import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.AuditObjectDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.service.AuditObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AuditObjectController {

    @Autowired
    AuditObjectService auditObjectService;

    @PostMapping(value = URIs.AUDIT_OBJECT_REGISTER, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditObjectDTO>> auditObjectRegister(@RequestBody AuditObjectDTO auditObjectDTO) {

        ResultWrapper<AuditObjectDTO> resultWrapper = auditObjectService.registerAuditObject(auditObjectDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = URIs.AUDIT_OBJECT_LIST_ALL, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<AuditObjectDTO>>> listAllAuditObject() {

        ResultWrapper<List<AuditObjectDTO>> resultWrapper = auditObjectService.getAllAuditObject();

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.AUDIT_OBJECT_BY_ID, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditObjectDTO>> getAuditObjectById(@RequestBody AuditObjectDTO auditObjectDTO) {

        ResultWrapper<AuditObjectDTO> resultWrapper = auditObjectService.getAuditObjectById(auditObjectDTO.getId());

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = URIs.AUDIT_OBJECT_BY_AUDIT_TYPE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<AuditObjectDTO>>> listAllAuditObject(@RequestParam("auditType") String auditType) {

        ResultWrapper<List<AuditObjectDTO>> resultWrapper = auditObjectService.getAuditObjectByAuditType(auditType);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.AUDIT_OBJECT_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditObjectDTO>> updateAuditObject(@RequestBody AuditObjectDTO auditObjectDTO) {

        ResultWrapper<AuditObjectDTO> resultWrapper = auditObjectService.updateAuditObject(auditObjectDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.APPROVE_AUDIT_OBJECT_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditObjectDTO>> approveAnnualPlan(@PathVariable("id") Long id) {

        ResultWrapper<AuditObjectDTO> resultWrapper = auditObjectService.approveAuditObject(id);
        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

}
