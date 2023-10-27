package com.cbo.audit.persistence.model;

import com.cbo.audit.enums.AuditStaffStatus;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ams_audit_staff")
public class AuditStaff extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "AUDIT_TYPE_ID")
    private AuditType auditType;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private AuditStaffStatus status;
}
