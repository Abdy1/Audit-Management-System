package com.cbo.audit.persistence.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "ams_audit_type")
<<<<<<< HEAD
public class AuditType extends BaseEntity{
=======
public class AuditType {
>>>>>>> 9e70c2a663e0b9b573744f1ecc71c048b0289c92

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;
}
