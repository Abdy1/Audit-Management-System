package com.cbo.audit.persistence.model;

import com.cbo.audit.enums.AuditEngagementStatus;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class AuditEngagement extends BaseEntity{

    @Column(name = "SCHEDULE_ID")
    private Long auditScheduleId;


    @Column(name = "STATUS")
    private AuditEngagementStatus status;

}
