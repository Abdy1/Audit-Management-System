package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditObjectDTO;
import com.cbo.audit.persistence.model.AuditObject;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AuditObjectMapper {

    AuditObjectMapper INSTANCE = Mappers.getMapper(AuditObjectMapper.class);

    AuditObjectDTO toDTO(AuditObject auditObject);

    void copyToDTO(AuditObject auditObject, @MappingTarget AuditObjectDTO auditObjectDTO);

    AuditObject toEntity(AuditObjectDTO auditObjectDTO);

    default List<AuditObjectDTO> auditObjectsToAuditObjectDTOs(List<AuditObject> auditObjects) {
        if (auditObjects == null) {
            return null;
        }

        List<AuditObjectDTO> list = new ArrayList<AuditObjectDTO>(auditObjects.size());
        for (AuditObject auditObject : auditObjects) {
            list.add(toDTO(auditObject));
        }

        return list;
    }
}