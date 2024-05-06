package com.cbo.audit.persistence.model;

import com.cbo.audit.enums.AuditStaffStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditTeam {

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "DEPARTMENT")
    private String department;

    @Column(name = "EMPLOYEE_ID")
    private String employeeId;

    @Column(name = "EMPLOYEE_NAME")
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private AuditStaffStatus status;
}
