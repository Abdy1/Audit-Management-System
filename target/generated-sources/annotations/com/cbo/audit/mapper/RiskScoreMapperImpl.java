package com.cbo.audit.mapper;

import com.cbo.audit.dto.RiskItemDTO;
import com.cbo.audit.dto.RiskScoreDTO;
import com.cbo.audit.persistence.model.RiskItem;
import com.cbo.audit.persistence.model.RiskScore;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-22T08:12:49+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class RiskScoreMapperImpl implements RiskScoreMapper {

    @Override
    public RiskScoreDTO toDTO(RiskScore riskScore) {
        if ( riskScore == null ) {
            return null;
        }

        RiskScoreDTO riskScoreDTO = new RiskScoreDTO();

        riskScoreDTO.setId( riskScore.getId() );
        riskScoreDTO.setCreatedUser( riskScore.getCreatedUser() );
        riskScoreDTO.setModifiedUser( riskScore.getModifiedUser() );
        riskScoreDTO.setCreatedTimestamp( riskScore.getCreatedTimestamp() );
        riskScoreDTO.setModifiedTimestamp( riskScore.getModifiedTimestamp() );
        riskScoreDTO.setRiskItem( riskItemToRiskItemDTO( riskScore.getRiskItem() ) );
        riskScoreDTO.setLikelihood( riskScore.getLikelihood() );
        riskScoreDTO.setImpact( riskScore.getImpact() );
        riskScoreDTO.setTotal( riskScore.getTotal() );
        riskScoreDTO.setPercentage( riskScore.getPercentage() );
        riskScoreDTO.setWaited( riskScore.isWaited() );

        return riskScoreDTO;
    }

    @Override
    public void copyToDTO(RiskScore riskScore, RiskScoreDTO riskScoreDTO) {
        if ( riskScore == null ) {
            return;
        }

        riskScoreDTO.setId( riskScore.getId() );
        riskScoreDTO.setCreatedUser( riskScore.getCreatedUser() );
        riskScoreDTO.setModifiedUser( riskScore.getModifiedUser() );
        riskScoreDTO.setCreatedTimestamp( riskScore.getCreatedTimestamp() );
        riskScoreDTO.setModifiedTimestamp( riskScore.getModifiedTimestamp() );
        if ( riskScore.getRiskItem() != null ) {
            if ( riskScoreDTO.getRiskItem() == null ) {
                riskScoreDTO.setRiskItem( new RiskItemDTO() );
            }
            riskItemToRiskItemDTO1( riskScore.getRiskItem(), riskScoreDTO.getRiskItem() );
        }
        else {
            riskScoreDTO.setRiskItem( null );
        }
        riskScoreDTO.setLikelihood( riskScore.getLikelihood() );
        riskScoreDTO.setImpact( riskScore.getImpact() );
        riskScoreDTO.setTotal( riskScore.getTotal() );
        riskScoreDTO.setPercentage( riskScore.getPercentage() );
        riskScoreDTO.setWaited( riskScore.isWaited() );
    }

    @Override
    public RiskScore toEntity(RiskScoreDTO riskScoreDTO) {
        if ( riskScoreDTO == null ) {
            return null;
        }

        RiskScore riskScore = new RiskScore();

        riskScore.setId( riskScoreDTO.getId() );
        riskScore.setCreatedUser( riskScoreDTO.getCreatedUser() );
        riskScore.setModifiedUser( riskScoreDTO.getModifiedUser() );
        riskScore.setCreatedTimestamp( riskScoreDTO.getCreatedTimestamp() );
        riskScore.setModifiedTimestamp( riskScoreDTO.getModifiedTimestamp() );
        riskScore.setRiskItem( riskItemDTOToRiskItem( riskScoreDTO.getRiskItem() ) );
        riskScore.setLikelihood( riskScoreDTO.getLikelihood() );
        riskScore.setImpact( riskScoreDTO.getImpact() );
        riskScore.setPercentage( riskScoreDTO.getPercentage() );
        riskScore.setWaited( riskScoreDTO.isWaited() );
        riskScore.setTotal( riskScoreDTO.getTotal() );

        return riskScore;
    }

    protected RiskItemDTO riskItemToRiskItemDTO(RiskItem riskItem) {
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

    protected void riskItemToRiskItemDTO1(RiskItem riskItem, RiskItemDTO mappingTarget) {
        if ( riskItem == null ) {
            return;
        }

        mappingTarget.setId( riskItem.getId() );
        mappingTarget.setCreatedUser( riskItem.getCreatedUser() );
        mappingTarget.setModifiedUser( riskItem.getModifiedUser() );
        mappingTarget.setCreatedTimestamp( riskItem.getCreatedTimestamp() );
        mappingTarget.setModifiedTimestamp( riskItem.getModifiedTimestamp() );
        mappingTarget.setName( riskItem.getName() );
        mappingTarget.setStrategicObjectiveLink( riskItem.getStrategicObjectiveLink() );
        mappingTarget.setRiskType( riskItem.getRiskType() );
    }

    protected RiskItem riskItemDTOToRiskItem(RiskItemDTO riskItemDTO) {
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
