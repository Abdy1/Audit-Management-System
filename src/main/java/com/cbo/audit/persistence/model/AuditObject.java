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
public class AuditObject extends BaseEntity{

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AUDIT_TYPE")
    private String auditType;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ams_audit_object_universe",
            joinColumns = @JoinColumn(name = "audit_object_id"),
            inverseJoinColumns = @JoinColumn(name = "audit_universe_id"))
    private Set<AuditUniverse> auditUniverses = new HashSet<>();

}