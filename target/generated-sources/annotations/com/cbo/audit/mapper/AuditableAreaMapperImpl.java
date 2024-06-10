package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditObjectDTO;
import com.cbo.audit.dto.AuditTypeDTO;
import com.cbo.audit.dto.AuditableAreaDTO;
import com.cbo.audit.persistence.model.AuditObject;
import com.cbo.audit.persistence.model.AuditType;
import com.cbo.audit.persistence.model.AuditableArea;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-07T14:41:02+0300",
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

    protected AuditTypeDTO auditTypeToAuditTypeDTO(AuditType auditType) {
        if ( auditType == null ) {
            return null;
        }

        AuditTypeDTO auditTypeDTO = new AuditTypeDTO();

        auditTypeDTO.setId( auditType.getId() );
        auditTypeDTO.setCreatedUser( auditType.getCreatedUser() );
        auditTypeDTO.setModifiedUser( auditType.getModifiedUser() );
        auditTypeDTO.setCreatedTimestamp( auditType.getCreatedTimestamp() );
        auditTypeDTO.setModifiedTimestamp( auditType.getModifiedTimestamp() );
        auditTypeDTO.setName( auditType.getName() );
        auditTypeDTO.setDescription( auditType.getDescription() );

        return auditTypeDTO;
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
        auditObjectDTO.setAuditType( auditTypeToAuditTypeDTO( auditObject.getAuditType() ) );
        auditObjectDTO.setStatus( auditObject.getStatus() );
        auditObjectDTO.setAuditUniverse( auditObject.getAuditUniverse() );

        return auditObjectDTO;
    }

    protected void auditTypeToAuditTypeDTO1(AuditType auditType, AuditTypeDTO mappingTarget) {
        if ( auditType == null ) {
            return;
        }

        mappingTarget.setId( auditType.getId() );
        mappingTarget.setCreatedUser( auditType.getCreatedUser() );
        mappingTarget.setModifiedUser( auditType.getModifiedUser() );
        mappingTarget.setCreatedTimestamp( auditType.getCreatedTimestamp() );
        mappingTarget.setModifiedTimestamp( auditType.getModifiedTimestamp() );
        mappingTarget.setName( auditType.getName() );
        mappingTarget.setDescription( auditType.getDescription() );
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
        if ( auditObject.getAuditType() != null ) {
            if ( mappingTarget.getAuditType() == null ) {
                mappingTarget.setAuditType( new AuditTypeDTO() );
            }
            auditTypeToAuditTypeDTO1( auditObject.getAuditType(), mappingTarget.getAuditType() );
        }
        else {
            mappingTarget.setAuditType( null );
        }
        mappingTarget.setStatus( auditObject.getStatus() );
        mappingTarget.setAuditUniverse( auditObject.getAuditUniverse() );
    }

    protected AuditType auditTypeDTOToAuditType(AuditTypeDTO auditTypeDTO) {
        if ( auditTypeDTO == null ) {
            return null;
        }

        AuditType auditType = new AuditType();

        auditType.setId( auditTypeDTO.getId() );
        auditType.setCreatedUser( auditTypeDTO.getCreatedUser() );
        auditType.setModifiedUser( auditTypeDTO.getModifiedUser() );
        auditType.setCreatedTimestamp( auditTypeDTO.getCreatedTimestamp() );
        auditType.setModifiedTimestamp( auditTypeDTO.getModifiedTimestamp() );
        auditType.setName( auditTypeDTO.getName() );
        auditType.setDescription( auditTypeDTO.getDescription() );

        return auditType;
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
        auditObject.setStatus( auditObjectDTO.getStatus() );
        auditObject.setAuditUniverse( auditObjectDTO.getAuditUniverse() );
        auditObject.setAuditType( auditTypeDTOToAuditType( auditObjectDTO.getAuditType() ) );

        return auditObject;
    }
}
