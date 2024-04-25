package com.cbo.audit.dto;

import com.cbo.audit.persistence.model.AuditStaff;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)

public class FindingCommentDTO extends BaseDTO {

    private FindingDTO finding;

    private String originalfinding;

    private String comment;

    private AuditStaff providedBy;

    private Boolean Status;
}
