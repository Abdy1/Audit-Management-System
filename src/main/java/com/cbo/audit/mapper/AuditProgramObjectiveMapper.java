package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditProgramObjectiveDTO;
import com.cbo.audit.persistence.model.AuditProgramObjective;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AuditProgramObjectiveMapper {


    AuditProgramObjectiveMapper INSTANCE = Mappers.getMapper(AuditProgramObjectiveMapper.class);

    AuditProgramObjectiveDTO toDTO(AuditProgramObjective auditProgramObjective);

    void copyToDTO(AuditProgramObjective auditProgramObjective, @MappingTarget AuditProgramObjectiveDTO auditProgramObjectiveDTO);

    AuditProgramObjective toEntity(AuditProgramObjectiveDTO auditProgramObjectiveDTO);

    default List<AuditProgramObjectiveDTO> auditProgramObjectiveToAuditProgramObjectiveDTOs(List<AuditProgramObjective> auditProgramObjectives) {
        if (auditProgramObjectives == null) {
            return null;
        }

        List<AuditProgramObjectiveDTO> list = new ArrayList<AuditProgramObjectiveDTO>(auditProgramObjectives.size());
        for (AuditProgramObjective auditProgramObjective : auditProgramObjectives) {
            list.add(toDTO(auditProgramObjective));
        }

        return list;
    }
}