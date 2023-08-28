package com.cbo.audit.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ams_audit_objectives")
@Setter
@Getter
public class AuditProgramObjective extends BaseEntity{
    @Column(name="Audit_Objective")
    private String description;
    @ManyToOne
    @JoinColumn(name = "Audit_Program")
    private AuditProgram auditProgram;

}
