package com.cbo.audit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EngagementDTO extends BaseDTO {

    private String message;

    private AuditScheduleDTO auditSchedule;
    private String status;
    private String refNum;

    private String date;
}
