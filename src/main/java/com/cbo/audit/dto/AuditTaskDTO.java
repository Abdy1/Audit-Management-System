package com.cbo.audit.dto;

import com.cbo.audit.persistence.model.AnnualPlan;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditTaskDTO extends BaseDTO{

    private String name;

    private String description;

    private String riskAssessment;

    private String status;

    private String startDate;

    private String endDate;

    private AnnualPlanDTO annualPlan;
}
