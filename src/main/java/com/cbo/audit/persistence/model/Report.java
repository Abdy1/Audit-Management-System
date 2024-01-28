package com.cbo.audit.persistence.model;

import com.cbo.audit.enums.ReportStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@Entity
public class Report extends BaseEntity{
    @OneToOne
    private AuditSchedule auditSchedule;
    private String introduction;
    private LocalDate dateGenerated;
    @ManyToOne
    private TeamMember generatedBy;
    private String sentTime;
    private String archiveTie;
    private String summary;
    private String scope;
    // find a way to store a list of objectives
    @OneToMany
    private List<AuditProgramObjective> objectives;
    private String methodology;
    // implement enum for report status
    private ReportStatus status;
    private double totalRectification;
    @OneToMany
    private List<Finding> findings;

}
