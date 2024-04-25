package com.cbo.audit.service;

import com.cbo.audit.dto.AuditStaffDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.UserDTO;
import com.cbo.audit.persistence.model.AuditStaff;

import java.util.List;
import java.util.Optional;

public interface AuditStaffService {

    ResultWrapper<AuditStaffDTO> registerAuditStaff(AuditStaffDTO auditObjectDTO);

    ResultWrapper<AuditStaffDTO> getAuditStaffById(Long id);

    Optional<AuditStaff> findAuditStaffByEmployeeId(String employeeId);

    Optional<AuditStaff> findAuditStaffById(Long id);

    ResultWrapper<AuditStaffDTO> removeAuditStaff(AuditStaffDTO teamMemberDTO);

    ResultWrapper<AuditStaffDTO> updateAuditStaff(AuditStaffDTO auditObjectDTO);

    ResultWrapper<List<AuditStaffDTO>> getAllAuditStaffs();

    ResultWrapper<List<AuditStaffDTO>> getAllActiveAuditStaffs();

    ResultWrapper<List<AuditStaffDTO>> getAllByAuditTypeId(Long auditTypeId);

    ResultWrapper<List<UserDTO>> getAllUsers();

}
