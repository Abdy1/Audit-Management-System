package com.cbo.audit.service;

import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.BudgetYearDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.persistence.model.AnnualPlan;
import com.cbo.audit.persistence.model.AuditType;
import com.cbo.audit.persistence.model.BudgetYear;
import com.cbo.audit.persistence.model.RiskItem;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BudgetYearService {












    ResultWrapper <BudgetYear> newBudgetYear(String year);


    ResultWrapper<BudgetYear> getBudgetYear();


}
