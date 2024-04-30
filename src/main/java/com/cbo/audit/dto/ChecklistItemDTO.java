package com.cbo.audit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChecklistItemDTO extends BaseDTO {
    private String name;

    private String description;

    private List<String> objective_list;

    private List<String> action_list;
    private AuditableAreaDTO auditableArea;
}
