package com.cbo.audit.mapper;

import com.cbo.audit.dto.RiskScoreDTO;
import com.cbo.audit.persistence.model.RiskScore;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring")
public interface RiskScoreMapper {
    RiskScoreMapper INSTANCE = Mappers.getMapper(RiskScoreMapper.class);

    RiskScoreDTO toDTO(RiskScore riskScore);

    void copyToDTO(RiskScore riskScore, @MappingTarget RiskScoreDTO riskScoreDTO);

    RiskScore toEntity(RiskScoreDTO riskScoreDTO);

    default List<RiskScoreDTO> riskScoresToRiskScoreDTOs(List<RiskScore> riskScores) {
        if (riskScores == null) {
            return null;
        }

        List<RiskScoreDTO> list = new ArrayList<RiskScoreDTO>(riskScores.size());
        for (RiskScore riskScore : riskScores) {
            list.add(toDTO(riskScore));
        }

        return list;
    }
}
