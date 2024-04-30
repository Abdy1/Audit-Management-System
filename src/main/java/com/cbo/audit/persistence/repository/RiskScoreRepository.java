package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.RiskScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RiskScoreRepository extends JpaRepository<RiskScore, Long> {

    List<RiskScore> findRiskScoreByAnnualPlanId(Long annualPlanId);
}
