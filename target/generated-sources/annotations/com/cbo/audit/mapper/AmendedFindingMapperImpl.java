package com.cbo.audit.mapper;

import com.cbo.audit.dto.AmendedFindingDTO;
import com.cbo.audit.dto.AuditStaffDTO;
import com.cbo.audit.dto.AuditTypeDTO;
import com.cbo.audit.persistence.model.AmendedFinding;
import com.cbo.audit.persistence.model.AuditStaff;
import com.cbo.audit.persistence.model.AuditType;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-07T14:41:02+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class AmendedFindingMapperImpl implements AmendedFindingMapper {

    @Override
    public AmendedFindingDTO toDTO(AmendedFinding amendedFinding) {
        if ( amendedFinding == null ) {
            return null;
        }

        AmendedFindingDTO amendedFindingDTO = new AmendedFindingDTO();

        amendedFindingDTO.setId( amendedFinding.getId() );
        amendedFindingDTO.setCreatedUser( amendedFinding.getCreatedUser() );
        amendedFindingDTO.setModifiedUser( amendedFinding.getModifiedUser() );
        amendedFindingDTO.setCreatedTimestamp( amendedFinding.getCreatedTimestamp() );
        amendedFindingDTO.setModifiedTimestamp( amendedFinding.getModifiedTimestamp() );
        amendedFindingDTO.setFindingBeforeAmendment( amendedFinding.getFindingBeforeAmendment() );
        amendedFindingDTO.setAmendedBy( auditStaffToAuditStaffDTO( amendedFinding.getAmendedBy() ) );

        return amendedFindingDTO;
    }

    @Override
    public void copyToDTO(AmendedFinding amendedFinding, AmendedFindingDTO amendedFindingDTO) {
        if ( amendedFinding == null ) {
            return;
        }

        amendedFindingDTO.setId( amendedFinding.getId() );
        amendedFindingDTO.setCreatedUser( amendedFinding.getCreatedUser() );
        amendedFindingDTO.setModifiedUser( amendedFinding.getModifiedUser() );
        amendedFindingDTO.setCreatedTimestamp( amendedFinding.getCreatedTimestamp() );
        amendedFindingDTO.setModifiedTimestamp( amendedFinding.getModifiedTimestamp() );
        amendedFindingDTO.setFindingBeforeAmendment( amendedFinding.getFindingBeforeAmendment() );
        if ( amendedFinding.getAmendedBy() != null ) {
            if ( amendedFindingDTO.getAmendedBy() == null ) {
                amendedFindingDTO.setAmendedBy( new AuditStaffDTO() );
            }
            auditStaffToAuditStaffDTO1( amendedFinding.getAmendedBy(), amendedFindingDTO.getAmendedBy() );
        }
        else {
            amendedFindingDTO.setAmendedBy( null );
        }
    }

    @Override
    public AmendedFinding toEntity(AmendedFindingDTO amendedFindingDTO) {
        if ( amendedFindingDTO == null ) {
            return null;
        }

        AmendedFinding amendedFinding = new AmendedFinding();

        amendedFinding.setId( amendedFindingDTO.getId() );
        amendedFinding.setCreatedUser( amendedFindingDTO.getCreatedUser() );
        amendedFinding.setModifiedUser( amendedFindingDTO.getModifiedUser() );
        amendedFinding.setCreatedTimestamp( amendedFindingDTO.getCreatedTimestamp() );
        amendedFinding.setModifiedTimestamp( amendedFindingDTO.getModifiedTimestamp() );
        amendedFinding.setFindingBeforeAmendment( amendedFindingDTO.getFindingBeforeAmendment() );
        amendedFinding.setAmendedBy( auditStaffDTOToAuditStaff( amendedFindingDTO.getAmendedBy() ) );

        return amendedFinding;
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

    protected AuditStaffDTO auditStaffToAuditStaffDTO(AuditStaff auditStaff) {
        if ( auditStaff == null ) {
            return null;
        }

        AuditStaffDTO auditStaffDTO = new AuditStaffDTO();

        auditStaffDTO.setId( auditStaff.getId() );
        auditStaffDTO.setCreatedUser( auditStaff.getCreatedUser() );
        auditStaffDTO.setModifiedUser( auditStaff.getModifiedUser() );
        auditStaffDTO.setCreatedTimestamp( auditStaff.getCreatedTimestamp() );
        auditStaffDTO.setModifiedTimestamp( auditStaff.getModifiedTimestamp() );
        auditStaffDTO.setAuditType( auditTypeToAuditTypeDTO( auditStaff.getAuditType() ) );
        auditStaffDTO.setEmployeeId( auditStaff.getEmployeeId() );
        auditStaffDTO.setFullName( auditStaff.getFullName() );
        auditStaffDTO.setStatus( auditStaff.getStatus() );

        return auditStaffDTO;
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

    protected void auditStaffToAuditStaffDTO1(AuditStaff auditStaff, AuditStaffDTO mappingTarget) {
        if ( auditStaff == null ) {
            return;
        }

        mappingTarget.setId( auditStaff.getId() );
        mappingTarget.setCreatedUser( auditStaff.getCreatedUser() );
        mappingTarget.setModifiedUser( auditStaff.getModifiedUser() );
        mappingTarget.setCreatedTimestamp( auditStaff.getCreatedTimestamp() );
        mappingTarget.setModifiedTimestamp( auditStaff.getModifiedTimestamp() );
        if ( auditStaff.getAuditType() != null ) {
            if ( mappingTarget.getAuditType() == null ) {
                mappingTarget.setAuditType( new AuditTypeDTO() );
            }
            auditTypeToAuditTypeDTO1( auditStaff.getAuditType(), mappingTarget.getAuditType() );
        }
        else {
            mappingTarget.setAuditType( null );
        }
        mappingTarget.setEmployeeId( auditStaff.getEmployeeId() );
        mappingTarget.setFullName( auditStaff.getFullName() );
        mappingTarget.setStatus( auditStaff.getStatus() );
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

    protected AuditStaff auditStaffDTOToAuditStaff(AuditStaffDTO auditStaffDTO) {
        if ( auditStaffDTO == null ) {
            return null;
        }

        AuditStaff auditStaff = new AuditStaff();

        auditStaff.setId( auditStaffDTO.getId() );
        auditStaff.setCreatedUser( auditStaffDTO.getCreatedUser() );
        auditStaff.setModifiedUser( auditStaffDTO.getModifiedUser() );
        auditStaff.setCreatedTimestamp( auditStaffDTO.getCreatedTimestamp() );
        auditStaff.setModifiedTimestamp( auditStaffDTO.getModifiedTimestamp() );
        auditStaff.setAuditType( auditTypeDTOToAuditType( auditStaffDTO.getAuditType() ) );
        auditStaff.setEmployeeId( auditStaffDTO.getEmployeeId() );
        auditStaff.setFullName( auditStaffDTO.getFullName() );
        auditStaff.setStatus( auditStaffDTO.getStatus() );

        return auditStaff;
    }
}
