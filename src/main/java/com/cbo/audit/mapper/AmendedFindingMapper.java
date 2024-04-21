package com.cbo.audit.mapper;

import com.cbo.audit.dto.AmendedFindingDTO;
import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.persistence.model.AmendedFinding;
import com.cbo.audit.persistence.model.AnnualPlan;
import com.cbo.audit.persistence.model.AuditStaff;
import com.cbo.audit.persistence.model.FindingComment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
