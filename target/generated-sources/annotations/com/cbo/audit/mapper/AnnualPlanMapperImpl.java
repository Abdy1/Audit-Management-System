package com.cbo.audit.mapper;

import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.persistence.model.AnnualPlan;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T13:54:46+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class AnnualPlanMapperImpl implements AnnualPlanMapper {

    @Override
    public AnnualPlanDTO toDTO(AnnualPlan annualPlan) {
        if ( annualPlan == null ) {
            return null;
        }

        AnnualPlanDTO annualPlanDTO = new AnnualPlanDTO();

        return annualPlanDTO;
    }

    @Override
    public void copyToDTO(AnnualPlan annualPlan, AnnualPlanDTO annualPlanDTO) {
        if ( annualPlan == null ) {
            return;
        }
    }

    @Override
    public AnnualPlan toEntity(AnnualPlanDTO annualPlanDTO) {
        if ( annualPlanDTO == null ) {
            return null;
        }

        AnnualPlan annualPlan = new AnnualPlan();

        return annualPlan;
    }
}
