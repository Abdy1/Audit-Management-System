package com.cbo.audit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AmendedFindingDTO extends BaseDTO {

    private FindingCommentDTO comment;

    private String findingBeforeAmendment;
    private AuditStaffDTO amendedBy;
}
