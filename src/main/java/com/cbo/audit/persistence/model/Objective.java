package com.cbo.audit.persistence.model;

import javax.persistence.ManyToOne;

public class Objective extends BaseEntity{

    @ManyToOne
    private AuditProgram auditProgram;

}
