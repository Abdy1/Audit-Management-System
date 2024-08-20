package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.CutOff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CutOffRepository extends JpaRepository<CutOff, Long> {
}
