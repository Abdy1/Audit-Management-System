package com.cbo.audit.mapper;

import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.AuditObjectDTO;
import com.cbo.audit.dto.AuditUniverseDTO;
import com.cbo.audit.persistence.model.AnnualPlan;
import com.cbo.audit.persistence.model.AuditObject;
import com.cbo.audit.persistence.model.AuditUniverse;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-02T09:20:48+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class AnnualPlanMapperImpl implements AnnualPlanMapper {

    @Override
    public AnnualPlanDTO toDTO(AnnualPlan annualPlan) {
        if ( annualPlan == null ) {
            return null;
        }

        AnnualPlanDTO annualPlanDTO = new AnnualPlanDTO();

        annualPlanDTO.setId( annualPlan.getId() );
        annualPlanDTO.setCreatedUser( annualPlan.getCreatedUser() );
        annualPlanDTO.setModifiedUser( annualPlan.getModifiedUser() );
        annualPlanDTO.setCreatedTimestamp( annualPlan.getCreatedTimestamp() );
        annualPlanDTO.setModifiedTimestamp( annualPlan.getModifiedTimestamp() );
        annualPlanDTO.setName( annualPlan.getName() );
        annualPlanDTO.setDescription( annualPlan.getDescription() );
        annualPlanDTO.setYear( annualPlan.getYear() );
        annualPlanDTO.setRiskLevel( annualPlan.getRiskLevel() );
        annualPlanDTO.setRiskScore( annualPlan.getRiskScore() );
        annualPlanDTO.setStatus( annualPlan.getStatus() );
        annualPlanDTO.setRectificationStatus( annualPlan.getRectificationStatus() );
        annualPlanDTO.setAuditUniverse( auditUniverseToAuditUniverseDTO( annualPlan.getAuditUniverse() ) );

        return annualPlanDTO;
    }

    @Override
    public void copyToDTO(AnnualPlan annualPlan, AnnualPlanDTO annualPlanDTO) {
        if ( annualPlan == null ) {
            return;
        }

        annualPlanDTO.setId( annualPlan.getId() );
        annualPlanDTO.setCreatedUser( annualPlan.getCreatedUser() );
        annualPlanDTO.setModifiedUser( annualPlan.getModifiedUser() );
        annualPlanDTO.setCreatedTimestamp( annualPlan.getCreatedTimestamp() );
        annualPlanDTO.setModifiedTimestamp( annualPlan.getModifiedTimestamp() );
        annualPlanDTO.setName( annualPlan.getName() );
        annualPlanDTO.setDescription( annualPlan.getDescription() );
        annualPlanDTO.setYear( annualPlan.getYear() );
        annualPlanDTO.setRiskLevel( annualPlan.getRiskLevel() );
        annualPlanDTO.setRiskScore( annualPlan.getRiskScore() );
        annualPlanDTO.setStatus( annualPlan.getStatus() );
        annualPlanDTO.setRectificationStatus( annualPlan.getRectificationStatus() );
        if ( annualPlan.getAuditUniverse() != null ) {
            if ( annualPlanDTO.getAuditUniverse() == null ) {
                annualPlanDTO.setAuditUniverse( new AuditUniverseDTO() );
            }
            auditUniverseToAuditUniverseDTO1( annualPlan.getAuditUniverse(), annualPlanDTO.getAuditUniverse() );
        }
        else {
            annualPlanDTO.setAuditUniverse( null );
        }
    }

    @Override
    public AnnualPlan toEntity(AnnualPlanDTO annualPlanDTO) {
        if ( annualPlanDTO == null ) {
            return null;
        }

        AnnualPlan annualPlan = new AnnualPlan();

        annualPlan.setId( annualPlanDTO.getId() );
        annualPlan.setCreatedUser( annualPlanDTO.getCreatedUser() );
        annualPlan.setModifiedUser( annualPlanDTO.getModifiedUser() );
        annualPlan.setCreatedTimestamp( annualPlanDTO.getCreatedTimestamp() );
        annualPlan.setModifiedTimestamp( annualPlanDTO.getModifiedTimestamp() );
        annualPlan.setName( annualPlanDTO.getName() );
        annualPlan.setDescription( annualPlanDTO.getDescription() );
        annualPlan.setYear( annualPlanDTO.getYear() );
        annualPlan.setRiskLevel( annualPlanDTO.getRiskLevel() );
        annualPlan.setRiskScore( annualPlanDTO.getRiskScore() );
        annualPlan.setStatus( annualPlanDTO.getStatus() );
        annualPlan.setRectificationStatus( annualPlanDTO.getRectificationStatus() );
        annualPlan.setAuditUniverse( auditUniverseDTOToAuditUniverse( annualPlanDTO.getAuditUniverse() ) );

        return annualPlan;
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

    protected AuditUniverseDTO auditUniverseToAuditUniverseDTO(AuditUniverse auditUniverse) {
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
        auditUniverseDTO.setAuditObject( auditObjectToAuditObjectDTO( auditUniverse.getAuditObject() ) );

        return auditUniverseDTO;
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

    protected void auditUniverseToAuditUniverseDTO1(AuditUniverse auditUniverse, AuditUniverseDTO mappingTarget) {
        if ( auditUniverse == null ) {
            return;
        }

        mappingTarget.setId( auditUniverse.getId() );
        mappingTarget.setCreatedUser( auditUniverse.getCreatedUser() );
        mappingTarget.setModifiedUser( auditUniverse.getModifiedUser() );
        mappingTarget.setCreatedTimestamp( auditUniverse.getCreatedTimestamp() );
        mappingTarget.setModifiedTimestamp( auditUniverse.getModifiedTimestamp() );
        mappingTarget.setName( auditUniverse.getName() );
        mappingTarget.setStatus( auditUniverse.getStatus() );
        mappingTarget.setApprovedBy( auditUniverse.getApprovedBy() );
        mappingTarget.setApprovedAt( auditUniverse.getApprovedAt() );
        if ( auditUniverse.getAuditObject() != null ) {
            if ( mappingTarget.getAuditObject() == null ) {
                mappingTarget.setAuditObject( new AuditObjectDTO() );
            }
            auditObjectToAuditObjectDTO1( auditUniverse.getAuditObject(), mappingTarget.getAuditObject() );
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

        return auditObject;
    }

    protected AuditUniverse auditUniverseDTOToAuditUniverse(AuditUniverseDTO auditUniverseDTO) {
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
        auditUniverse.setAuditObject( auditObjectDTOToAuditObject( auditUniverseDTO.getAuditObject() ) );

        return auditUniverse;
    }
}
