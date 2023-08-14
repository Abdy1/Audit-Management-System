package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditEngagementDTO;
import com.cbo.audit.persistence.model.AuditEngagement;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AuditEngagementMapper {


    AuditEngagementMapper INSTANCE = Mappers.getMapper(AuditEngagementMapper.class);

    AuditEngagementDTO toDTO(AuditEngagement auditEngagement);

    void copyToDTO(AuditEngagement auditEngagement, @MappingTarget AuditEngagementDTO auditEngagementDTO);

    AuditEngagement toEntity(AuditEngagementDTO auditEngagementDTO);

    default List<AuditEngagementDTO> auditEngagementsToAuditEngagementDTOs(List<AuditEngagement> auditEngagements) {
        if (auditEngagements == null) {
            return null;
        }

        List<AuditEngagementDTO> list = new ArrayList<AuditEngagementDTO>(auditEngagements.size());
        for (AuditEngagement auditEngagement : auditEngagements) {
            list.add(toDTO(auditEngagement));
        }

        return list;
    }
}