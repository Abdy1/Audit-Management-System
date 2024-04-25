package com.cbo.audit.persistence.model;

import com.cbo.audit.enums.ResourceStatus;
import com.cbo.audit.enums.ResourceType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "ams_resource")
public class Resource extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = " RESOURCE_TYPE")
    private ResourceType resourceType;

    @Column(name = "RESOURCE_STATUS")
    private ResourceStatus resourceStatus;

    @ManyToOne
    @JoinColumn(name = "SCHEDULE_ID")
    private AuditSchedule auditSchedule;
}
