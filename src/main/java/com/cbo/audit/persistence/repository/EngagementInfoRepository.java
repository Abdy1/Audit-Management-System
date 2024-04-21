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

    @Query(" SELECT AUDIT FROM EngagementInfo AUDIT WHERE AUDIT.auditSchedule.year = :year")
    List<EngagementInfo> findEngagementByYear(@Param("year") String year);

    @Query(" SELECT AUDIT FROM EngagementInfo AUDIT WHERE AUDIT.auditSchedule.year = :year" +
            " AND AUDIT.auditSchedule.quarter = :quarter")
    List<EngagementInfo> findEngagementByYearAndQuarter(@Param("year") String year, @Param("quarter") int quarter);

    @Query(" SELECT AUDIT FROM EngagementInfo AUDIT WHERE AUDIT.auditSchedule.year = :year" +
            " AND AUDIT.auditSchedule.status = :status")
    List<EngagementInfo> findEngagementByYearAndStatus(@Param("year") String year, @Param("status") String status);
}
