package com.cbo.audit.persistence.model;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

public class WBS extends BaseEntity{

    @Column
    private String name;

    @ManyToOne
    private AuditProgram auditProgram;

    @Column
    private String status;

    @Column
    private String startOn;

    @Column
    private String endOn;

    @Column
    private int numberOfDays;

}
