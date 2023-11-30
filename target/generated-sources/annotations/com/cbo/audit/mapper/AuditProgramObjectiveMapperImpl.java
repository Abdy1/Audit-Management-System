package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditProgramDTO;
import com.cbo.audit.dto.AuditProgramObjectiveDTO;
import com.cbo.audit.persistence.model.AuditProgram;
import com.cbo.audit.persistence.model.AuditProgramObjective;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-30T09:57:20+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
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
        auditProgramObjectiveDTO.setAuditProgram( auditProgramToAuditProgramDTO( auditProgramObjective.getAuditProgram() ) );

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
        if ( auditProgramObjective.getAuditProgram() != null ) {
            if ( auditProgramObjectiveDTO.getAuditProgram() == null ) {
                auditProgramObjectiveDTO.setAuditProgram( new AuditProgramDTO() );
            }
            auditProgramToAuditProgramDTO1( auditProgramObjective.getAuditProgram(), auditProgramObjectiveDTO.getAuditProgram() );
        }
        else {
            auditProgramObjectiveDTO.setAuditProgram( null );
        }
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
        auditProgramObjective.setAuditProgram( auditProgramDTOToAuditProgram( auditProgramObjectiveDTO.getAuditProgram() ) );

        return auditProgramObjective;
    }

    protected AuditProgramDTO auditProgramToAuditProgramDTO(AuditProgram auditProgram) {
        if ( auditProgram == null ) {
            return null;
        }

        AuditProgramDTO auditProgramDTO = new AuditProgramDTO();

        auditProgramDTO.setId( auditProgram.getId() );
        auditProgramDTO.setCreatedUser( auditProgram.getCreatedUser() );
        auditProgramDTO.setModifiedUser( auditProgram.getModifiedUser() );
        auditProgramDTO.setCreatedTimestamp( auditProgram.getCreatedTimestamp() );
        auditProgramDTO.setModifiedTimestamp( auditProgram.getModifiedTimestamp() );
        auditProgramDTO.setName( auditProgram.getName() );
        auditProgramDTO.setStatus( auditProgram.getStatus() );
        auditProgramDTO.setPreviousStatus( auditProgram.getPreviousStatus() );
        auditProgramDTO.setObjectives( auditProgram.getObjectives() );
        auditProgramDTO.setScopeDescription( auditProgram.getScopeDescription() );
        auditProgramDTO.setOverAllTime( auditProgram.getOverAllTime() );

        return auditProgramDTO;
    }

    protected void auditProgramToAuditProgramDTO1(AuditProgram auditProgram, AuditProgramDTO mappingTarget) {
        if ( auditProgram == null ) {
            return;
        }

        mappingTarget.setId( auditProgram.getId() );
        mappingTarget.setCreatedUser( auditProgram.getCreatedUser() );
        mappingTarget.setModifiedUser( auditProgram.getModifiedUser() );
        mappingTarget.setCreatedTimestamp( auditProgram.getCreatedTimestamp() );
        mappingTarget.setModifiedTimestamp( auditProgram.getModifiedTimestamp() );
        mappingTarget.setName( auditProgram.getName() );
        mappingTarget.setStatus( auditProgram.getStatus() );
        mappingTarget.setPreviousStatus( auditProgram.getPreviousStatus() );
        mappingTarget.setObjectives( auditProgram.getObjectives() );
        mappingTarget.setScopeDescription( auditProgram.getScopeDescription() );
        mappingTarget.setOverAllTime( auditProgram.getOverAllTime() );
    }

    protected AuditProgram auditProgramDTOToAuditProgram(AuditProgramDTO auditProgramDTO) {
        if ( auditProgramDTO == null ) {
            return null;
        }

        AuditProgram auditProgram = new AuditProgram();

        auditProgram.setId( auditProgramDTO.getId() );
        auditProgram.setCreatedUser( auditProgramDTO.getCreatedUser() );
        auditProgram.setModifiedUser( auditProgramDTO.getModifiedUser() );
        auditProgram.setCreatedTimestamp( auditProgramDTO.getCreatedTimestamp() );
        auditProgram.setModifiedTimestamp( auditProgramDTO.getModifiedTimestamp() );
        auditProgram.setName( auditProgramDTO.getName() );
        auditProgram.setStatus( auditProgramDTO.getStatus() );
        auditProgram.setPreviousStatus( auditProgramDTO.getPreviousStatus() );
        auditProgram.setObjectives( auditProgramDTO.getObjectives() );
        auditProgram.setScopeDescription( auditProgramDTO.getScopeDescription() );
        auditProgram.setOverAllTime( auditProgramDTO.getOverAllTime() );

        return auditProgram;
    }
}
