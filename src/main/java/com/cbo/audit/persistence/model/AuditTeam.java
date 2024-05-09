package com.cbo.audit.persistence.model;

import com.cbo.audit.enums.AuditStaffStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class AuditTeam extends BaseEntity{

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
