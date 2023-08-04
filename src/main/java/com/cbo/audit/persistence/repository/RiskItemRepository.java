package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.RiskItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiskItemRepository extends JpaRepository<RiskItem, Long> {
}
