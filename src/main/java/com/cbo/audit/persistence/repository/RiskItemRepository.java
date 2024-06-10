package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.RiskItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RiskItemRepository extends JpaRepository<RiskItem, Long> {

    @Query("SELECT RI FROM RiskItem RI WHERE RI.auditType.id = :auditTypeId")
    List<RiskItem> findByRiskType(@Param("auditTypeId") Long auditTypeId);
}
