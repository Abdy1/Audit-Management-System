package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.AuditProgramMainActivity;
import com.cbo.audit.persistence.model.WBS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Repository
public interface AuditProgramMainActivityRepository extends JpaRepository<AuditProgramMainActivity,Long> {
    @Query(" SELECT AN FROM AuditProgramMainActivity AN WHERE AN.auditProgram.id= :auditProgram_id")
    List<AuditProgramMainActivity> findAllMainActivityByAuditProgramId(@Param("auditProgram_id") Long auditProgram_id);
}
