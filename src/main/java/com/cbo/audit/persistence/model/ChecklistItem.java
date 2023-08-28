package com.cbo.audit.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "ams_checklist_item")
public class ChecklistItem extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "auditable_area_id")
    private AuditableArea auditableArea;

}
