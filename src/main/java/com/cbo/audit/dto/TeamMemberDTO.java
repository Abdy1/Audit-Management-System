package com.cbo.audit.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamMemberDTO extends BaseDTO{


    private String status;

    private AuditScheduleDTO auditSchedule;


    private UserDTO user;
}
