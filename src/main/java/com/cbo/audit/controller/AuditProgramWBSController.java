package com.cbo.audit.controller;

import com.cbo.audit.constants.URIs;
import com.cbo.audit.dto.AuditProgramWBSDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.service.WBSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class AuditProgramWBSController {

    @Autowired
    WBSService wbsService;

    @GetMapping(value = URIs.List_WBS_BY_AUDIT_PROGRAM_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<AuditProgramWBSDTO>>> listAllAuditProgramWBS(@PathVariable(name = "id") Long id) {
        ResultWrapper<List<AuditProgramWBSDTO>> resultWrapper = wbsService.getAllWBSByAuditProgramId(id);
        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);


    }

    @PostMapping(value = URIs.AUDIT_PROGRAM_WBS_REGISTER, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditProgramWBSDTO>> auditProgramWBSRegister(@RequestBody AuditProgramWBSDTO auditProgramWBSDTO) {

        ResultWrapper<AuditProgramWBSDTO> resultWrapper = wbsService.registerAuditProgramWBS(auditProgramWBSDTO);
        return new ResponseEntity<>(resultWrapper, HttpStatus.CREATED);
    }

    @PostMapping(value = URIs.AUDIT_PROGRAM_WBS_UPDATE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditProgramWBSDTO>> auditProgramWBSUpdate(@RequestBody AuditProgramWBSDTO auditProgramWBSDTO) {

        ResultWrapper<AuditProgramWBSDTO> resultWrapper = wbsService.updateAuditProgramWBS(auditProgramWBSDTO);
        return new ResponseEntity<>(resultWrapper, HttpStatus.CREATED);
    }

}
