package com.cbo.audit.dto;

import com.cbo.audit.persistence.model.AuditSchedule;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EngagementDTO extends BaseDTO{

    private String message;

    private AuditScheduleDTO auditSchedule;

    private String refNum;

    private String date;
}
