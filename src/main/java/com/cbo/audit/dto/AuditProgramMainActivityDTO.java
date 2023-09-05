package com.cbo.audit.dto;

import com.cbo.audit.persistence.model.AuditProgram;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditProgramMainActivityDTO extends BaseDTO{

    private String name;

    private String startOn;

    private String endOn;

    private String days;

    private AuditProgramDTO auditProgram;
}
