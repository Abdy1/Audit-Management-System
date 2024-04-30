package com.cbo.audit.service.impl;

import com.cbo.audit.dto.AuditStaffDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.UserDTO;
import com.cbo.audit.enums.AuditStaffStatus;
import com.cbo.audit.mapper.AuditStaffMapper;
import com.cbo.audit.mapper.UserMapper;
import com.cbo.audit.persistence.model.AuditStaff;
import com.cbo.audit.persistence.repository.AuditStaffRepository;
import com.cbo.audit.persistence.repository.EmployeeRepository;
import com.cbo.audit.persistence.repository.UserRepository;
import com.cbo.audit.service.AuditStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("auditStaffService")
@Transactional
public class AuditStaffServiceImpl implements AuditStaffService {
    @Autowired
    private AuditStaffRepository auditStaffRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private String noRecord = "No record found";

    @Override
    public ResultWrapper<AuditStaffDTO> registerAuditStaff(AuditStaffDTO auditStaffDTO) {
        ResultWrapper<AuditStaffDTO> resultWrapper = new ResultWrapper<>();

        AuditStaff existAlready = auditStaffRepository.findAuditStaffByUserId(auditStaffDTO.getEmployeeId());
        if (existAlready != null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit staff already created.");
            return resultWrapper;
        }

        AuditStaff auditStaff = AuditStaffMapper.INSTANCE.toEntity(auditStaffDTO);
        auditStaff.setCreatedTimestamp(LocalDateTime.now());
        auditStaff.setStatus(AuditStaffStatus.Active);
        auditStaff.setEmployeeId(auditStaff.getEmployeeId());
        auditStaff.setFullName(auditStaff.getFullName());


        AuditStaff savedMember = auditStaffRepository.save(auditStaff);

        resultWrapper.setStatus(true);
        resultWrapper.setResult(AuditStaffMapper.INSTANCE.toDTO(savedMember));
        resultWrapper.setMessage("Team member successfully added to schedule.");
        return resultWrapper;
    }

    @Override
    public ResultWrapper<AuditStaffDTO> getAuditStaffById(Long id) {
        ResultWrapper<AuditStaffDTO> resultWrapper = new ResultWrapper<>();
        Optional<AuditStaff> auditStaff = auditStaffRepository.findById(id);
        if (auditStaff.isPresent()) {
            AuditStaffDTO auditStaffDTO = AuditStaffMapper.INSTANCE.toDTO(auditStaff.get());
            resultWrapper.setResult(auditStaffDTO);
            resultWrapper.setStatus(true);
        } else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("No record found with the provided id.");
        }
        return resultWrapper;
    }

    @Override
    public Optional<AuditStaff> findAuditStaffById(Long id) {
        return auditStaffRepository.findById(id);
    }


    @Override
    public Optional<AuditStaff> findAuditStaffByEmployeeId(String employeeId) {
        return auditStaffRepository.findAuditStaffByEmployeeId(employeeId);
    }

    @Override
    public ResultWrapper<AuditStaffDTO> removeAuditStaff(AuditStaffDTO auditStaffDTO) {
        ResultWrapper<AuditStaffDTO> resultWrapper = new ResultWrapper<>();
        Optional<AuditStaff> auditStaff = auditStaffRepository.findById(auditStaffDTO.getId());
        if (auditStaff.isPresent()) {
            auditStaffRepository.delete(auditStaff.get());
            resultWrapper.setStatus(true);
            resultWrapper.setMessage("Deleted successfully");
        } else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Incorrect team Id");
        }

        return resultWrapper;
    }

    @Override
    public ResultWrapper<AuditStaffDTO> updateAuditStaff(AuditStaffDTO auditStaffDTO) {
        ResultWrapper<AuditStaffDTO> resultWrapper = new ResultWrapper<>();

        Optional<AuditStaff> oldAuditStaff = auditStaffRepository.findById(auditStaffDTO.getId());

        if (!oldAuditStaff.isPresent()) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Invalid team member id");
        } else {
            AuditStaff updatedTeam = oldAuditStaff.get();
            updatedTeam.setStatus(auditStaffDTO.getStatus());
            updatedTeam.setModifiedTimestamp(LocalDateTime.now());
            AuditStaff saveMember = auditStaffRepository.save(updatedTeam);
            resultWrapper.setResult(AuditStaffMapper.INSTANCE.toDTO(saveMember));
            resultWrapper.setStatus(true);
        }

        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<UserDTO>> getAllUsers() {
        ResultWrapper<List<UserDTO>> resultWrapper = new ResultWrapper<>();
        resultWrapper.setResult(UserMapper.INSTANCE.usersToUserDTOs(userRepository.findAll()));
        resultWrapper.setStatus(true);
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AuditStaffDTO>> getAllAuditStaffs() {
        ResultWrapper<List<AuditStaffDTO>> resultWrapper = new ResultWrapper<>();
        resultWrapper.setResult(AuditStaffMapper.INSTANCE.auditStaffsToAuditStaffDTOs(auditStaffRepository.findAll()));
        resultWrapper.setStatus(true);
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AuditStaffDTO>> getAllActiveAuditStaffs() {
        ResultWrapper<List<AuditStaffDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditStaff> auditStaffs = auditStaffRepository.findAuditStaffByState(AuditStaffStatus.Active);
        if(auditStaffs.isEmpty()){
            resultWrapper.setStatus(true);
            resultWrapper.setMessage(noRecord);
            resultWrapper.setResult(new ArrayList<>());
        }else{
            resultWrapper.setResult(AuditStaffMapper.INSTANCE.auditStaffsToAuditStaffDTOs(auditStaffs));
            resultWrapper.setStatus(true);
        }

        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AuditStaffDTO>> getAllByAuditTypeId(Long auditTypeId) {
        ResultWrapper<List<AuditStaffDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditStaff> auditStaffs = auditStaffRepository.findAuditStaffByAuditTypeId(auditTypeId);
        if(auditStaffs.isEmpty()){
            resultWrapper.setStatus(true);
            resultWrapper.setMessage(noRecord);
            resultWrapper.setResult(new ArrayList<>());
        }else{
            resultWrapper.setResult(AuditStaffMapper.INSTANCE.auditStaffsToAuditStaffDTOs(auditStaffs));
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

}
