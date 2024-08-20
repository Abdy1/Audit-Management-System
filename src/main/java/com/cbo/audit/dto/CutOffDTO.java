package com.cbo.audit.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CutOffDTO {

    private Long id;
    private int cutOff;
    private String createdBy;
    private String modifiedBy;

    // Optionally, add timestamps if needed
    private String createdTimestamp;
    private String modifiedTimestamp;
}

