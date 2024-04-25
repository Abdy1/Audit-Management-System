package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.AnnualPlan;
import com.cbo.audit.persistence.model.WBS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditProgramWBSRepository extends JpaRepository<WBS, Long> {
    @Query(" SELECT AN FROM WBS AN WHERE AN.auditProgram.id= :auditProgram_id")
    List<WBS> findAllWBSByAuditProgramId(@Param("auditProgram_id") Long auditProgram_id);
}
