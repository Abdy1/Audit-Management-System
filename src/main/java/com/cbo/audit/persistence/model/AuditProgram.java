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
    @Column
    private String name;

    @Getter
    @Column
    private String status;
    //for discussion
    @Column
    private String previousStatus;
    @Column
    private String methodology;
    @Column
    private String previousDescription;
    @Column
    private String  objectives;
    @Column
    private String scopeDescription;
    @Column
    private String OverAllTime;
    @ManyToOne
    @JoinColumn(name = "ENGAGEMENT_ID")
    private EngagementInfo engagementInfo;

}
