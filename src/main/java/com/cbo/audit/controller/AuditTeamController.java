package com.cbo.audit.controller;


import com.cbo.audit.dto.AuditTeamDTO;
import com.cbo.audit.mapper.AuditTeamMapper;
import com.cbo.audit.persistence.model.AuditTeam;
import com.cbo.audit.persistence.repository.AuditTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuditTeamController {

    @Autowired
    private AuditTeamRepository auditTeamRepository;


    @GetMapping(value = "api/v1/audit-teams/{is}")
    public ResponseEntity<AuditTeamDTO> getApp(@RequestParam("id") String id){
        AuditTeam auditTeam = auditTeamRepository.findAuditTeamByTeamId(id);
        return new ResponseEntity<>(AuditTeamMapper.INSTANCE.toDTO(auditTeam), HttpStatus.OK);
    }
}


