package com.cbo.audit.dto;

import com.cbo.audit.persistence.model.AuditObject;
import com.cbo.audit.persistence.model.AuditableArea;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChecklistItemDTO extends BaseDTO{
    private String name;

    private AuditableAreaDTO auditableArea;
}
