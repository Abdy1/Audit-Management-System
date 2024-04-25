package com.cbo.audit.mapper;


import com.cbo.audit.dto.AuditUniverseDTO;
import com.cbo.audit.persistence.model.AuditUniverse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AuditUniverseMapper {

    AuditUniverseMapper INSTANCE = Mappers.getMapper(AuditUniverseMapper.class);

    AuditUniverseDTO toDTO(AuditUniverse auditUniverse);

    void copyToDTO(AuditUniverse auditUniverse, @MappingTarget AuditUniverseDTO auditUniverseDTO);

    AuditUniverse toEntity(AuditUniverseDTO auditUniverseDTO);

    default List<AuditUniverseDTO> auditUniversesToAuditUniverseDTOs(List<AuditUniverse> auditUniverses) {
        if (auditUniverses == null) {
            return null;
        }

        List<AuditUniverseDTO> list = new ArrayList<AuditUniverseDTO>(auditUniverses.size());
        for (AuditUniverse auditUniverse : auditUniverses) {
            list.add(toDTO(auditUniverse));
        }

        return list;
    }
}
