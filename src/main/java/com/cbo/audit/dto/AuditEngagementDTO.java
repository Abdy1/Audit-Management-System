package com.cbo.audit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditEngagementDTO extends BaseDTO{

    private AuditScheduleDTO auditSchedule;

    private String status;
}
