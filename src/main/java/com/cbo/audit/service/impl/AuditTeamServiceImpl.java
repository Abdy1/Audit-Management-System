package com.cbo.audit.service.impl;

import com.cbo.audit.dto.AuditStaffDTO;
import com.cbo.audit.dto.AuditTeamDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.UserDTO;
import com.cbo.audit.enums.AuditStaffStatus;
import com.cbo.audit.mapper.AuditStaffMapper;
import com.cbo.audit.mapper.AuditTeamMapper;
import com.cbo.audit.persistence.model.AuditStaff;
import com.cbo.audit.persistence.model.AuditTeam;
import com.cbo.audit.persistence.repository.AuditTeamRepository;
import com.cbo.audit.service.AuditTeamService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class AuditTeamServiceImpl implements AuditTeamService {

    @Autowired
    private AuditTeamRepository auditTeamRepository;

    @Override
    public ResultWrapper<AuditTeamDTO> registerAuditTeam(AuditTeamDTO auditTeamDTO) {
        ResultWrapper<AuditTeamDTO> resultWrapper = new ResultWrapper<>();

        AuditTeam existAlready = auditTeamRepository.findAuditTeamByUserId(auditTeamDTO.getEmployeeId());
        if (existAlready != null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit staff already created.");
            return resultWrapper;
        }

        AuditTeam auditTeam = AuditTeamMapper.INSTANCE.toEntity(auditTeamDTO);
        auditTeam.setCreatedTimestamp(LocalDateTime.now());
        auditTeam.setStatus(AuditStaffStatus.Active);
        auditTeam.setEmployeeId(auditTeam.getEmployeeId());
        auditTeam.setFullName(auditTeam.getFullName());


        AuditTeam savedMember = auditTeamRepository.save(auditTeam);

        resultWrapper.setStatus(true);
        resultWrapper.setResult(AuditTeamMapper.INSTANCE.toDTO(savedMember));
        resultWrapper.setMessage("Team member successfully added to schedule.");

        return resultWrapper;
    }

    @Override
    public ResultWrapper<AuditTeamDTO> getAuditTeamById(Long id) {
        return null;
    }

    @Override
    public Optional<AuditTeam> findAuditTeamByEmployeeId(String employeeId) {
        return Optional.empty();
    }

    @Override
    public Optional<AuditTeam> findAuditTeamById(Long id) {
        return Optional.empty();
    }

    @Override
    public ResultWrapper<AuditTeamDTO> removeAuditTeam(AuditTeamDTO auditTeamDTO) {
        return null;
    }

    @Override
    public ResultWrapper<AuditTeamDTO> updateAuditTeam(AuditTeamDTO auditTeamDTO) {
        return null;
    }

    @Override
    public ResultWrapper<List<AuditTeamDTO>> getAllAuditTeams() {
        return null;
    }

    @Override
    public ResultWrapper<List<AuditTeamDTO>> getAllActiveAuditTeams() {
        return null;
    }

    @Override
    public ResultWrapper<List<AuditTeamDTO>> getAllByAuditTypeId(Long auditTypeId) {
        return null;
    }

    @Override
    public ResultWrapper<List<UserDTO>> getAllUsers() {
        return null;
    }
}
