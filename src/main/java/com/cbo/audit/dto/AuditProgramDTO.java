package com.cbo.audit.dto;

import com.cbo.audit.persistence.model.AuditSchedule;
import com.cbo.audit.persistence.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditProgramDTO extends BaseDTO {
private String name;

    private String status;


    private String previousStatus;


    private String objectives;
    private String previousDescription;


    private String scopeDescription;
    private String methodology;

    private String OverAllTime;

    private EngagementDTO engagementInfo;


}
