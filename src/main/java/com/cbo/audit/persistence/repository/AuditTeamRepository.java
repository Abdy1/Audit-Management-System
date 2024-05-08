package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.AuditStaff;
import com.cbo.audit.persistence.model.AuditTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuditTeamRepository extends JpaRepository<AuditTeam, Long> {

    @Query("SELECT AT FROM AuditTeam AT WHERE AT.employeeId = :id")
    AuditTeam findAuditTeamByUserId(@Param("id") String employeeId);
}
