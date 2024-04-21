package com.cbo.audit.mapper;


import com.cbo.audit.dto.AuditTypeDTO;
import com.cbo.audit.persistence.model.AuditType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AuditTypeMapper {

    AuditTypeMapper INSTANCE = Mappers.getMapper(AuditTypeMapper.class);

    AuditTypeDTO toDTO(AuditType auditType);

    void copyToDTO(AuditType auditType, @MappingTarget AuditTypeDTO auditTypeDTO);

    AuditType toEntity(AuditTypeDTO auditTypeDTO);

    default List<AuditTypeDTO> auditTypesToAuditTypeDTOs(List<AuditType> auditTypes) {
        if (auditTypes == null) {
            return null;
        }

        List<AuditTypeDTO> list = new ArrayList<AuditTypeDTO>(auditTypes.size());
        for (AuditType auditType : auditTypes) {
            list.add(toDTO(auditType));
        }

        return list;
    }
}
