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

    ResultWrapper<AnnualPlanDTO> addAnnualPlanToSchedule(AnnualPlanDTO annualPlanDTO);

    ResultWrapper<List<AnnualPlanDTO>> getPlannedAnnualPlans();

<<<<<<< HEAD
=======
    ResultWrapper<List<AnnualPlanDTO>> autoGenerateAnnualPlans(String year);

>>>>>>> 9e70c2a663e0b9b573744f1ecc71c048b0289c92
}
