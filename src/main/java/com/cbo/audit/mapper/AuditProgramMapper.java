package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditProgramDTO;
import com.cbo.audit.persistence.model.AuditProgram;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AuditProgramMapper {

    AuditProgramMapper INSTANCE = Mappers.getMapper(AuditProgramMapper.class);

    AuditProgramDTO toDTO(AuditProgram auditProgram);

    void copyToDTO(AuditProgram auditProgram, @MappingTarget AuditProgramDTO auditProgramDTO);

    AuditProgram toEntity(AuditProgramDTO auditProgramDTO);

    default List<AuditProgramDTO> auditProgramsToAuditProgramDTOs(List<AuditProgram> auditPrograms) {
        if (auditPrograms == null) {
            return null;
        }

        List<AuditProgramDTO> list = new ArrayList<AuditProgramDTO>(auditPrograms.size());
        for (AuditProgram auditProgram : auditPrograms) {
            list.add(toDTO(auditProgram));
        }

        return list;
    }

}
