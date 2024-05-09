package com.cbo.audit.persistence.repository;

import com.cbo.audit.enums.AuditStaffStatus;
import com.cbo.audit.persistence.model.AuditStaff;
import com.cbo.audit.persistence.model.AuditTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuditTeamRepository extends JpaRepository<AuditTeam, Long> {

    @Query("SELECT AT FROM AuditTeam AT WHERE AT.employeeId = :id")
    AuditTeam findAuditTeamByUserId(@Param("id") String employeeId);

    @Query("SELECT AT FROM AuditStaff AT WHERE AT.employeeId = :id")
    Optional<AuditTeam> findAuditTeamByEmployeeId(@Param("id") String employeeId);

    @Query(" SELECT AST FROM AuditTeam AST  "
            + " WHERE AST.status = :status")
    List<AuditTeam> findAuditTeamByState(@Param("status") AuditStaffStatus status);
}
