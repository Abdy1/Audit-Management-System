package com.cbo.audit.controller;

import com.cbo.audit.dto.AmendedFindingDTO;
import com.cbo.audit.dto.FindingDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.service.AuditProgramFindingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.cbo.audit.constants.URIs.*;

@RestController
public class AuditProgramFindingController {
    @Autowired
    private AuditProgramFindingService auditProgramFindingService;

    @PostMapping(value = AUDIT_PROGRAM_FINDING_REGISTER, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<FindingDTO>> addFindingToAuditProgram(@RequestBody FindingDTO findingDTO) throws IOException {
        ResultWrapper<FindingDTO> resultWrapper = auditProgramFindingService.registerAuditProgramFinding(findingDTO);
        System.out.println("api");
        return new ResponseEntity<>(resultWrapper, HttpStatus.CREATED);
    }

    @PostMapping("ams/auditProgram/finding/attachEvidence/{id}")
    public ResponseEntity<ResultWrapper<String>> attachEvidence(@RequestParam("file") MultipartFile file, @PathVariable("id") Long id) throws IOException {
        ResultWrapper<String> resultWrapper = auditProgramFindingService.attachFile(file, id);
        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = LIST_ALL_FINDINGS_BY_AUDIT_PROGRAM_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<FindingDTO>>> listAllAuditProgramFindingsByAuditProgramId(@PathVariable(name = "id") Long auditProgramId) {
        ResultWrapper<List<FindingDTO>> resultWrapper = auditProgramFindingService.listAllFindingsByAuditProgramId(auditProgramId);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = UPDATE_AUDIT_PROGRAM_FINDING, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<FindingDTO>> updateAuditProgramFinding(@RequestBody FindingDTO findingDTO) {
        ResultWrapper<FindingDTO> resultWrapper = auditProgramFindingService.updateAuditProgramFinding(findingDTO);
        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = "ams/auditProgram/finding/amendedFinding/ByFindingId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<AmendedFindingDTO>>> getAllAmendedFindingsByFindingId(@PathVariable(name = "id") Long id) {
        ResultWrapper<List<AmendedFindingDTO>> resultWrapper = auditProgramFindingService.getAllAmendedFindingsByFindingId(id);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping("/ams/auditProgram/finding/getFileAttached/byFileName/{filename}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String filename) throws IOException {

        ByteArrayResource resource = auditProgramFindingService.downloadFile(filename);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }

    @GetMapping(value = "ams/auditProgram/finding/makeVisible/ByFindingId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void makeFindingVisible(@PathVariable(name = "id") Long id) {
        auditProgramFindingService.makeVisible(id);


    }

}
