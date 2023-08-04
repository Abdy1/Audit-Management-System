package com.cbo.audit.service;

import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.persistence.model.AnnualPlan;

import java.util.List;

public interface AnnualPlanService {

    ResultWrapper<AnnualPlanDTO> registerAnnualPlan(AnnualPlanDTO auditUniverseDTO);

    ResultWrapper<List<AnnualPlanDTO>> getAllAnnualPlan();

    ResultWrapper<AnnualPlanDTO> getAnnualPlanById(Long id);

    AnnualPlan findAnnualPlanById(Long id);

    ResultWrapper<List<AnnualPlanDTO>> getAnnualPlanByYear(String year);

    ResultWrapper<AnnualPlanDTO> updateAnnualPlan(AnnualPlanDTO auditUniverseDTO);

    ResultWrapper<List<AnnualPlanDTO>> getAnnualPlanByAuditUniverseId(Long id);
}
