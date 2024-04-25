package com.cbo.audit.dto;


import com.cbo.audit.enums.TeamMemberStatus;
import com.cbo.audit.enums.TeamType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamMemberDTO extends BaseDTO {

    private TeamMemberStatus status;

    private Long auditScheduleId;

    private AuditStaffDTO auditStaffDTO;

    private TeamType teamRole;

    private String auditStatus;

    private int perdium;

}
