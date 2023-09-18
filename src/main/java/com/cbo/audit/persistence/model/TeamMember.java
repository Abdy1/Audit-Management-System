package com.cbo.audit.persistence.model;


import com.cbo.audit.enums.TeamMemberStatus;
import com.cbo.audit.enums.TeamType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ams_team_member")
public class TeamMember extends BaseEntity{

    @Column(name = "STATUS")
    private TeamMemberStatus status;

    @Column(name = " TEAM_TYPE")
    private TeamType teamType;

    @Column(name = "AUDIT_STATUS")
    private String auditStatus;

    @Column(name = "PERDIUM")
    private int perdium;

    @ManyToOne
    @JoinColumn(name = "auditSchedule")
    private AuditSchedule auditSchedule;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
