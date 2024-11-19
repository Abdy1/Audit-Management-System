package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditStaffDTO;
import com.cbo.audit.dto.AuditeesDTO;
import com.cbo.audit.dto.EngagementDTO;
import com.cbo.audit.persistence.model.AuditStaff;
import com.cbo.audit.persistence.model.Auditees;
import com.cbo.audit.persistence.model.EngagementInfo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AuditeesMapper {

    AuditeesMapper INSTANCE = Mappers.getMapper(AuditeesMapper.class);

    AuditeesDTO toDTO(Auditees user);

    void copyToDTO(Auditees user, @MappingTarget AuditeesDTO userDTO);

    Auditees toEntity(AuditeesDTO userDTO);

    default List<AuditeesDTO> auditeesToAuditeesDTO(List<Auditees> auditees) {
        if (auditees == null) {
            return null;
        }

        List<AuditeesDTO> list = new ArrayList<AuditeesDTO>(auditees.size());
        for (Auditees auditees1 : auditees) {
            list.add(toDTO(auditees1));
        }

        return list;
    }
    default List<Auditees> toEntities(List<AuditeesDTO> auditeesDTOS) {
        if (auditeesDTOS == null) {
            return null;
        }

        List<Auditees> list = new ArrayList<Auditees>(auditeesDTOS.size());
        for (AuditeesDTO auditeesDTO : auditeesDTOS) {
            list.add(toEntity(auditeesDTO));
        }

        return list;
    }

}
