package com.cbo.audit.persistence.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ams_audit_program")
@Setter
@Getter
public class AuditProgram extends BaseEntity{

    private String name;

    @Getter

    private String status;
    //for discussion
    @Column(columnDefinition = "text")
    private String previousStatus;
    @Column(columnDefinition = "text")
    private String methodology;
    @Column(columnDefinition = "text")
    private String previousDescription;
    @Column
    @OneToMany
    private List<AuditProgramObjective>  objectives;
    @Column(columnDefinition = "text")
    private String scopeDescription;
    @Column
    private String OverAllTime;
    @OneToOne
    @JoinColumn(name = "ENGAGEMENT_ID")
    private EngagementInfo engagementInfo;

}
