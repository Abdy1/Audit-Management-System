package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditProgramMainActivityDTO;
import com.cbo.audit.dto.AuditProgramObjectiveDTO;
import com.cbo.audit.persistence.model.AuditProgramMainActivity;
import com.cbo.audit.persistence.model.AuditProgramObjective;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
@Mapper(componentModel = "spring")
public interface AuditProgramMainActivityMapper {


    AuditProgramMainActivityMapper INSTANCE = Mappers.getMapper(AuditProgramMainActivityMapper.class);

    AuditProgramMainActivityDTO toDTO(AuditProgramMainActivity auditProgramMainActivity);

    void copyToDTO(AuditProgramMainActivity auditProgramMainActivity, @MappingTarget AuditProgramMainActivityDTO auditProgramMainActivityDTO);

    AuditProgramMainActivity toEntity(AuditProgramMainActivityDTO auditProgramMainActivityDTO);

    default List<AuditProgramMainActivityDTO>  auditProgramMainActivityToAuditProgramMainActivityDTOs(List<AuditProgramMainActivity> auditProgramMainActivities) {
        if (auditProgramMainActivities == null) {
            return null;
        }

        List<AuditProgramMainActivityDTO> list = new ArrayList<AuditProgramMainActivityDTO>(auditProgramMainActivities.size());
        for (AuditProgramMainActivity auditProgramMainActivity : auditProgramMainActivities) {
            list.add(toDTO(auditProgramMainActivity));
        }

        return list;
    }

}
