package com.cbo.audit.persistence.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "ams_audit_schedule")
public class AuditSchedule extends BaseEntity{

    @Column(name = "START_ON")
    private String startOn;

    @Column(name = "END_ON")
    private String endOn;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "QUARTER")
    private int quarter;

    @Column(name = "AUDITEES_ORGAN_ID")
    private String auditeesOrganID;

    @Column(name = "DATE_COMPLETED")
    private LocalDate dateCompleted;

    @Column(name = "TOTAL_COST")
    private double totalCost;

    @Column(name = "INVOLVES_TRAVEL")
    private boolean involvesTravel;

    @Column(name = "YEAR")
    private String year;

    @OneToMany(mappedBy = "auditSchedule", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<TeamMember> teamMembers;

    @ManyToOne
    @JoinColumn(name = "ANNUAL_PLAN_ID")
    private AnnualPlan annualPlan;

}
