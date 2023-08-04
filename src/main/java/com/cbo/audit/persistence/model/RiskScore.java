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
    private AnnualPlan annualPlanId;

    @Column(name = "LIKELY_HOOD")
    private int likelyHood;

    @Column(name = "IMPACT")
    private int impact;

    @Column(name = "TOTAL")
    private int total;
}
