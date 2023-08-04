package com.cbo.audit.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditObjectDTO extends BaseDTO{

    private String name;

    private String description;

    private String auditType;//it,ifb,invstri,heado

    private AuditUniverseDTO auditUniverse;
}
