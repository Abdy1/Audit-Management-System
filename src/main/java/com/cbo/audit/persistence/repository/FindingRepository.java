package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.AnnualPlan;
import com.cbo.audit.persistence.model.Finding;
import com.cbo.audit.persistence.model.WBS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FindingRepository extends JpaRepository<Finding, Long> {
    @Query(" SELECT AN FROM Finding AN WHERE AN.auditProgram.id= :auditProgram_id")
    List<Finding> findFindingByAuditProgramId(@Param("auditProgram_id") Long auditProgram_id);

}
