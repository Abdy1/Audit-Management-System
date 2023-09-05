package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.AnnualPlan;
import com.cbo.audit.persistence.model.AuditObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuditObjectRepository extends JpaRepository<AuditObject, Long> {

    @Query(" SELECT AO FROM AuditObject AO WHERE AO.auditType = :auditType")
    List<AuditObject> findAuditObjectsByAuditType(@Param("auditType") String auditType);
}
