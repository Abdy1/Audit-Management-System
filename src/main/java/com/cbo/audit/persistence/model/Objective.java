package com.cbo.audit.persistence.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ams_objective")
public class Objective extends BaseEntity{

    @ManyToOne
    private AuditProgram auditProgram;

}
