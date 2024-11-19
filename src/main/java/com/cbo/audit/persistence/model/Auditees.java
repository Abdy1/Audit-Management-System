package com.cbo.audit.persistence.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ams_auditee_list")
public class Auditees extends BaseEntity {

    @Column(name = "FULL_NAME")
    private String fullName;


    @Column(name = "USER_ID")
    private String userId;



}
