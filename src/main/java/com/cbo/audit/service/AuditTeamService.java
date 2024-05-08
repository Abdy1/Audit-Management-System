package com.cbo.audit.service;

import com.cbo.audit.dto.AuditTeamDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.UserDTO;
import com.cbo.audit.persistence.model.AuditTeam;

import java.util.List;
import java.util.Optional;

public interface AuditTeamService {

    ResultWrapper<AuditTeamDTO> registerAuditTeam(AuditTeamDTO auditTeamDTO);

    ResultWrapper<AuditTeamDTO> getAuditTeamById(Long id);

    Optional<AuditTeam> findAuditTeamByEmployeeId(String employeeId);

    Optional<AuditTeam> findAuditTeamById(Long id);

    ResultWrapper<AuditTeamDTO> removeAuditTeam(AuditTeamDTO auditTeamDTO);

    ResultWrapper<AuditTeamDTO> updateAuditTeam(AuditTeamDTO auditTeamDTO);

    ResultWrapper<List<AuditTeamDTO>> getAllAuditTeams();

    ResultWrapper<List<AuditTeamDTO>> getAllActiveAuditTeams();

    ResultWrapper<List<AuditTeamDTO>> getAllByAuditTypeId(Long auditTypeId);

    ResultWrapper<List<UserDTO>> getAllUsers();
}
