package com.cbo.audit.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class FindingComment extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "Finding_Id")
    private Finding finding;
    @Column(columnDefinition = "TEXT")
    private String originalfinding;
    @Column(columnDefinition = "TEXT")
    private String comment;//long text
    @ManyToOne
    private AuditStaff providedBy;

    private Boolean Status;
}
