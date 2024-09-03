package com.cbo.audit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FindingDTO extends BaseDTO {

    private AuditProgramDTO auditProgram;
    private String finding;

    private String criteria;
    private AuditableAreaDTO area;

    private String cause;

    private String implementedControls;

    private String impact;

    private String recommendations;

    private String status;

    private String auditeesResponse;

    private String justifications;

    private Boolean isVisibleToAuditees;

    private AuditStaffDTO registeredBy;

    private AuditStaffDTO approvedBY;

    private LocalDateTime responseTime;

    private Boolean rectificationStatus;
    private String rectificationProgress;
    private String rectificationEvidenceAttachmentPath;
    private LocalDateTime rectificationTime;
    private Boolean isRectificationApproved;
    private String findingEvidenceFileUploadedToSupplementTheFindingsPath;


}
