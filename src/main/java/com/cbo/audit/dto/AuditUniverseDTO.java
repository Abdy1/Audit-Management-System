package com.cbo.audit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditUniverseDTO extends BaseDTO {

    private String name;

    private String status;

    private String approvedBy;

    private LocalDateTime approvedAt;
}
