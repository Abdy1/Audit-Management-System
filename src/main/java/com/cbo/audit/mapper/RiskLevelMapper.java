package com.cbo.audit.mapper;

import com.cbo.audit.dto.RiskLevelDTO;
import com.cbo.audit.persistence.model.RiskLevel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface RiskLevelMapper {

    RiskLevelMapper INSTANCE = Mappers.getMapper(RiskLevelMapper.class);

    RiskLevelDTO toDTO(RiskLevel riskLevel);

    void copyToDTO(RiskLevel riskLevel, @MappingTarget RiskLevelDTO riskLevelDTO);

    RiskLevel toEntity(RiskLevelDTO riskLevelDTO);

    default List<RiskLevelDTO> riskLevelsToRiskLevelDTOs(List<RiskLevel> riskLevels) {
        if (riskLevels == null) {
            return null;
        }

        List<RiskLevelDTO> list = new ArrayList<RiskLevelDTO>(riskLevels.size());
        for (RiskLevel riskLevel : riskLevels) {
            list.add(toDTO(riskLevel));
        }

        return list;
    }
}
