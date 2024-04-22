package com.cbo.audit.persistence.repository;

import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.enums.AuditStaffStatus;
import com.cbo.audit.persistence.model.AuditStaff;
import com.cbo.audit.persistence.model.AuditUniverse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuditStaffRepository extends JpaRepository<AuditStaff, Long> {

    @Query("SELECT AST FROM AuditStaff AST WHERE AST.employeeId = :id")
    AuditStaff findAuditStaffByUserId(@Param("id") String employeeId);

    @Query("SELECT AST FROM AuditStaff AST WHERE AST.employeeId = :id")
    Optional<AuditStaff> findAuditStaffByEmployeeId(@Param("id") String employeeId);

    @Query(" SELECT AST FROM AuditStaff AST  "
            + " WHERE AST.status = :status")
    List<AuditStaff> findAuditStaffByState(@Param("status") AuditStaffStatus status);

    @Query("SELECT AST FROM AuditStaff AST WHERE AST.auditType.id = :id")
    List<AuditStaff> findAuditStaffByAuditTypeId(@Param("id") Long id);
}
