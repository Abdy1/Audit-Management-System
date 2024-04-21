package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.RiskItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RiskItemRepository extends JpaRepository<RiskItem, Long> {

    List<RiskItem> findByRiskType(String riskType);
}
