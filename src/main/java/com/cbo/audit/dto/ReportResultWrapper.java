package com.cbo.audit.dto;

import com.cbo.audit.persistence.model.AuditProgram;
import com.cbo.audit.persistence.model.AuditSchedule;
import com.cbo.audit.persistence.model.EngagementInfo;
import lombok.Data;

import javax.persistence.Entity;
import java.util.List;
@Data

public class ReportResultWrapper {


    AuditProgramDTO auditProgram;
    private String scope;
    private String methodology;
    private String summary;
}
