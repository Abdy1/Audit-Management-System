package com.cbo.audit.persistence.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class AuditEngagement extends BaseEntity{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SCHEDULE_ID")
    private AuditSchedule auditSchedule;

    @Column(name = "STATUS")
    private String status;

}
