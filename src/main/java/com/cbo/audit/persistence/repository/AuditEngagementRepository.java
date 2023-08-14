package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.AuditEngagement;
import com.cbo.audit.persistence.model.AuditSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuditEngagementRepository extends JpaRepository<AuditEngagement, Long> {


    @Query(" SELECT AE FROM AuditEngagement AE JOIN FETCH AE.auditSchedule WHERE AE.auditSchedule.id = :scheduleId ")
    List<AuditEngagement> findAuditEngagementByAuditScheduleId(@Param("scheduleId") Long scheduleId);
}
