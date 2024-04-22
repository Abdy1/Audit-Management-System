package com.cbo.audit.dto;

import com.cbo.audit.enums.AuditStaffStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditStaffDTO extends BaseDTO{

    private AuditTypeDTO auditType;

    private String employeeId;

    private String fullName;

    private AuditStaffStatus status;
}
