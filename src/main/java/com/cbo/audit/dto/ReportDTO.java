package com.cbo.audit.dto;

import com.cbo.audit.enums.ReportStatus;
import com.cbo.audit.persistence.model.AuditProgramObjective;
import com.cbo.audit.persistence.model.AuditSchedule;
import com.cbo.audit.persistence.model.Finding;
import com.cbo.audit.persistence.model.TeamMember;

import java.time.LocalDate;
import java.util.List;

public class ReportDTO extends BaseDTO{

    private AuditSchedule auditSchedule;
    private String introduction;
    private LocalDate dateGenerated;
    private TeamMember generatedBy;
    private String sentTime;
    private String archiveTie;
    private String summary;
    private String scope;
    // find a way to store a list of objectives
    private List<AuditProgramObjective> objectives;
    private String methodology;
    // implement enum for report status
    private ReportStatus status;
    private double totalRectification;
    private List<Finding> findings;


}
