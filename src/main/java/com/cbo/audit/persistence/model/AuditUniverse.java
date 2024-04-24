package com.cbo.audit.persistence.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ams_audit_universe")
public class AuditUniverse  extends BaseEntity{


    @Column(name = "NAME")
    private String name;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "APPROVED_BY")
    private String approvedBy;

    @UpdateTimestamp
    @Column(name = "APPROVED_AT")
    private LocalDateTime approvedAt;
}
