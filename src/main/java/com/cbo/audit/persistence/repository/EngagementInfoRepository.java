package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.AuditSchedule;
import com.cbo.audit.persistence.model.EngagementInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EngagementInfoRepository extends JpaRepository<EngagementInfo, Long> {

    @Query(" SELECT AUDIT FROM EngagementInfo AUDIT JOIN FETCH AUDIT.auditSchedule WHERE AUDIT.auditSchedule.id = :scheduleId ")
    EngagementInfo findAuditEngagementBySchedule(@Param("scheduleId") Long scheduleId);
}
