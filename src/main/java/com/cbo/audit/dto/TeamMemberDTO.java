package com.cbo.audit.dto;


import com.cbo.audit.enums.TeamMemberStatus;
import com.cbo.audit.enums.TeamType;
import com.cbo.audit.persistence.model.TeamMember;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamMemberDTO extends BaseDTO{

    private String status;


    private Long auditScheduleId;

    private UserDTO user;

    private TeamMemberStatus teamMemberStatus;

    private TeamType teamType;

    private String auditStatus;

    private int perdium;

}
