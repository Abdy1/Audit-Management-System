package com.cbo.audit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnnualPlanDTO extends BaseDTO {

    private String name;

    private String description;

    private String year;

    private String riskLevel;

    private int riskScore;

    private String status;

    private double rectificationStatus;

    private AuditUniverseDTO auditUniverse;

    private AuditObjectDTO auditObject;

    private List<RiskScoreDTO> riskScores;
}
