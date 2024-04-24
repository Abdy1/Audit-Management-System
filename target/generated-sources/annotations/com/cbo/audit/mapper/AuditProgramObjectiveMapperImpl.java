package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditProgramObjectiveDTO;
import com.cbo.audit.persistence.model.AuditProgramObjective;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-22T11:27:18+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class AuditProgramObjectiveMapperImpl implements AuditProgramObjectiveMapper {

    @Override
    public AuditProgramObjectiveDTO toDTO(AuditProgramObjective auditProgramObjective) {
        if ( auditProgramObjective == null ) {
            return null;
        }

        AuditProgramObjectiveDTO auditProgramObjectiveDTO = new AuditProgramObjectiveDTO();

        auditProgramObjectiveDTO.setId( auditProgramObjective.getId() );
        auditProgramObjectiveDTO.setCreatedUser( auditProgramObjective.getCreatedUser() );
        auditProgramObjectiveDTO.setModifiedUser( auditProgramObjective.getModifiedUser() );
        auditProgramObjectiveDTO.setCreatedTimestamp( auditProgramObjective.getCreatedTimestamp() );
        auditProgramObjectiveDTO.setModifiedTimestamp( auditProgramObjective.getModifiedTimestamp() );
        auditProgramObjectiveDTO.setDescription( auditProgramObjective.getDescription() );

        return auditProgramObjectiveDTO;
    }

    @Override
    public void copyToDTO(AuditProgramObjective auditProgramObjective, AuditProgramObjectiveDTO auditProgramObjectiveDTO) {
        if ( auditProgramObjective == null ) {
            return;
        }

        auditProgramObjectiveDTO.setId( auditProgramObjective.getId() );
        auditProgramObjectiveDTO.setCreatedUser( auditProgramObjective.getCreatedUser() );
        auditProgramObjectiveDTO.setModifiedUser( auditProgramObjective.getModifiedUser() );
        auditProgramObjectiveDTO.setCreatedTimestamp( auditProgramObjective.getCreatedTimestamp() );
        auditProgramObjectiveDTO.setModifiedTimestamp( auditProgramObjective.getModifiedTimestamp() );
        auditProgramObjectiveDTO.setDescription( auditProgramObjective.getDescription() );
    }

    @Override
    public AuditProgramObjective toEntity(AuditProgramObjectiveDTO auditProgramObjectiveDTO) {
        if ( auditProgramObjectiveDTO == null ) {
            return null;
        }

        AuditProgramObjective auditProgramObjective = new AuditProgramObjective();

        auditProgramObjective.setId( auditProgramObjectiveDTO.getId() );
        auditProgramObjective.setCreatedUser( auditProgramObjectiveDTO.getCreatedUser() );
        auditProgramObjective.setModifiedUser( auditProgramObjectiveDTO.getModifiedUser() );
        auditProgramObjective.setCreatedTimestamp( auditProgramObjectiveDTO.getCreatedTimestamp() );
        auditProgramObjective.setModifiedTimestamp( auditProgramObjectiveDTO.getModifiedTimestamp() );
        auditProgramObjective.setDescription( auditProgramObjectiveDTO.getDescription() );

        return auditProgramObjective;
    }
}
