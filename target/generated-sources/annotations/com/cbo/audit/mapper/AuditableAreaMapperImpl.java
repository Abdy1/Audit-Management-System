package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditObjectDTO;
import com.cbo.audit.dto.AuditableAreaDTO;
import com.cbo.audit.persistence.model.AuditObject;
import com.cbo.audit.persistence.model.AuditableArea;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-29T08:41:43+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class AuditableAreaMapperImpl implements AuditableAreaMapper {

    @Override
    public AuditableAreaDTO toDTO(AuditableArea auditableArea) {
        if ( auditableArea == null ) {
            return null;
        }

        AuditableAreaDTO auditableAreaDTO = new AuditableAreaDTO();

        auditableAreaDTO.setId( auditableArea.getId() );
        auditableAreaDTO.setCreatedUser( auditableArea.getCreatedUser() );
        auditableAreaDTO.setModifiedUser( auditableArea.getModifiedUser() );
        auditableAreaDTO.setCreatedTimestamp( auditableArea.getCreatedTimestamp() );
        auditableAreaDTO.setModifiedTimestamp( auditableArea.getModifiedTimestamp() );
        auditableAreaDTO.setName( auditableArea.getName() );
        auditableAreaDTO.setDescription( auditableArea.getDescription() );
        auditableAreaDTO.setAuditObject( auditObjectToAuditObjectDTO( auditableArea.getAuditObject() ) );

        return auditableAreaDTO;
    }

    @Override
    public void copyToDTO(AuditableArea auditableArea, AuditableAreaDTO auditableAreaDTO) {
        if ( auditableArea == null ) {
            return;
        }

        auditableAreaDTO.setId( auditableArea.getId() );
        auditableAreaDTO.setCreatedUser( auditableArea.getCreatedUser() );
        auditableAreaDTO.setModifiedUser( auditableArea.getModifiedUser() );
        auditableAreaDTO.setCreatedTimestamp( auditableArea.getCreatedTimestamp() );
        auditableAreaDTO.setModifiedTimestamp( auditableArea.getModifiedTimestamp() );
        auditableAreaDTO.setName( auditableArea.getName() );
        auditableAreaDTO.setDescription( auditableArea.getDescription() );
        if ( auditableArea.getAuditObject() != null ) {
            if ( auditableAreaDTO.getAuditObject() == null ) {
                auditableAreaDTO.setAuditObject( new AuditObjectDTO() );
            }
            auditObjectToAuditObjectDTO1( auditableArea.getAuditObject(), auditableAreaDTO.getAuditObject() );
        }
        else {
            auditableAreaDTO.setAuditObject( null );
        }
    }

    @Override
    public AuditableArea toEntity(AuditableAreaDTO auditableAreaDTO) {
        if ( auditableAreaDTO == null ) {
            return null;
        }

        AuditableArea auditableArea = new AuditableArea();

        auditableArea.setId( auditableAreaDTO.getId() );
        auditableArea.setCreatedUser( auditableAreaDTO.getCreatedUser() );
        auditableArea.setModifiedUser( auditableAreaDTO.getModifiedUser() );
        auditableArea.setCreatedTimestamp( auditableAreaDTO.getCreatedTimestamp() );
        auditableArea.setModifiedTimestamp( auditableAreaDTO.getModifiedTimestamp() );
        auditableArea.setName( auditableAreaDTO.getName() );
        auditableArea.setDescription( auditableAreaDTO.getDescription() );
        auditableArea.setAuditObject( auditObjectDTOToAuditObject( auditableAreaDTO.getAuditObject() ) );

        return auditableArea;
    }

    protected AuditObjectDTO auditObjectToAuditObjectDTO(AuditObject auditObject) {
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

    protected void auditObjectToAuditObjectDTO1(AuditObject auditObject, AuditObjectDTO mappingTarget) {
        if ( auditObject == null ) {
            return;
        }

        mappingTarget.setId( auditObject.getId() );
        mappingTarget.setCreatedUser( auditObject.getCreatedUser() );
        mappingTarget.setModifiedUser( auditObject.getModifiedUser() );
        mappingTarget.setCreatedTimestamp( auditObject.getCreatedTimestamp() );
        mappingTarget.setModifiedTimestamp( auditObject.getModifiedTimestamp() );
        mappingTarget.setName( auditObject.getName() );
        mappingTarget.setDescription( auditObject.getDescription() );
        mappingTarget.setAuditType( auditObject.getAuditType() );
    }

    protected AuditObject auditObjectDTOToAuditObject(AuditObjectDTO auditObjectDTO) {
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
