package com.cbo.audit.mapper;

import com.cbo.audit.dto.RiskScoreDTO;
import com.cbo.audit.persistence.model.RiskScore;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T13:54:46+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class RiskScoreMapperImpl implements RiskScoreMapper {

    @Override
    public RiskScoreDTO toDTO(RiskScore riskScore) {
        if ( riskScore == null ) {
            return null;
        }

        RiskScoreDTO riskScoreDTO = new RiskScoreDTO();

        return riskScoreDTO;
    }

    @Override
    public void copyToDTO(RiskScore riskScore, RiskScoreDTO riskScoreDTO) {
        if ( riskScore == null ) {
            return;
        }
    }

    @Override
    public RiskScore toEntity(RiskScoreDTO riskScoreDTO) {
        if ( riskScoreDTO == null ) {
            return null;
        }

        RiskScore riskScore = new RiskScore();

        return riskScore;
    }
}
