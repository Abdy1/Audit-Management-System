package com.cbo.audit.dto;

import com.cbo.audit.persistence.model.AuditStaff;
import com.cbo.audit.persistence.model.Finding;
import com.cbo.audit.persistence.model.FindingComment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)

public class FindingCommentDTO extends  BaseDTO{

    private FindingDTO finding;

    private String originalfinding ;

    private String comment ;

    private AuditStaff providedBy;

    private Boolean Satus;
}
