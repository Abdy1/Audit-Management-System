package com.cbo.audit.dto;

import com.cbo.audit.dto.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutoGenerateAnnualPlanDTO extends BaseDTO {
    private String budgetYear;

}
