package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.persistence.model.AuditSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring")
public interface AuditScheduleMapper {


    AuditScheduleMapper INSTANCE = Mappers.getMapper(AuditScheduleMapper.class);

    AuditScheduleDTO toDTO(AuditSchedule auditSchedule);

    void copyToDTO(AuditSchedule auditSchedule, @MappingTarget AuditScheduleDTO auditScheduleDTO);

    AuditSchedule toEntity(AuditScheduleDTO auditScheduleDTO);

    default List<AuditScheduleDTO> auditSchedulesToAuditScheduleDTOs(List<AuditSchedule> auditSchedules) {
        if (auditSchedules == null) {
            return null;
        }

        List<AuditScheduleDTO> list = new ArrayList<AuditScheduleDTO>(auditSchedules.size());
        for (AuditSchedule auditSchedule : auditSchedules) {
            list.add(toDTO(auditSchedule));
        }

        return list;
    }
}