package com.cbo.audit.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RiskLevelDTO extends BaseDTO{

    private int high;

    private int medium;

    private int low;
}
