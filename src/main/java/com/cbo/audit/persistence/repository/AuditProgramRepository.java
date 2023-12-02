package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.AnnualPlan;
import com.cbo.audit.persistence.model.AuditProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuditProgramRepository extends JpaRepository<AuditProgram, Long> {
    @Query(" SELECT AN FROM AuditProgram AN WHERE AN.engagementInfo.id = :engagementInfo_id")
    List<AuditProgram> getAllAuditProgramByEngagementId(@Param("engagementInfo_id") Long engagementInfo_id);


}
