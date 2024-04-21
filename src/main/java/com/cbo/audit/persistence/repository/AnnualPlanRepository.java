package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.AnnualPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface AnnualPlanRepository extends JpaRepository<AnnualPlan, Long> {

    @Query(" SELECT AN FROM AnnualPlan AN WHERE AN.year = :year")
    List<AnnualPlan> findAnnualPlanByYear(@Param("year") String year);

    @Query(" SELECT AN FROM AnnualPlan AN WHERE AN.status = :status AND AN.year = :year")
    List<AnnualPlan> findAnnualPlanByStatus(@Param("status") String status,@Param("year") int year);

    @Query(" SELECT AN FROM AnnualPlan AN WHERE AN.auditUniverse.id = :universeId")
    List<AnnualPlan> findAnnualPlanByAuditUniverseId(@Param("universeId") Long universeId);

    @Query(" SELECT AN FROM AnnualPlan AN WHERE AN.auditObject.id = :objectId")
    List<AnnualPlan> findAnnualPlanByAuditObjectId(@Param("objectId") Long objectId);

}
