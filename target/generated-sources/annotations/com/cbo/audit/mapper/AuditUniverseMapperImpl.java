package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditUniverseDTO;
import com.cbo.audit.persistence.model.AuditUniverse;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-07T14:41:03+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class AuditUniverseMapperImpl implements AuditUniverseMapper {

    @Override
    public AuditUniverseDTO toDTO(AuditUniverse auditUniverse) {
        if ( auditUniverse == null ) {
            return null;
        }

        AuditUniverseDTO auditUniverseDTO = new AuditUniverseDTO();

        auditUniverseDTO.setId( auditUniverse.getId() );
        auditUniverseDTO.setCreatedUser( auditUniverse.getCreatedUser() );
        auditUniverseDTO.setModifiedUser( auditUniverse.getModifiedUser() );
        auditUniverseDTO.setCreatedTimestamp( auditUniverse.getCreatedTimestamp() );
        auditUniverseDTO.setModifiedTimestamp( auditUniverse.getModifiedTimestamp() );
        auditUniverseDTO.setName( auditUniverse.getName() );
        auditUniverseDTO.setStatus( auditUniverse.getStatus() );
        auditUniverseDTO.setApprovedBy( auditUniverse.getApprovedBy() );
        auditUniverseDTO.setApprovedAt( auditUniverse.getApprovedAt() );

        return auditUniverseDTO;
    }

    @Override
    public void copyToDTO(AuditUniverse auditUniverse, AuditUniverseDTO auditUniverseDTO) {
        if ( auditUniverse == null ) {
            return;
        }

        auditUniverseDTO.setId( auditUniverse.getId() );
        auditUniverseDTO.setCreatedUser( auditUniverse.getCreatedUser() );
        auditUniverseDTO.setModifiedUser( auditUniverse.getModifiedUser() );
        auditUniverseDTO.setCreatedTimestamp( auditUniverse.getCreatedTimestamp() );
        auditUniverseDTO.setModifiedTimestamp( auditUniverse.getModifiedTimestamp() );
        auditUniverseDTO.setName( auditUniverse.getName() );
        auditUniverseDTO.setStatus( auditUniverse.getStatus() );
        auditUniverseDTO.setApprovedBy( auditUniverse.getApprovedBy() );
        auditUniverseDTO.setApprovedAt( auditUniverse.getApprovedAt() );
    }

    @Override
    public AuditUniverse toEntity(AuditUniverseDTO auditUniverseDTO) {
        if ( auditUniverseDTO == null ) {
            return null;
        }

        AuditUniverse auditUniverse = new AuditUniverse();

        auditUniverse.setId( auditUniverseDTO.getId() );
        auditUniverse.setCreatedUser( auditUniverseDTO.getCreatedUser() );
        auditUniverse.setModifiedUser( auditUniverseDTO.getModifiedUser() );
        auditUniverse.setCreatedTimestamp( auditUniverseDTO.getCreatedTimestamp() );
        auditUniverse.setModifiedTimestamp( auditUniverseDTO.getModifiedTimestamp() );
        auditUniverse.setName( auditUniverseDTO.getName() );
        auditUniverse.setStatus( auditUniverseDTO.getStatus() );
        auditUniverse.setApprovedBy( auditUniverseDTO.getApprovedBy() );
        auditUniverse.setApprovedAt( auditUniverseDTO.getApprovedAt() );

        return auditUniverse;
    }
}
