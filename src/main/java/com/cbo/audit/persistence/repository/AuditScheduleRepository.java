package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.AuditSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuditScheduleRepository extends JpaRepository<AuditSchedule, Long> {


    @Query(" SELECT AS FROM AuditSchedule AS " +
            "WHERE AS.annualPlan.id = :planId")
    List<AuditSchedule> findAuditScheduleByAnnualPlanId(@Param("planId") Long planId);
}
