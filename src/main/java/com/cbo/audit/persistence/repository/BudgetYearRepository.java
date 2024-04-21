package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.BudgetYear;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BudgetYearRepository extends JpaRepository<BudgetYear, Long> {

    Optional<BudgetYear> findByYear(String year);
}
