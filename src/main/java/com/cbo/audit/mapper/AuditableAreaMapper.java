package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditableAreaDTO;
import com.cbo.audit.persistence.model.AuditableArea;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;



@Mapper(componentModel = "spring")
public interface AuditableAreaMapper {

    AuditableAreaMapper INSTANCE = Mappers.getMapper(AuditableAreaMapper.class);

    AuditableAreaDTO toDTO(AuditableArea auditableArea);

    void copyToDTO(AuditableArea auditableArea, @MappingTarget AuditableAreaDTO auditableAreaDTO);

    AuditableArea toEntity(AuditableAreaDTO auditableAreaDTO);

    default List<AuditableAreaDTO> auditableAreasToAuditableAreaDTOs(List<AuditableArea> auditableAreas) {
        if (auditableAreas == null) {
            return null;
        }

        List<AuditableAreaDTO> list = new ArrayList<AuditableAreaDTO>(auditableAreas.size());
        for (AuditableArea auditableArea : auditableAreas) {
            list.add(toDTO(auditableArea));
        }

        return list;
    }
}