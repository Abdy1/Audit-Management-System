package com.cbo.audit.dto;

import com.cbo.audit.persistence.model.AuditSchedule;
import com.cbo.audit.persistence.model.AuditStaff;
import com.cbo.audit.persistence.model.AuditableArea;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FindingDTO extends  BaseDTO {

    private AuditProgramDTO auditProgram;
    private String finding;

    private String criteria;
    private AuditableAreaDTO area;

    private String cause;

    private String implementedControls;

    private String impact;

    private String recommendations;

    private String auditees ;

    private String auditeesResponse;

    private String justifications;

    private Boolean isVisibleToAuditees;

    private AuditStaffDTO registeredBy;

    private AuditStaffDTO approvedBY;

    private LocalDateTime responseTime;

    private Boolean rectificationStatus ;
    private String rectificationProgress;
    private String rectificationEvidenceAttachmentPath; //is it file path
    private LocalDateTime rectificationTime;
    private Boolean isRectificationApproved;
    private String findingEvidenceFileUploadedToSupplementTheFindings; // file path


}
