package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.AuditType;
import com.cbo.audit.persistence.model.Auditees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuditeeRepository extends JpaRepository<Auditees, Long> {
    @Query("SELECT a FROM Auditees a WHERE a.engagementInfo.id = :engagementId")
    List<Auditees> findAuditeesByEngagementId(@Param("engagementId") Long engagementId);

}
