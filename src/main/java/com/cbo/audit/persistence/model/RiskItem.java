package com.cbo.audit.persistence.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ams_risk_item")
public class RiskItem extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "OBJECTIVE_LINK")
    private int strategicObjectiveLink;

    @ManyToOne
    @JoinColumn(name = "AUDIT_TYPE_ID")
    private AuditType auditType;
}
