package com.cbo.audit.dto;


import com.cbo.audit.persistence.model.AuditType;
import com.cbo.audit.service.AuditUniverseService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskItemDTO extends BaseDTO {

    private String name;

    private int strategicObjectiveLink;

    private AuditType auditType;
}
