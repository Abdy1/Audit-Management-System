package com.cbo.audit.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "ams_risk_level")
public class RiskLevel extends BaseEntity {

    @Column(name = "HIGH")
    private int high;

    @Column(name = "MEDIUM")
    private int medium;

    @Column(name = "LOW")
    private int low;

    @OneToOne
    private AuditType auditType;
}
