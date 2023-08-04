package com.cbo.audit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskScoreDTO {

    private RiskItemDTO riskItem;

    private AnnualPlanDTO annualPlan;

    private int frequency;

    private int impact;

    private int total;
}
