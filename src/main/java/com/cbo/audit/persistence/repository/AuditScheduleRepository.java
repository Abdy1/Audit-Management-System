package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.AnnualPlan;
import com.cbo.audit.persistence.model.AuditSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuditScheduleRepository extends JpaRepository<AuditSchedule, Long> {

    @Query(" SELECT AUDIT FROM AuditSchedule AUDIT JOIN FETCH AUDIT.annualPlan WHERE AUDIT.annualPlan.id = :planId ")
    List<AuditSchedule> findAuditScheduleByAnnualPlanId(@Param("planId") Long planId);


    @Query(" SELECT AUDIT FROM AuditSchedule AUDIT WHERE AUDIT.year = :year")
    List<AuditSchedule> findScheduleByYear(@Param("year") String year);
}
