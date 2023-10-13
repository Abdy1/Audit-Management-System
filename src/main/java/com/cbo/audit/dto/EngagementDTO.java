package com.cbo.audit.dto;

import com.cbo.audit.persistence.model.AuditSchedule;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EngagementDTO {

    private String message;

    private AuditSchedule auditSchedule;

    private String refNum;

    private String date;
}
