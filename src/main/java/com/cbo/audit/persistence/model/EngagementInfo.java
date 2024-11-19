package com.cbo.audit.persistence.model;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;@Data
@Entity
@Table(name = "ams_engagement_info")
public class EngagementInfo extends BaseEntity {

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

    // This will persist a foreign key reference in the "ams_auditee_list" table
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "AUDIT_ENGAGEMENT_ID")  // Foreign key in Auditees
    private List<Auditees> auditees;
}
