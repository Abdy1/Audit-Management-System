package com.cbo.audit.persistence.model;

import lombok.Data;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ams_engagement_info")
public class EngagementInfo extends BaseEntity{

    @Column(name = "MESSAGE")
    private String message;

    @ManyToOne
    @JoinColumn(name = "AUDIT_SCHEDULE_ID")
    private AuditSchedule auditSchedule;

    private String status;

    @Column(name = "REF_NUM")
    private String refNum;

    @Column(name = "DATE")
    private String date;
}
