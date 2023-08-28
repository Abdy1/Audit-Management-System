package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {

    @Query("SELECT RSC FROM Resource RSC WHERE RSC.auditSchedule.id = :scheduleId")
    List<Resource> findAllResourcesOfSchedule(@Param("scheduleId") Long scheduleId);
}
