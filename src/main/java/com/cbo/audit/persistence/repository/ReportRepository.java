package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report,Long> {
}
