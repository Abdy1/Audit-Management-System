package com.cbo.audit.dto;

import com.cbo.audit.persistence.model.AuditSchedule;
import com.cbo.audit.persistence.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditProgramDTO extends BaseDTO {
private String name;

    private String status;


    private String previousStatus;


    private List<AuditProgramObjectiveDTO> objectives;
    private String previousDescription;


    private String scopeDescription;
    private String methodology;

    private String OverAllTime;

    private EngagementDTO engagementInfo;


}
