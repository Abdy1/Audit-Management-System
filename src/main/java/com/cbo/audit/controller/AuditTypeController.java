package com.cbo.audit.controller;

import com.cbo.audit.constants.URIs;
import com.cbo.audit.dto.AuditTypeDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.service.AuditTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuditTypeController {

    @Autowired
    AuditTypeService auditTypeService;

    @PostMapping(value = URIs.AUDIT_TYPE_REGISTER, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditTypeDTO>> auditTypeRegister(@RequestBody AuditTypeDTO auditTypeDTO) {

        ResultWrapper<AuditTypeDTO> resultWrapper = auditTypeService.registerAuditType(auditTypeDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = URIs.AUDIT_TYPE_LIST_ALL, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<AuditTypeDTO>>> listAllAuditType() {

        ResultWrapper<List<AuditTypeDTO>> resultWrapper = auditTypeService.getAllAuditType();

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = URIs.AUDIT_TYPE_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditTypeDTO>> getAuditTypeById(@PathVariable(name = "id") Long id) {

        ResultWrapper<AuditTypeDTO> resultWrapper = auditTypeService.getAuditTypeById(id);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.AUDIT_TYPE_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditTypeDTO>> updateAuditType(@RequestBody AuditTypeDTO auditTypeDTO) {

        ResultWrapper<AuditTypeDTO> resultWrapper = auditTypeService.updateAuditType(auditTypeDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.AUDIT_TYPE_DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditTypeDTO>> deleteAuditType(@RequestBody AuditTypeDTO auditTypeDTO) {

        ResultWrapper<AuditTypeDTO> resultWrapper = auditTypeService.deleteAuditType(auditTypeDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

}
