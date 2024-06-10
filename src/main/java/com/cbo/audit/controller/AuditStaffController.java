package com.cbo.audit.controller;

import com.cbo.audit.constants.URIs;
import com.cbo.audit.dto.AuditStaffDTO;
import com.cbo.audit.dto.AuditTypeDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.UserDTO;
import com.cbo.audit.persistence.model.AuditStaff;
import com.cbo.audit.service.AuditStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuditStaffController {
    @Autowired
    AuditStaffService auditStaffService;

    @PostMapping(value = URIs.AUDIT_STAFF_REGISTER, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditStaffDTO>> auditStaffRegister(@RequestBody AuditStaffDTO auditStaffDTO) {

        ResultWrapper<AuditStaffDTO> resultWrapper = auditStaffService.registerAuditStaff(auditStaffDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.AUDIT_STAFF_BY_ID, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditStaffDTO>> getAuditStaffById(@RequestBody AuditStaffDTO auditStaffDTO) {

        ResultWrapper<AuditStaffDTO> resultWrapper = auditStaffService.getAuditStaffById(auditStaffDTO.getId());

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = URIs.AUDIT_STAFF_BY_USER_ID, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuditStaff> getAuditStaffById(@PathVariable String employeeId) {
        Optional<AuditStaff> theAuditStaff = auditStaffService.findAuditStaffByEmployeeId(employeeId);
        AuditStaff resultWrapper = theAuditStaff.get();

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.AUDIT_STAFF_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditStaffDTO>> updateAuditStaff(@RequestBody AuditStaffDTO auditStaffDTO) {

        ResultWrapper<AuditStaffDTO> resultWrapper = auditStaffService.updateAuditStaff(auditStaffDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.AUDIT_STAFF_REMOVE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<AuditStaffDTO>> removeAuditStaff(@RequestBody AuditStaffDTO auditStaffDTO) {

        ResultWrapper<AuditStaffDTO> resultWrapper = auditStaffService.removeAuditStaff(auditStaffDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = URIs.AUDIT_STAFF_LIST_ALL, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<AuditStaffDTO>>> getAllAuditStaffs() {

        ResultWrapper<List<AuditStaffDTO>> resultWrapper = auditStaffService.getAllAuditStaffs();

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = URIs.AUDIT_STAFF_LIST_ACTIVE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<AuditStaffDTO>>> getAllActiveAuditStaffs() {

        ResultWrapper<List<AuditStaffDTO>> resultWrapper = auditStaffService.getAllActiveAuditStaffs();

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.AUDIT_STAFF_LBY_AUDIT_TYPE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<AuditStaffDTO>>> getAllActiveAuditStaffs(@RequestBody AuditTypeDTO auditTypeDTO) {

        ResultWrapper<List<AuditStaffDTO>> resultWrapper = auditStaffService.getAllByAuditTypeId(auditTypeDTO.getId());

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = URIs.USER_LIST_BALL, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<UserDTO>>> getAllUsers() {

        ResultWrapper<List<UserDTO>> resultWrapper = auditStaffService.getAllUsers();

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }
}
