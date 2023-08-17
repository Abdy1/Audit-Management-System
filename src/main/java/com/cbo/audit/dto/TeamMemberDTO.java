package com.cbo.audit.dto;


import com.cbo.audit.enums.TeamMemberStatus;
import com.cbo.audit.enums.TeamType;
import com.cbo.audit.persistence.model.TeamMember;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamMemberDTO extends BaseDTO{

    private UserDTO user;

    private AuditScheduleDTO auditSchedule;

    private TeamMemberStatus teamMemberStatus;

    private TeamType teamType;

}
