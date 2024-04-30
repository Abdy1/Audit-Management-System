package com.cbo.audit.dto;

import com.cbo.audit.enums.ResourceStatus;
import com.cbo.audit.enums.ResourceType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceDTO extends BaseDTO {

    private String name;

    private int quantity;

    private ResourceType resourceType;

    private ResourceStatus resourceStatus;

    private AuditScheduleDTO auditSchedule;
}
