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
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("auditTeamService")
public class AuditTeamServiceImpl implements AuditTeamService {

    @Autowired
    private AuditTeamRepository auditTeamRepository;

    private String noRecord = "No record found";

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
        ResultWrapper<AuditTeamDTO> resultWrapper = new ResultWrapper<>();
        Optional<AuditTeam> auditTeam = auditTeamRepository.findById(id);
        if (auditTeam.isPresent()) {
            AuditTeamDTO auditStaffDTO = AuditTeamMapper.INSTANCE.toDTO(auditTeam.get());
            resultWrapper.setResult(auditStaffDTO);
            resultWrapper.setStatus(true);
        } else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("No record found with the provided id.");
        }
        return resultWrapper;
    }

    @Override
    public Optional<AuditTeam> findAuditTeamByEmployeeId(String employeeId) {
        return auditTeamRepository.findAuditTeamByEmployeeId(employeeId);
    }

    @Override
    public Optional<AuditTeam> findAuditTeamById(Long id) {
        return auditTeamRepository.findById(id);
    }

    @Override
    public ResultWrapper<AuditTeamDTO> removeAuditTeam(AuditTeamDTO auditTeamDTO) {

        ResultWrapper<AuditTeamDTO> resultWrapper = new ResultWrapper<>();
        Optional<AuditTeam> auditTeam = auditTeamRepository.findById(auditTeamDTO.getId());
        if (auditTeam.isPresent()) {
            auditTeamRepository.delete(auditTeam.get());
            resultWrapper.setStatus(true);
            resultWrapper.setMessage("Deleted successfully");
        } else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Incorrect team Id");
        }

        return resultWrapper;
    }

    @Override
    public ResultWrapper<AuditTeamDTO> updateAuditTeam(AuditTeamDTO auditTeamDTO) {
        ResultWrapper<AuditTeamDTO> resultWrapper = new ResultWrapper<>();

        Optional<AuditTeam> oldAuditTeam = auditTeamRepository.findById(auditTeamDTO.getId());

        if (!oldAuditTeam.isPresent()) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Invalid team member id");
        } else {
            AuditTeam updatedTeam = oldAuditTeam.get();
            updatedTeam.setStatus(auditTeamDTO.getStatus());
            updatedTeam.setModifiedTimestamp(LocalDateTime.now());
            AuditTeam saveMember = auditTeamRepository.save(updatedTeam);
            resultWrapper.setResult(AuditTeamMapper.INSTANCE.toDTO(saveMember));
            resultWrapper.setStatus(true);
        }

        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AuditTeamDTO>> getAllAuditTeams() {
        ResultWrapper<List<AuditTeamDTO>> resultWrapper = new ResultWrapper<>();
        resultWrapper.setResult(AuditTeamMapper.INSTANCE.AuditTeamsToAuditTeamDTOs(auditTeamRepository.findAll()));
        resultWrapper.setStatus(true);
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AuditTeamDTO>> getAllActiveAuditTeams() {
        ResultWrapper<List<AuditTeamDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditTeam> auditTeams = auditTeamRepository.findAuditTeamByState(AuditStaffStatus.Active);
        if(auditTeams.isEmpty()){
            resultWrapper.setStatus(true);
            resultWrapper.setMessage(noRecord);
            resultWrapper.setResult(new ArrayList<>());
        }else{
            resultWrapper.setResult(AuditTeamMapper.INSTANCE.AuditTeamsToAuditTeamDTOs(auditTeams));
            resultWrapper.setStatus(true);
        }

        return resultWrapper;
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
