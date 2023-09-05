package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.AuditableArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuditableAreaRepository extends JpaRepository<AuditableArea, Long> {

    List<AuditableArea> findByName(String name);

    @Query(" SELECT AA FROM AuditableArea AA WHERE AA.auditObject.id = :objectId")
    List<AuditableArea> findAuditableAreasByAuditObjectId(@Param("objectId") Long objectId);

}
