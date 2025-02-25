package com.cbo.audit.persistence.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ams_risk_score")
public class RiskScore extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "RISK_ITEM_ID")
    private RiskItem riskItem;

    @ManyToOne
    @JoinColumn(name = "ANNUAL_PLAN_ID")
    @JsonBackReference
    private AnnualPlan annualPlan;



    @Column(name = "IMPACT")
    private int impact;


    @Column(name = "TOTAL")
    private int total;
}
