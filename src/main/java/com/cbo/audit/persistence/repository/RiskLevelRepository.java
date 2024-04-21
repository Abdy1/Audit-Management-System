package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.RiskLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiskLevelRepository extends JpaRepository<RiskLevel, Long> {
}
