package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.AuditProgram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditProgramRepository extends JpaRepository<AuditProgram, Long> {

}
