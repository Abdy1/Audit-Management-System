package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditProgramDTO;
import com.cbo.audit.dto.AuditProgramWBSDTO;
import com.cbo.audit.persistence.model.AuditProgram;
import com.cbo.audit.persistence.model.WBS;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-30T09:57:20+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class WBSMapperImpl implements WBSMapper {

    @Override
    public AuditProgramWBSDTO toDTO(WBS wbs) {
        if ( wbs == null ) {
            return null;
        }

        AuditProgramWBSDTO auditProgramWBSDTO = new AuditProgramWBSDTO();

        auditProgramWBSDTO.setId( wbs.getId() );
        auditProgramWBSDTO.setCreatedUser( wbs.getCreatedUser() );
        auditProgramWBSDTO.setModifiedUser( wbs.getModifiedUser() );
        auditProgramWBSDTO.setCreatedTimestamp( wbs.getCreatedTimestamp() );
        auditProgramWBSDTO.setModifiedTimestamp( wbs.getModifiedTimestamp() );
        auditProgramWBSDTO.setName( wbs.getName() );
        auditProgramWBSDTO.setDescription( wbs.getDescription() );
        auditProgramWBSDTO.setAuditProgram( auditProgramToAuditProgramDTO( wbs.getAuditProgram() ) );
        auditProgramWBSDTO.setStatus( wbs.getStatus() );
        auditProgramWBSDTO.setStartOn( wbs.getStartOn() );
        auditProgramWBSDTO.setEndOn( wbs.getEndOn() );
        auditProgramWBSDTO.setNumberOfDays( wbs.getNumberOfDays() );

        return auditProgramWBSDTO;
    }

    @Override
    public void copyToDTO(WBS wbs, AuditProgramWBSDTO auditProgramWBSDTO) {
        if ( wbs == null ) {
            return;
        }

        auditProgramWBSDTO.setId( wbs.getId() );
        auditProgramWBSDTO.setCreatedUser( wbs.getCreatedUser() );
        auditProgramWBSDTO.setModifiedUser( wbs.getModifiedUser() );
        auditProgramWBSDTO.setCreatedTimestamp( wbs.getCreatedTimestamp() );
        auditProgramWBSDTO.setModifiedTimestamp( wbs.getModifiedTimestamp() );
        auditProgramWBSDTO.setName( wbs.getName() );
        auditProgramWBSDTO.setDescription( wbs.getDescription() );
        if ( wbs.getAuditProgram() != null ) {
            if ( auditProgramWBSDTO.getAuditProgram() == null ) {
                auditProgramWBSDTO.setAuditProgram( new AuditProgramDTO() );
            }
            auditProgramToAuditProgramDTO1( wbs.getAuditProgram(), auditProgramWBSDTO.getAuditProgram() );
        }
        else {
            auditProgramWBSDTO.setAuditProgram( null );
        }
        auditProgramWBSDTO.setStatus( wbs.getStatus() );
        auditProgramWBSDTO.setStartOn( wbs.getStartOn() );
        auditProgramWBSDTO.setEndOn( wbs.getEndOn() );
        auditProgramWBSDTO.setNumberOfDays( wbs.getNumberOfDays() );
    }

    @Override
    public WBS toEntity(AuditProgramWBSDTO auditProgramWBSDTO) {
        if ( auditProgramWBSDTO == null ) {
            return null;
        }

        WBS wBS = new WBS();

        wBS.setId( auditProgramWBSDTO.getId() );
        wBS.setCreatedUser( auditProgramWBSDTO.getCreatedUser() );
        wBS.setModifiedUser( auditProgramWBSDTO.getModifiedUser() );
        wBS.setCreatedTimestamp( auditProgramWBSDTO.getCreatedTimestamp() );
        wBS.setModifiedTimestamp( auditProgramWBSDTO.getModifiedTimestamp() );
        wBS.setName( auditProgramWBSDTO.getName() );
        wBS.setDescription( auditProgramWBSDTO.getDescription() );
        wBS.setAuditProgram( auditProgramDTOToAuditProgram( auditProgramWBSDTO.getAuditProgram() ) );
        wBS.setStatus( auditProgramWBSDTO.getStatus() );
        wBS.setStartOn( auditProgramWBSDTO.getStartOn() );
        wBS.setEndOn( auditProgramWBSDTO.getEndOn() );
        wBS.setNumberOfDays( auditProgramWBSDTO.getNumberOfDays() );

        return wBS;
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
