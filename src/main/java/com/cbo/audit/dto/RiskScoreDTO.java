package com.cbo.audit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskScoreDTO extends BaseDTO{

    private RiskItemDTO riskItem;

    private AnnualPlanDTO annualPlan;

    private int likelihood;

    private int impact;

    private int total;

    private double percentage;

    private boolean isWaited;
}
