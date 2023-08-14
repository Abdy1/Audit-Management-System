package com.cbo.audit.persistence.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ams_audit_program")
public class AuditProgram extends BaseEntity{

    @Column
    private String status;

    //for discussion
    @Column
    private String previousStatus;

    @OneToMany
    private List<Objective> objectives;

    @Column
    private String scopeDescription;

    @Column
    private String OverAllTime;

    @ManyToOne
    @JoinColumn(name = "AUDIT_ENGAGEMENT_ID")
    private AuditEngagement auditEngagement;
}
