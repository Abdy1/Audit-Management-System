package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.AuditObject;
import com.cbo.audit.persistence.model.ChecklistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChecklistItemRepository extends JpaRepository<ChecklistItem, Long> {


    @Query(" SELECT CI FROM ChecklistItem CI WHERE CI.auditObject.id = :auditObjectId")
    List<ChecklistItem> findChecklistItemByAuditObjectId(@Param("auditObjectId") Long auditObjectId);

    @Query(" SELECT CI FROM ChecklistItem CI WHERE CI.auditableArea.id = :auditableAreaId")
    List<ChecklistItem> findChecklistItemByAuditableAreaId(@Param("auditableAreaId") Long auditableAreaId);
}
