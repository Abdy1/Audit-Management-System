package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditObjectDTO;
import com.cbo.audit.persistence.model.AuditObject;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-01T09:25:15+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class AuditObjectMapperImpl implements AuditObjectMapper {

    @Override
    public AuditObjectDTO toDTO(AuditObject auditObject) {
        if ( auditObject == null ) {
            return null;
        }

        AuditObjectDTO auditObjectDTO = new AuditObjectDTO();

        auditObjectDTO.setId( auditObject.getId() );
        auditObjectDTO.setCreatedUser( auditObject.getCreatedUser() );
        auditObjectDTO.setModifiedUser( auditObject.getModifiedUser() );
        auditObjectDTO.setCreatedTimestamp( auditObject.getCreatedTimestamp() );
        auditObjectDTO.setModifiedTimestamp( auditObject.getModifiedTimestamp() );
        auditObjectDTO.setName( auditObject.getName() );
        auditObjectDTO.setDescription( auditObject.getDescription() );
        auditObjectDTO.setAuditType( auditObject.getAuditType() );

        return auditObjectDTO;
    }

    @Override
    public void copyToDTO(AuditObject auditObject, AuditObjectDTO auditObjectDTO) {
        if ( auditObject == null ) {
            return;
        }

        auditObjectDTO.setId( auditObject.getId() );
        auditObjectDTO.setCreatedUser( auditObject.getCreatedUser() );
        auditObjectDTO.setModifiedUser( auditObject.getModifiedUser() );
        auditObjectDTO.setCreatedTimestamp( auditObject.getCreatedTimestamp() );
        auditObjectDTO.setModifiedTimestamp( auditObject.getModifiedTimestamp() );
        auditObjectDTO.setName( auditObject.getName() );
        auditObjectDTO.setDescription( auditObject.getDescription() );
        auditObjectDTO.setAuditType( auditObject.getAuditType() );
    }

    @Override
    public AuditObject toEntity(AuditObjectDTO auditObjectDTO) {
        if ( auditObjectDTO == null ) {
            return null;
        }

        AuditObject auditObject = new AuditObject();

        auditObject.setId( auditObjectDTO.getId() );
        auditObject.setCreatedUser( auditObjectDTO.getCreatedUser() );
        auditObject.setModifiedUser( auditObjectDTO.getModifiedUser() );
        auditObject.setCreatedTimestamp( auditObjectDTO.getCreatedTimestamp() );
        auditObject.setModifiedTimestamp( auditObjectDTO.getModifiedTimestamp() );
        auditObject.setName( auditObjectDTO.getName() );
        auditObject.setDescription( auditObjectDTO.getDescription() );
        auditObject.setAuditType( auditObjectDTO.getAuditType() );

        return auditObject;
    }
}
