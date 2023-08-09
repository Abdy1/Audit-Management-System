package com.cbo.audit.persistence.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ams_team_member")
public class TeamMember extends BaseEntity{

    private String status;

    @ManyToOne
    @JoinColumn(name = "auditSchedule")
    private AuditSchedule auditSchedule;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

}
