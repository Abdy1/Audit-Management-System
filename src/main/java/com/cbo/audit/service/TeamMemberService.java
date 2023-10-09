package com.cbo.audit.service;

import com.cbo.audit.dto.*;
import com.cbo.audit.persistence.model.TeamMember;

import java.util.List;
import java.util.Optional;

public interface TeamMemberService {

    ResultWrapper<TeamMemberDTO> registerTeamMemberToSchedule(TeamMemberDTO auditObjectDTO);

    ResultWrapper<List<TeamMemberDTO>> getAllTeamMemberOfSchedule(AuditScheduleDTO auditScheduleDTO);

    ResultWrapper<TeamMemberDTO> getTeamMemberById(Long id);

    ResultWrapper<TeamMemberDTO> getTeamMemberByUserIdAndSchedule(Long id);

    Optional<TeamMember> findTeamMemberById(Long id);

    ResultWrapper<TeamMemberDTO> updateTeamMember(TeamMemberDTO auditObjectDTO);

    ResultWrapper<List<TeamMemberDTO>> getTeamMemberByUserIdAndStatus(Long id);

    ResultWrapper<List<AuditScheduleDTO>> getAllScheduleByUserId(Long userId);

    ResultWrapper<List<UserDTO>> getAllUsers();

    List<TeamMember> updateAllTeamsStatus(Long scheduleId);
}
