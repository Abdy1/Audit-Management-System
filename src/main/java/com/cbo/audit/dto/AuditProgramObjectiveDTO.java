package com.cbo.audit.dto;

import com.cbo.audit.persistence.model.AuditProgram;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)

public class AuditProgramObjectiveDTO extends BaseDTO{



    private String description;

    private AuditProgramDTO auditProgram;

}
