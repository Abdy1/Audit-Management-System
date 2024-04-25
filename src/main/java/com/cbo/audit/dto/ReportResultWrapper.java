package com.cbo.audit.dto;

import lombok.Data;

@Data

public class ReportResultWrapper {


    AuditProgramDTO auditProgram;
    private String scope;
    private String methodology;
    private String summary;
}
