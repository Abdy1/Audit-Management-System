package com.cbo.audit.mapper;

import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.persistence.model.AnnualPlan;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AnnualPlanMapper {

    AnnualPlanMapper INSTANCE = Mappers.getMapper(AnnualPlanMapper.class);

    AnnualPlanDTO toDTO(AnnualPlan annualPlan);

    void copyToDTO(AnnualPlan annualPlan, @MappingTarget AnnualPlanDTO annualPlanDTO);

    AnnualPlan toEntity(AnnualPlanDTO annualPlanDTO);

    default List<AnnualPlanDTO> annualPlansToAnnualPlanDTOs(List<AnnualPlan> annualPlans) {
        if (annualPlans == null) {
            return null;
        }

        List<AnnualPlanDTO> list = new ArrayList<AnnualPlanDTO>(annualPlans.size());
        for (AnnualPlan annualPlan : annualPlans) {
            list.add(toDTO(annualPlan));
        }

        return list;
    }
}