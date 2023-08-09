package com.cbo.audit.persistence.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class AuditEngagement extends BaseEntity{


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private AuditSchedule auditSchedule;

}
