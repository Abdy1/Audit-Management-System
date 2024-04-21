package com.cbo.audit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import java.time.LocalDateTime;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditUniverseDTO extends BaseDTO{

    private String name;

    private String auditType;

    private String status;

    private String approvedBy;

    private LocalDateTime approvedAt;

    private AuditObjectDTO auditObject;
}
