package com.cbo.audit.service;

import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.ReportTemplateDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.persistence.model.AnnualPlan;
import com.cbo.audit.persistence.model.AuditType;
import com.cbo.audit.persistence.model.RiskItem;

import java.util.List;

public interface ReportTemplateService {


    ResultWrapper<List<ReportTemplateDTO>> getReportTemplate();
}
