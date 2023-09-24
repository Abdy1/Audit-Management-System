package com.cbo.audit.persistence.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ams_risk_score")
public class RiskScore extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "RISK_ITEM_ID")
    private RiskItem riskItem;

    @ManyToOne
    @JoinColumn(name = "ANNUAL_PLAN_ID")
    private AnnualPlan annualPlan;

    @Column(name = "LIKELY_HOOD")
    private int likelyHood;

    @Column(name = "IMPACT")
    private int impact;

    @Column(name = "PERCENTAGE")
    private double percentage;
    @Column(name = "IS_AWAITED")
    private boolean isWaited;
    @Column(name = "TOTAL")
    private int total;
}
