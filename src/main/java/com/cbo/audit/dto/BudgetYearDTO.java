package com.cbo.audit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BudgetYearDTO extends BaseDTO {

    private String year;

    private LocalDate startDate;

    private LocalDate endDate;

    private boolean isCurrent;
}
