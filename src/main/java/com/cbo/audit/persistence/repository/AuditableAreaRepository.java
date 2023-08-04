package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.AuditableArea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditableAreaRepository extends JpaRepository<AuditableArea, Long> {

    List<AuditableArea> findByName(String name);

}
