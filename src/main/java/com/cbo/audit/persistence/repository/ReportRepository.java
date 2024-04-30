package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.AmendedFinding;
import com.cbo.audit.persistence.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {

    @Query(" SELECT AN FROM Report AN WHERE AN.auditSchedule.id = :scheduleId")
    Report findReportByAuditScheduleId(@Param("scheduleId") Long scheduleId);
}
