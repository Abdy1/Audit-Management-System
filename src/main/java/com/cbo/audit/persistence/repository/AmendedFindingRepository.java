package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.AmendedFinding;
import com.cbo.audit.persistence.model.AnnualPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmendedFindingRepository extends JpaRepository<AmendedFinding, Long> {
    @Query(" SELECT AN FROM AmendedFinding AN WHERE AN.finding.id = :findingId")
    List<AmendedFinding> findAllAmendedFindingByFindingId(@Param("findingId") Long findingId);
}
