package com.cbo.audit.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ams_audit_wbs")
public class WBS extends BaseEntity{


    @Column
    private String name;

    //for discussion
    @Column
    private String description;

    @ManyToOne
    private AuditProgram auditProgram;

    @Column
    private String status;

    @Column
    private String startOn;

    @Column
    private String endOn;

    @Column
    private int numberOfDays;

}
