package com.cbo.audit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditUniverseDTO extends BaseDTO{

    private String name;

    private String description;

    private String auditType;

    private String status;
}
