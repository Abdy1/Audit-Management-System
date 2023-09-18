package com.cbo.audit.dto;

import com.cbo.audit.persistence.model.AuditSchedule;
import com.cbo.audit.persistence.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditProgramDTO extends BaseEntity {


    private String status;


    private String previousStatus;


    private String objectives;


    private String scopeDescription;


    private String OverAllTime;

    private AuditSchedule auditSchedule;


}
