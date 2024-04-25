package com.cbo.audit.mapper;

import com.cbo.audit.dto.AmendedFindingDTO;
import com.cbo.audit.persistence.model.AmendedFinding;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface AmendedFindingMapper {

    AmendedFindingMapper INSTANCE = Mappers.getMapper(AmendedFindingMapper.class);

    AmendedFindingDTO toDTO(AmendedFinding amendedFinding);

    void copyToDTO(AmendedFinding amendedFinding, @MappingTarget AmendedFindingDTO amendedFindingDTO);

    AmendedFinding toEntity(AmendedFindingDTO amendedFindingDTO);

    default List<AmendedFindingDTO> AmendedFindingToAmendedFindingDTOs(List<AmendedFinding> amendedFindings) {
        if (amendedFindings == null) {
            return null;
        }

        List<AmendedFindingDTO> list = new ArrayList<AmendedFindingDTO>(amendedFindings.size());
        for (AmendedFinding amendedFinding : amendedFindings) {
            list.add(toDTO(amendedFinding));
        }

        return list;
    }
}
