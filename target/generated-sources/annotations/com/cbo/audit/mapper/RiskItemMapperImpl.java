package com.cbo.audit.mapper;

import com.cbo.audit.dto.RiskItemDTO;
import com.cbo.audit.persistence.model.RiskItem;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-09T09:41:01+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class RiskItemMapperImpl implements RiskItemMapper {

    @Override
    public RiskItemDTO toDTO(RiskItem riskItem) {
        if ( riskItem == null ) {
            return null;
        }

        RiskItemDTO riskItemDTO = new RiskItemDTO();

        riskItemDTO.setId( riskItem.getId() );
        riskItemDTO.setCreatedUser( riskItem.getCreatedUser() );
        riskItemDTO.setModifiedUser( riskItem.getModifiedUser() );
        riskItemDTO.setCreatedTimestamp( riskItem.getCreatedTimestamp() );
        riskItemDTO.setModifiedTimestamp( riskItem.getModifiedTimestamp() );
        riskItemDTO.setName( riskItem.getName() );
        riskItemDTO.setStrategicObjectiveLink( riskItem.getStrategicObjectiveLink() );
        riskItemDTO.setRiskType( riskItem.getRiskType() );

        return riskItemDTO;
    }

    @Override
    public void copyToDTO(RiskItem riskItem, RiskItemDTO riskItemDTO) {
        if ( riskItem == null ) {
            return;
        }

        riskItemDTO.setId( riskItem.getId() );
        riskItemDTO.setCreatedUser( riskItem.getCreatedUser() );
        riskItemDTO.setModifiedUser( riskItem.getModifiedUser() );
        riskItemDTO.setCreatedTimestamp( riskItem.getCreatedTimestamp() );
        riskItemDTO.setModifiedTimestamp( riskItem.getModifiedTimestamp() );
        riskItemDTO.setName( riskItem.getName() );
        riskItemDTO.setStrategicObjectiveLink( riskItem.getStrategicObjectiveLink() );
        riskItemDTO.setRiskType( riskItem.getRiskType() );
    }

    @Override
    public RiskItem toEntity(RiskItemDTO riskItemDTO) {
        if ( riskItemDTO == null ) {
            return null;
        }

        RiskItem riskItem = new RiskItem();

        riskItem.setId( riskItemDTO.getId() );
        riskItem.setCreatedUser( riskItemDTO.getCreatedUser() );
        riskItem.setModifiedUser( riskItemDTO.getModifiedUser() );
        riskItem.setCreatedTimestamp( riskItemDTO.getCreatedTimestamp() );
        riskItem.setModifiedTimestamp( riskItemDTO.getModifiedTimestamp() );
        riskItem.setName( riskItemDTO.getName() );
        riskItem.setStrategicObjectiveLink( riskItemDTO.getStrategicObjectiveLink() );
        riskItem.setRiskType( riskItemDTO.getRiskType() );

        return riskItem;
    }
}
