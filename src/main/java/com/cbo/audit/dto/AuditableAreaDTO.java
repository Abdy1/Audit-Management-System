package com.cbo.audit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditableAreaDTO extends BaseDTO {

    private String name;

    private String description;

    private AuditObjectDTO auditObject;
}
