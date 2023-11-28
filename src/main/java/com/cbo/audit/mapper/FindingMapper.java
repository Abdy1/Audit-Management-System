package com.cbo.audit.mapper;

import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.FindingDTO;
import com.cbo.audit.persistence.model.AnnualPlan;
import com.cbo.audit.persistence.model.Finding;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
@Mapper(componentModel = "spring")
public interface FindingMapper {

    FindingMapper INSTANCE = Mappers.getMapper(FindingMapper.class);

    FindingDTO toDTO(Finding finding);

    void copyToDTO(Finding finding, @MappingTarget FindingDTO findingDTO);

    Finding toEntity(FindingDTO findingDTO);

    default List<FindingDTO> FindingToFindingDTOs(List<Finding> findings) {
        if (findings == null) {
            return null;
        }

        List<FindingDTO> list = new ArrayList<FindingDTO>(findings.size());
        for (Finding finding : findings) {
            list.add(toDTO(finding));
        }

        return list;
    }

}
