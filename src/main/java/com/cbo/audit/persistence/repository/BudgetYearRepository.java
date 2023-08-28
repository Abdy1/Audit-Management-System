package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.BudgetYear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetYearRepository extends JpaRepository<BudgetYear, Long> {
}
