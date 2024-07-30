package com.cbo.audit.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Finding extends BaseEntity {

    //what are longer text in the class recommendations , justification,implemented control , impact etc
    @ManyToOne
    @JoinColumn(name = "Audit_Program_Id")
    private AuditProgram auditProgram; // what if we attached it to audit program
    @Column(columnDefinition = "TEXT")
    private String finding;
    @Column(columnDefinition = "TEXT")
    private String criteria; //preset or post set
    private AuditableArea area; //selectable from Auditable area
    @Column(columnDefinition = "TEXT")
    private String cause;
    @Column(columnDefinition = "TEXT")
    private String implementedControls; // what are implemented control meaning preset or post set by auditors
    @Column(columnDefinition = "TEXT")
    private String impact;
    @Column(columnDefinition = "TEXT")
    private String recommendations;


    @Column(columnDefinition = "TEXT")
    private String auditeesResponse; //after finding approved and set visible
    @Column(columnDefinition = "TEXT")
    private String justifications;
    private Boolean isVisibleToAuditees;
    @ManyToOne
    private AuditStaff registeredBy;
    @ManyToOne
    private AuditStaff approvedBY;
    // private Registered Time baseentity
    private LocalDateTime responseTime;
//19.Responsible units[list] further clarification

    private Boolean rectificationStatus;
    private String rectificationProgress; //how to set rectificationprogrss meaning is it string or number
    private String rectificationEvidenceAttachmentPath; //is it file path
    private LocalDateTime rectificationTime;
    private Boolean isRectificationApproved; //who can approve ?
//private Comments[list] separate class or table more than one comment for per findings?

    private String findingEvidenceFileUploadedToSupplementTheFindingsPath; // file path


}
