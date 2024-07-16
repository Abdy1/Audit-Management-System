package com.cbo.audit.service;

import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.AuditTypeDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.RiskItemDTO;
import com.cbo.audit.persistence.model.AnnualPlan;
import com.cbo.audit.persistence.model.AuditType;
import com.cbo.audit.persistence.model.RiskItem;

import java.util.List;

public interface AnnualPlanService {

    ResultWrapper<AnnualPlanDTO> registerAnnualPlan(AnnualPlanDTO auditUniverseDTO);

    ResultWrapper<List<AnnualPlanDTO>> getAllAnnualPlan();

    ResultWrapper<AnnualPlanDTO> getAnnualPlanById(Long id);

    AnnualPlan findAnnualPlanById(Long id);

    ResultWrapper<List<AnnualPlanDTO>> getAnnualPlanByYear(String year);

    ResultWrapper<AnnualPlanDTO> updateAnnualPlan(AnnualPlanDTO auditUniverseDTO);


    ResultWrapper<List<AnnualPlanDTO>> getAnnualPlanByAuditObjectId(Long id);

    ResultWrapper<AnnualPlanDTO> addAnnualPlanToSchedule(AnnualPlanDTO annualPlanDTO);

    ResultWrapper<List<AnnualPlanDTO>> getPlannedAnnualPlans();

    // to do
    ResultWrapper<List<AnnualPlanDTO>> getPlannedAnnualPlansByYear(String date);

    ResultWrapper<List<AnnualPlanDTO>> autoGenerateAnnualPlans(String year);
    public void recalculateRisks(RiskItem riskItem);
    void updateLevel(AuditType auditType);


    ResultWrapper<AnnualPlanDTO> approveAnnualPlan(Long id);

}
