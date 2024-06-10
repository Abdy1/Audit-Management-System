package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.AnnualPlan;
import com.cbo.audit.persistence.model.RiskLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RiskLevelRepository extends JpaRepository<RiskLevel, Long> {

    RiskLevel findByAuditTypeId(Long id);

}
