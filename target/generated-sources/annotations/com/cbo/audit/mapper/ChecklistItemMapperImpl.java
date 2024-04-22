package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditObjectDTO;
import com.cbo.audit.dto.AuditableAreaDTO;
import com.cbo.audit.dto.ChecklistItemDTO;
import com.cbo.audit.persistence.model.AuditObject;
import com.cbo.audit.persistence.model.AuditableArea;
import com.cbo.audit.persistence.model.ChecklistItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-22T08:12:49+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class ChecklistItemMapperImpl implements ChecklistItemMapper {

    @Override
    public ChecklistItemDTO toDTO(ChecklistItem checklistItem) {
        if ( checklistItem == null ) {
            return null;
        }

        ChecklistItemDTO checklistItemDTO = new ChecklistItemDTO();

        checklistItemDTO.setId( checklistItem.getId() );
        checklistItemDTO.setCreatedUser( checklistItem.getCreatedUser() );
        checklistItemDTO.setModifiedUser( checklistItem.getModifiedUser() );
        checklistItemDTO.setCreatedTimestamp( checklistItem.getCreatedTimestamp() );
        checklistItemDTO.setModifiedTimestamp( checklistItem.getModifiedTimestamp() );
        checklistItemDTO.setName( checklistItem.getName() );
        checklistItemDTO.setDescription( checklistItem.getDescription() );
        List<String> list = checklistItem.getObjective_list();
        if ( list != null ) {
            checklistItemDTO.setObjective_list( new ArrayList<String>( list ) );
        }
        List<String> list1 = checklistItem.getAction_list();
        if ( list1 != null ) {
            checklistItemDTO.setAction_list( new ArrayList<String>( list1 ) );
        }
        checklistItemDTO.setAuditableArea( auditableAreaToAuditableAreaDTO( checklistItem.getAuditableArea() ) );

        return checklistItemDTO;
    }

    @Override
    public void copyToDTO(ChecklistItem checklistItem, ChecklistItemDTO checklistItemDTO) {
        if ( checklistItem == null ) {
            return;
        }

        checklistItemDTO.setId( checklistItem.getId() );
        checklistItemDTO.setCreatedUser( checklistItem.getCreatedUser() );
        checklistItemDTO.setModifiedUser( checklistItem.getModifiedUser() );
        checklistItemDTO.setCreatedTimestamp( checklistItem.getCreatedTimestamp() );
        checklistItemDTO.setModifiedTimestamp( checklistItem.getModifiedTimestamp() );
        checklistItemDTO.setName( checklistItem.getName() );
        checklistItemDTO.setDescription( checklistItem.getDescription() );
        if ( checklistItemDTO.getObjective_list() != null ) {
            List<String> list = checklistItem.getObjective_list();
            if ( list != null ) {
                checklistItemDTO.getObjective_list().clear();
                checklistItemDTO.getObjective_list().addAll( list );
            }
            else {
                checklistItemDTO.setObjective_list( null );
            }
        }
        else {
            List<String> list = checklistItem.getObjective_list();
            if ( list != null ) {
                checklistItemDTO.setObjective_list( new ArrayList<String>( list ) );
            }
        }
        if ( checklistItemDTO.getAction_list() != null ) {
            List<String> list1 = checklistItem.getAction_list();
            if ( list1 != null ) {
                checklistItemDTO.getAction_list().clear();
                checklistItemDTO.getAction_list().addAll( list1 );
            }
            else {
                checklistItemDTO.setAction_list( null );
            }
        }
        else {
            List<String> list1 = checklistItem.getAction_list();
            if ( list1 != null ) {
                checklistItemDTO.setAction_list( new ArrayList<String>( list1 ) );
            }
        }
        if ( checklistItem.getAuditableArea() != null ) {
            if ( checklistItemDTO.getAuditableArea() == null ) {
                checklistItemDTO.setAuditableArea( new AuditableAreaDTO() );
            }
            auditableAreaToAuditableAreaDTO1( checklistItem.getAuditableArea(), checklistItemDTO.getAuditableArea() );
        }
        else {
            checklistItemDTO.setAuditableArea( null );
        }
    }

    @Override
    public ChecklistItem toEntity(ChecklistItemDTO checklistItemDTO) {
        if ( checklistItemDTO == null ) {
            return null;
        }

        ChecklistItem checklistItem = new ChecklistItem();

        checklistItem.setId( checklistItemDTO.getId() );
        checklistItem.setCreatedUser( checklistItemDTO.getCreatedUser() );
        checklistItem.setModifiedUser( checklistItemDTO.getModifiedUser() );
        checklistItem.setCreatedTimestamp( checklistItemDTO.getCreatedTimestamp() );
        checklistItem.setModifiedTimestamp( checklistItemDTO.getModifiedTimestamp() );
        checklistItem.setName( checklistItemDTO.getName() );
        checklistItem.setDescription( checklistItemDTO.getDescription() );
        List<String> list = checklistItemDTO.getObjective_list();
        if ( list != null ) {
            checklistItem.setObjective_list( new ArrayList<String>( list ) );
        }
        List<String> list1 = checklistItemDTO.getAction_list();
        if ( list1 != null ) {
            checklistItem.setAction_list( new ArrayList<String>( list1 ) );
        }
        checklistItem.setAuditableArea( auditableAreaDTOToAuditableArea( checklistItemDTO.getAuditableArea() ) );

        return checklistItem;
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
        auditObjectDTO.setAuditUniverse( auditObject.getAuditUniverse() );

        return auditObjectDTO;
    }

    protected AuditableAreaDTO auditableAreaToAuditableAreaDTO(AuditableArea auditableArea) {
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
        mappingTarget.setAuditUniverse( auditObject.getAuditUniverse() );
    }

    protected void auditableAreaToAuditableAreaDTO1(AuditableArea auditableArea, AuditableAreaDTO mappingTarget) {
        if ( auditableArea == null ) {
            return;
        }

        mappingTarget.setId( auditableArea.getId() );
        mappingTarget.setCreatedUser( auditableArea.getCreatedUser() );
        mappingTarget.setModifiedUser( auditableArea.getModifiedUser() );
        mappingTarget.setCreatedTimestamp( auditableArea.getCreatedTimestamp() );
        mappingTarget.setModifiedTimestamp( auditableArea.getModifiedTimestamp() );
        mappingTarget.setName( auditableArea.getName() );
        mappingTarget.setDescription( auditableArea.getDescription() );
        if ( auditableArea.getAuditObject() != null ) {
            if ( mappingTarget.getAuditObject() == null ) {
                mappingTarget.setAuditObject( new AuditObjectDTO() );
            }
            auditObjectToAuditObjectDTO1( auditableArea.getAuditObject(), mappingTarget.getAuditObject() );
        }
        else {
            mappingTarget.setAuditObject( null );
        }
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
        auditObject.setAuditUniverse( auditObjectDTO.getAuditUniverse() );

        return auditObject;
    }

    protected AuditableArea auditableAreaDTOToAuditableArea(AuditableAreaDTO auditableAreaDTO) {
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
}
