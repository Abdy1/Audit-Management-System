package com.cbo.audit.controller;

import com.cbo.audit.dto.FindingDTO;
import com.cbo.audit.dto.ResultWrapper;

import com.cbo.audit.persistence.model.Finding;
import com.cbo.audit.persistence.repository.FindingRepository;
import com.cbo.audit.service.AuditProgramFindingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

import java.util.List;

import static com.cbo.audit.constants.URIs.*;

@RestController
public class AuditProgramFindingController {
    @Autowired
    private  AuditProgramFindingService auditProgramFindingService;
    @PostMapping(value = AUDIT_PROGRAM_FINDING_REGISTER,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<FindingDTO>> addFindingToAuditProgram(@RequestBody FindingDTO findingDTO){

ResultWrapper<FindingDTO> resultWrapper=auditProgramFindingService.registerAuditProgramFinding(findingDTO);
        return new ResponseEntity<>(resultWrapper,HttpStatus.CREATED);


    }
    @GetMapping(value = LIST_ALL_FINDINGS_BY_AUDIT_PROGRAM_ID,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<FindingDTO>>> listAllAuditProgramFindingsByAuditProgramId(@PathVariable(name = "id") Long auditProgramId){
        ResultWrapper<List<FindingDTO>> resultWrapper=auditProgramFindingService.listAllFindingsByAuditProgramId(auditProgramId);

        return new ResponseEntity<>(resultWrapper,HttpStatus.OK);
    }
    @PostMapping(value = UPDATE_AUDIT_PROGRAM_FINDING,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<FindingDTO>> updateAuditProgramFinding(@RequestBody FindingDTO findingDTO){
        ResultWrapper<FindingDTO> resultWrapper=auditProgramFindingService.updateAuditProgramFinding(findingDTO);
        return new ResponseEntity<>(resultWrapper,HttpStatus.OK);
    }
}
