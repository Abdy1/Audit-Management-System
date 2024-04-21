package com.cbo.audit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditScheduleDTO extends BaseDTO{
    private String startOn;

    private String endOn;

    private String status;

    private int quarter;

    private String auditeesOrganID;

    private LocalDate dateCompleted;

    private double totalCost;

    private boolean involvesTravel;

    private List<TeamMemberDTO> teamMembers;

    private AnnualPlanDTO annualPlan;

}
