package com.cbo.audit.mapper;

import com.cbo.audit.dto.RiskItemDTO;
import com.cbo.audit.persistence.model.RiskItem;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T13:54:45+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class RiskItemMapperImpl implements RiskItemMapper {

    @Override
    public RiskItemDTO toDTO(RiskItem riskItem) {
        if ( riskItem == null ) {
            return null;
        }

        RiskItemDTO riskItemDTO = new RiskItemDTO();

        return riskItemDTO;
    }

    @Override
    public void copyToDTO(RiskItem riskItem, RiskItemDTO riskItemDTO) {
        if ( riskItem == null ) {
            return;
        }
    }

    @Override
    public RiskItem toEntity(RiskItemDTO riskItemDTO) {
        if ( riskItemDTO == null ) {
            return null;
        }

        RiskItem riskItem = new RiskItem();

        return riskItem;
    }
}
