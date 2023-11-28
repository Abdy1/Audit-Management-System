package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.AmendedFinding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmendedFindingRepository extends JpaRepository<AmendedFinding,Long> {

}
