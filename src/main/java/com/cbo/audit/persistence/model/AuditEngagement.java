package com.cbo.audit.persistence.model;

import com.cbo.audit.enums.AuditEngagementStatus;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ams_audit_engagement")
public class AuditEngagement extends BaseEntity{

    @Column(name = "SCHEDULE_ID")
    private Long auditScheduleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private AuditEngagementStatus status;

    @Column(name = " YEAR")
    private String year;

}
