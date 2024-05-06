package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditTeamDTO;
import com.cbo.audit.persistence.model.AuditTeam;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
@Mapper(componentModel = "spring")
public interface AuditTeamMapper {
    AuditTeamMapper INSTANCE = Mappers.getMapper(AuditTeamMapper.class);

    AuditTeamDTO toDTO(AuditTeam auditTeam);

    void copyToDTO(AuditTeam auditTeam, @MappingTarget AuditTeamDTO auditTeamDTO);

    AuditTeam toEntity(AuditTeamDTO auditTeamDTO);

    default List<AuditTeamDTO> AuditTeamsToAuditTeamDTOs(List<AuditTeam> auditTeams) {
        if (auditTeams == null) {
            return null;
        }

        List<AuditTeamDTO> list = new ArrayList<AuditTeamDTO>(auditTeams.size());
        for (AuditTeam auditTeam : auditTeams) {
            list.add(toDTO(auditTeam));
        }

        return list;
    }

    default List<AuditTeam> toEntities(List<AuditTeamDTO> auditTeamDTOS) {
        if (auditTeamDTOS == null) {
            return null;
        }

        List<AuditTeam> list = new ArrayList<AuditTeam>(auditTeamDTOS.size());
        for (AuditTeamDTO auditTeamDTO : auditTeamDTOS) {
            list.add(toEntity(auditTeamDTO));
        }

        return list;
    }

}
