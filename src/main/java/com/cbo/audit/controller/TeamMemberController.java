package com.cbo.audit.controller;

import com.cbo.audit.constants.URIs;
import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.dto.AuditStaffDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.TeamMemberDTO;
import com.cbo.audit.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamMemberController {
    @Autowired
    TeamMemberService teamMemberService;

    @PostMapping(value = URIs.TEAM_MEMBER_REGISTER, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<TeamMemberDTO>> teamMemberRegister(@RequestBody TeamMemberDTO teamMemberDTO) {

        ResultWrapper<TeamMemberDTO> resultWrapper = teamMemberService.registerTeamMemberToSchedule(teamMemberDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.TEAM_MEMBER_BY_ID, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<TeamMemberDTO>> getTeamMemberById(@RequestBody TeamMemberDTO teamMemberDTO) {

        ResultWrapper<TeamMemberDTO> resultWrapper = teamMemberService.getTeamMemberById(teamMemberDTO.getId());

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.TEAM_MEMBER_LIST_BY_SCHEDULE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<TeamMemberDTO>>> getAllTeamMemberOfSchedule(@RequestBody AuditScheduleDTO auditScheduleDTO) {

        ResultWrapper<List<TeamMemberDTO>> resultWrapper = teamMemberService.getAllTeamMemberOfSchedule(auditScheduleDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.TEAM_MEMBER_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<TeamMemberDTO>> updateTeamMember(@RequestBody TeamMemberDTO teamMemberDTO) {

        ResultWrapper<TeamMemberDTO> resultWrapper = teamMemberService.updateTeamMember(teamMemberDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.TEAM_MEMBER_REMOVE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<TeamMemberDTO>> removeTeamMember(@RequestBody TeamMemberDTO teamMemberDTO) {

        ResultWrapper<TeamMemberDTO> resultWrapper = teamMemberService.removeTeamMember(teamMemberDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.TEAM_MEMBER_LIST_BY_STAFF_ID, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<AuditScheduleDTO>>> getAllScheduleByAuditStaffId(@RequestBody AuditStaffDTO auditStaffDTO) {

        ResultWrapper<List<AuditScheduleDTO>> resultWrapper = teamMemberService.getAllScheduleByAuditStaffId(auditStaffDTO.getId());

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }
}
