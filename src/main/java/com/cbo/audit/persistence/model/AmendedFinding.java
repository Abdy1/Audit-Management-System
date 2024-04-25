package com.cbo.audit.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "amended_finding")
public class AmendedFinding extends BaseEntity {
    @ManyToOne
    private Finding finding;
    @Column(columnDefinition = "TEXT")
    private String findingBeforeAmendment;
    @ManyToOne
    private AuditStaff amendedBy;
}
