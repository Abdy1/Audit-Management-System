package com.cbo.audit.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ams_audit_main_activity")
@Setter
@Getter
public class AuditProgramMainActivity extends BaseEntity{
    @Column(name = "Name")
    private String Name;
    @Column(name = "START_ON")
    private String startOn;

    @Column(name = "END_ON")
    private String endOn;
    @Column(name = "Number_of_Days")
    private String Days;
    @JoinColumn(name = "Audit_Program")
    @ManyToOne
    private AuditProgram auditProgram;
}
