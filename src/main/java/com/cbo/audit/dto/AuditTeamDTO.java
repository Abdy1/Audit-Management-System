package com.cbo.audit.dto;

import com.cbo.audit.enums.AuditStaffStatus;
import lombok.Data;

@Data
public class AuditTeamDTO extends BaseDTO {

    private String userId;

    private String department;

    private String employeeId;

    private String fullName;

    private AuditStaffStatus status;
}
