package com.cbo.audit.persistence.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "ams_audit_schedule")
public class AuditSchedule extends BaseEntity{

    @Column(name = "START_ON")
    private String startOn;

    @Column(name = "END_ON")
    private String endOn;

    @Column(name = "STATUS")
    private String status;

    @OneToOne(mappedBy = "auditSchedule", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private AuditEngagement auditEngagement;

    @OneToMany(mappedBy = "auditSchedule", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<TeamMember> teamMembers;

    @ManyToOne
    @JoinColumn(name = "ANNUAL_PLAN_ID")
    private AnnualPlan annualPlan;

}
