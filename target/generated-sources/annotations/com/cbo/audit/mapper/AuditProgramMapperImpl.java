package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditProgramDTO;
import com.cbo.audit.persistence.model.AuditProgram;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-30T09:57:20+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class AuditProgramMapperImpl implements AuditProgramMapper {

    @Override
    public AuditProgramDTO toDTO(AuditProgram auditProgram) {
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

    @Override
    public void copyToDTO(AuditProgram auditProgram, AuditProgramDTO auditProgramDTO) {
        if ( auditProgram == null ) {
            return;
        }

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
    }

    @Override
    public AuditProgram toEntity(AuditProgramDTO auditProgramDTO) {
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
