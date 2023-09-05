package com.cbo.audit.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ams_audit_universe")
public class AuditUniverse  extends BaseEntity{


    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "STATUS")
    private String status;

    @ManyToOne
    @JoinColumn(name = "AUDIT_OBJECT_ID")
    private AuditObject auditObject;
}
