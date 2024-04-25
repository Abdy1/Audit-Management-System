package com.cbo.audit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)

public class AuditProgramWBSDTO extends BaseDTO {


    private String name;

    //for discussion

    private String description;


    private AuditProgramDTO auditProgram;


    private String status;


    private String startOn;


    private String endOn;


    private int numberOfDays;


}
