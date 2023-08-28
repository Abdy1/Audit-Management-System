package com.cbo.audit.dto;

import com.cbo.audit.persistence.model.AuditObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditableAreaDTO extends BaseDTO{

    private String name;

    private String description;

    private AuditObjectDTO auditObject;
}
