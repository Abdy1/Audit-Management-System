package com.cbo.audit.service;

import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.TeamMemberDTO;
import com.cbo.audit.persistence.model.TeamMember;

import java.util.List;
import java.util.Optional;

public interface TeamMemberService {

    ResultWrapper<TeamMemberDTO> registerTeamMemberToSchedule(TeamMemberDTO auditObjectDTO);

    ResultWrapper<List<TeamMemberDTO>> getAllTeamMemberOfSchedule(AuditScheduleDTO auditScheduleDTO);

    List<TeamMemberDTO> getAllTeamMemberOfScheduleSys(AuditScheduleDTO auditScheduleDTO);

    ResultWrapper<TeamMemberDTO> getTeamMemberById(Long id);

    ResultWrapper<TeamMemberDTO> getTeamMemberByAuditStaffIdAndSchedule(Long id);

    Optional<TeamMember> findTeamMemberById(Long id);

    ResultWrapper<TeamMemberDTO> removeTeamMember(TeamMemberDTO teamMemberDTO);

    ResultWrapper<TeamMemberDTO> updateTeamMember(TeamMemberDTO auditObjectDTO);

    ResultWrapper<List<TeamMemberDTO>> getTeamMemberByAuditStaffIdAndStatus(Long id, String status);

    ResultWrapper<List<AuditScheduleDTO>> getAllScheduleByAuditStaffId(Long userId);

    List<TeamMember> updateAllTeamsStatus(Long scheduleId);
}
