package com.cbo.audit.mapper;

import com.cbo.audit.dto.CutOffDTO;
import com.cbo.audit.persistence.model.CutOff;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CutOffMapper {
    CutOffMapper INSTANCE = Mappers.getMapper(CutOffMapper.class);

    CutOffDTO toDTO(CutOff cutOff);

    CutOff toEntity(CutOffDTO cutOffDTO);

    List<CutOffDTO> cutOffsToCutOffDTOs(List<CutOff> cutOffs);

    @Mapping(target = "id", ignore = true) // If ID is not updated
    @Mapping(target = "createdTimestamp", ignore = true)
    void updateEntityFromDTO(CutOffDTO cutOffDTO, @MappingTarget CutOff cutOff);
}

