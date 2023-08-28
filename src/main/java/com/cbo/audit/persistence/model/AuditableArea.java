package com.cbo.audit.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "ams_auditable_area")
public class AuditableArea extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "AUDIT_OBJECT_ID")
    private AuditObject auditObject;

}
