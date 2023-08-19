package com.cbo.audit.persistence.model;


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
    private String status;

    @Column(name = " TEAM_TYPE")
    private TeamType teamType;

    @ManyToOne
    @JoinColumn(name = "auditSchedule")
    private AuditSchedule auditSchedule;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
