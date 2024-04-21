package com.cbo.audit.dto;

import com.cbo.audit.enums.ReportStatus;
import com.cbo.audit.persistence.model.AuditProgramObjective;
import com.cbo.audit.persistence.model.AuditSchedule;
import com.cbo.audit.persistence.model.Finding;
import com.cbo.audit.persistence.model.TeamMember;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportDTO extends BaseDTO{

    private AuditScheduleDTO auditSchedule;
    private String introduction;
    private LocalDate dateGenerated;
    private TeamMember generatedBy;
    private String sentTime;
    private String archiveTie;
    private String summary;
    private String scope;
    // find a way to store a list of objectives
    private List<AuditProgramObjectiveDTO> objectives;
    private String methodology;
    // implement enum for report status
    private ReportStatus status;
    private double totalRectification;
    private List<FindingDTO> findings;


    private EngagementDTO engagementInfo;
    private AuditProgramDTO auditProgram;



}
