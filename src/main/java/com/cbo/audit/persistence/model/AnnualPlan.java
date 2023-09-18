package com.cbo.audit.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "ams_annual_plan")
public class AnnualPlan extends BaseEntity{

    @Column(name="NAME")
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="YEAR")
    private String year;

    @Column(name="RISK_LEVEL")
    private String riskLevel;

    @Column(name="RISK_SCORE")
    private int riskScore;

    @Column(name="STATUS")
    private String status;

    @Column(name = "RECTIFICATION_STATUS")
    private double rectificationStatus;

    @ManyToOne
    @JoinColumn(name="AUDIT_UNIVERSE_ID")
    private AuditUniverse auditUniverse;

}
