package com.cbo.audit.dto;

import com.cbo.audit.persistence.model.AuditProgram;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)

public class AuditProgramWBSDTO extends BaseDTO{


    private String name;

    //for discussion

    private String description;


    private AuditProgramDTO auditProgram;


    private String status;


    private String startOn;


    private String endOn;


    private int numberOfDays;



}
