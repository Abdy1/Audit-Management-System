package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.AuditUniverse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuditUniverseRepository extends JpaRepository<AuditUniverse, Long> {
    @Query(" SELECT AU FROM AuditUniverse AU  "
            + " WHERE AU.status = :status")
    List<AuditUniverse> findAuditUniverseByState( @Param("status") String status);

    @Query(" SELECT AU FROM AuditUniverse AU  "
            + " WHERE AU.status = :status " +
            " AND AU.name = :name ")
    List<AuditUniverse> findAuditUniverseByStateAndName( @Param("status") String status, @Param("name") String name);
}
