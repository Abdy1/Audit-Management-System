package com.cbo.audit.dto;

import com.cbo.audit.persistence.model.AnnualPlan;
import com.cbo.audit.persistence.model.AuditEngagement;
import com.cbo.audit.persistence.model.TeamMember;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditScheduleDTO extends BaseDTO{
    private String startOn;

    private String endOn;

    private String status;

    private String quarter;

    private AuditEngagementDTO auditEngagement;

    private List<TeamMemberDTO> teamMembers;

    private AnnualPlanDTO annualPlan;

}
