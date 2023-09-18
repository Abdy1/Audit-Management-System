package com.cbo.audit.dto;

import com.cbo.audit.persistence.model.AuditObject;
import com.cbo.audit.persistence.model.AuditableArea;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChecklistItemDTO extends BaseDTO{
    private String name;

    private String description;

    private List<String> objective_list;

    private List<String> action_list;
    private AuditableAreaDTO auditableArea;
}
