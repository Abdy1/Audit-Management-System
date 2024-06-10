package com.cbo.audit.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ams_audit_object")
public class AuditObject extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;


    @Column(name = "STATUS")
    private String status;

    @ManyToOne
    @JoinColumn(name = "AUDIT_UNIVERSE_ID")
    private AuditUniverse auditUniverse;

    @ManyToOne
    @JoinColumn(name = "AUDIT_TYPE")
    private AuditType auditType;


}