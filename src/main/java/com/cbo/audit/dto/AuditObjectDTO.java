package com.cbo.audit.dto;


import com.cbo.audit.persistence.model.AuditType;
import com.cbo.audit.persistence.model.AuditUniverse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditObjectDTO extends BaseDTO {

    private String name;

    private String description;

    private AuditTypeDTO auditType;//it,ifb,invstri,heado

    private String status;

    private AuditUniverse auditUniverse;

}
