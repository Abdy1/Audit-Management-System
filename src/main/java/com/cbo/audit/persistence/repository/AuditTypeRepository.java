package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.AuditType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditTypeRepository extends JpaRepository<AuditType, Long> {
}
