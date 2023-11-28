package com.cbo.audit.mapper;

import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.AuditObjectDTO;
import com.cbo.audit.dto.AuditProgramDTO;
import com.cbo.audit.dto.AuditProgramWBSDTO;
import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.dto.AuditUniverseDTO;
import com.cbo.audit.dto.TeamMemberDTO;
import com.cbo.audit.persistence.model.AnnualPlan;
import com.cbo.audit.persistence.model.AuditObject;
import com.cbo.audit.persistence.model.AuditProgram;
import com.cbo.audit.persistence.model.AuditSchedule;
import com.cbo.audit.persistence.model.AuditUniverse;
import com.cbo.audit.persistence.model.TeamMember;
import com.cbo.audit.persistence.model.WBS;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-27T15:46:35+0300",
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

    protected TeamMemberDTO teamMemberToTeamMemberDTO(TeamMember teamMember) {
        if ( teamMember == null ) {
            return null;
        }

        TeamMemberDTO teamMemberDTO = new TeamMemberDTO();

        teamMemberDTO.setId( teamMember.getId() );
        teamMemberDTO.setCreatedUser( teamMember.getCreatedUser() );
        teamMemberDTO.setModifiedUser( teamMember.getModifiedUser() );
        teamMemberDTO.setCreatedTimestamp( teamMember.getCreatedTimestamp() );
        teamMemberDTO.setModifiedTimestamp( teamMember.getModifiedTimestamp() );
        teamMemberDTO.setStatus( teamMember.getStatus() );
        teamMemberDTO.setTeamRole( teamMember.getTeamRole() );
        teamMemberDTO.setAuditStatus( teamMember.getAuditStatus() );
        teamMemberDTO.setPerdium( teamMember.getPerdium() );

        return teamMemberDTO;
    }

    protected List<TeamMemberDTO> teamMemberListToTeamMemberDTOList(List<TeamMember> list) {
        if ( list == null ) {
            return null;
        }

        List<TeamMemberDTO> list1 = new ArrayList<TeamMemberDTO>( list.size() );
        for ( TeamMember teamMember : list ) {
            list1.add( teamMemberToTeamMemberDTO( teamMember ) );
        }

        return list1;
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

    protected AnnualPlanDTO annualPlanToAnnualPlanDTO(AnnualPlan annualPlan) {
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

    protected AuditScheduleDTO auditScheduleToAuditScheduleDTO(AuditSchedule auditSchedule) {
        if ( auditSchedule == null ) {
            return null;
        }

        AuditScheduleDTO auditScheduleDTO = new AuditScheduleDTO();

        auditScheduleDTO.setId( auditSchedule.getId() );
        auditScheduleDTO.setCreatedUser( auditSchedule.getCreatedUser() );
        auditScheduleDTO.setModifiedUser( auditSchedule.getModifiedUser() );
        auditScheduleDTO.setCreatedTimestamp( auditSchedule.getCreatedTimestamp() );
        auditScheduleDTO.setModifiedTimestamp( auditSchedule.getModifiedTimestamp() );
        auditScheduleDTO.setStartOn( auditSchedule.getStartOn() );
        auditScheduleDTO.setEndOn( auditSchedule.getEndOn() );
        auditScheduleDTO.setStatus( auditSchedule.getStatus() );
        auditScheduleDTO.setQuarter( auditSchedule.getQuarter() );
        auditScheduleDTO.setAuditeesOrganID( auditSchedule.getAuditeesOrganID() );
        auditScheduleDTO.setDateCompleted( auditSchedule.getDateCompleted() );
        auditScheduleDTO.setTotalCost( auditSchedule.getTotalCost() );
        auditScheduleDTO.setInvolvesTravel( auditSchedule.isInvolvesTravel() );
        auditScheduleDTO.setTeamMembers( teamMemberListToTeamMemberDTOList( auditSchedule.getTeamMembers() ) );
        auditScheduleDTO.setAnnualPlan( annualPlanToAnnualPlanDTO( auditSchedule.getAnnualPlan() ) );

        return auditScheduleDTO;
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
        auditProgramDTO.setAuditSchedule( auditScheduleToAuditScheduleDTO( auditProgram.getAuditSchedule() ) );

        return auditProgramDTO;
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

    protected void annualPlanToAnnualPlanDTO1(AnnualPlan annualPlan, AnnualPlanDTO mappingTarget) {
        if ( annualPlan == null ) {
            return;
        }

        mappingTarget.setId( annualPlan.getId() );
        mappingTarget.setCreatedUser( annualPlan.getCreatedUser() );
        mappingTarget.setModifiedUser( annualPlan.getModifiedUser() );
        mappingTarget.setCreatedTimestamp( annualPlan.getCreatedTimestamp() );
        mappingTarget.setModifiedTimestamp( annualPlan.getModifiedTimestamp() );
        mappingTarget.setName( annualPlan.getName() );
        mappingTarget.setDescription( annualPlan.getDescription() );
        mappingTarget.setYear( annualPlan.getYear() );
        mappingTarget.setRiskLevel( annualPlan.getRiskLevel() );
        mappingTarget.setRiskScore( annualPlan.getRiskScore() );
        mappingTarget.setStatus( annualPlan.getStatus() );
        mappingTarget.setRectificationStatus( annualPlan.getRectificationStatus() );
        if ( annualPlan.getAuditUniverse() != null ) {
            if ( mappingTarget.getAuditUniverse() == null ) {
                mappingTarget.setAuditUniverse( new AuditUniverseDTO() );
            }
            auditUniverseToAuditUniverseDTO1( annualPlan.getAuditUniverse(), mappingTarget.getAuditUniverse() );
        }
        else {
            mappingTarget.setAuditUniverse( null );
        }
    }

    protected void auditScheduleToAuditScheduleDTO1(AuditSchedule auditSchedule, AuditScheduleDTO mappingTarget) {
        if ( auditSchedule == null ) {
            return;
        }

        mappingTarget.setId( auditSchedule.getId() );
        mappingTarget.setCreatedUser( auditSchedule.getCreatedUser() );
        mappingTarget.setModifiedUser( auditSchedule.getModifiedUser() );
        mappingTarget.setCreatedTimestamp( auditSchedule.getCreatedTimestamp() );
        mappingTarget.setModifiedTimestamp( auditSchedule.getModifiedTimestamp() );
        mappingTarget.setStartOn( auditSchedule.getStartOn() );
        mappingTarget.setEndOn( auditSchedule.getEndOn() );
        mappingTarget.setStatus( auditSchedule.getStatus() );
        mappingTarget.setQuarter( auditSchedule.getQuarter() );
        mappingTarget.setAuditeesOrganID( auditSchedule.getAuditeesOrganID() );
        mappingTarget.setDateCompleted( auditSchedule.getDateCompleted() );
        mappingTarget.setTotalCost( auditSchedule.getTotalCost() );
        mappingTarget.setInvolvesTravel( auditSchedule.isInvolvesTravel() );
        if ( mappingTarget.getTeamMembers() != null ) {
            List<TeamMemberDTO> list = teamMemberListToTeamMemberDTOList( auditSchedule.getTeamMembers() );
            if ( list != null ) {
                mappingTarget.getTeamMembers().clear();
                mappingTarget.getTeamMembers().addAll( list );
            }
            else {
                mappingTarget.setTeamMembers( null );
            }
        }
        else {
            List<TeamMemberDTO> list = teamMemberListToTeamMemberDTOList( auditSchedule.getTeamMembers() );
            if ( list != null ) {
                mappingTarget.setTeamMembers( list );
            }
        }
        if ( auditSchedule.getAnnualPlan() != null ) {
            if ( mappingTarget.getAnnualPlan() == null ) {
                mappingTarget.setAnnualPlan( new AnnualPlanDTO() );
            }
            annualPlanToAnnualPlanDTO1( auditSchedule.getAnnualPlan(), mappingTarget.getAnnualPlan() );
        }
        else {
            mappingTarget.setAnnualPlan( null );
        }
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
        if ( auditProgram.getAuditSchedule() != null ) {
            if ( mappingTarget.getAuditSchedule() == null ) {
                mappingTarget.setAuditSchedule( new AuditScheduleDTO() );
            }
            auditScheduleToAuditScheduleDTO1( auditProgram.getAuditSchedule(), mappingTarget.getAuditSchedule() );
        }
        else {
            mappingTarget.setAuditSchedule( null );
        }
    }

    protected TeamMember teamMemberDTOToTeamMember(TeamMemberDTO teamMemberDTO) {
        if ( teamMemberDTO == null ) {
            return null;
        }

        TeamMember teamMember = new TeamMember();

        teamMember.setId( teamMemberDTO.getId() );
        teamMember.setCreatedUser( teamMemberDTO.getCreatedUser() );
        teamMember.setModifiedUser( teamMemberDTO.getModifiedUser() );
        teamMember.setCreatedTimestamp( teamMemberDTO.getCreatedTimestamp() );
        teamMember.setModifiedTimestamp( teamMemberDTO.getModifiedTimestamp() );
        teamMember.setStatus( teamMemberDTO.getStatus() );
        teamMember.setTeamRole( teamMemberDTO.getTeamRole() );
        teamMember.setAuditStatus( teamMemberDTO.getAuditStatus() );
        teamMember.setPerdium( teamMemberDTO.getPerdium() );

        return teamMember;
    }

    protected List<TeamMember> teamMemberDTOListToTeamMemberList(List<TeamMemberDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<TeamMember> list1 = new ArrayList<TeamMember>( list.size() );
        for ( TeamMemberDTO teamMemberDTO : list ) {
            list1.add( teamMemberDTOToTeamMember( teamMemberDTO ) );
        }

        return list1;
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

    protected AnnualPlan annualPlanDTOToAnnualPlan(AnnualPlanDTO annualPlanDTO) {
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

    protected AuditSchedule auditScheduleDTOToAuditSchedule(AuditScheduleDTO auditScheduleDTO) {
        if ( auditScheduleDTO == null ) {
            return null;
        }

        AuditSchedule auditSchedule = new AuditSchedule();

        auditSchedule.setId( auditScheduleDTO.getId() );
        auditSchedule.setCreatedUser( auditScheduleDTO.getCreatedUser() );
        auditSchedule.setModifiedUser( auditScheduleDTO.getModifiedUser() );
        auditSchedule.setCreatedTimestamp( auditScheduleDTO.getCreatedTimestamp() );
        auditSchedule.setModifiedTimestamp( auditScheduleDTO.getModifiedTimestamp() );
        auditSchedule.setStartOn( auditScheduleDTO.getStartOn() );
        auditSchedule.setEndOn( auditScheduleDTO.getEndOn() );
        auditSchedule.setStatus( auditScheduleDTO.getStatus() );
        auditSchedule.setQuarter( auditScheduleDTO.getQuarter() );
        auditSchedule.setAuditeesOrganID( auditScheduleDTO.getAuditeesOrganID() );
        auditSchedule.setDateCompleted( auditScheduleDTO.getDateCompleted() );
        auditSchedule.setTotalCost( auditScheduleDTO.getTotalCost() );
        auditSchedule.setInvolvesTravel( auditScheduleDTO.isInvolvesTravel() );
        auditSchedule.setTeamMembers( teamMemberDTOListToTeamMemberList( auditScheduleDTO.getTeamMembers() ) );
        auditSchedule.setAnnualPlan( annualPlanDTOToAnnualPlan( auditScheduleDTO.getAnnualPlan() ) );

        return auditSchedule;
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
        auditProgram.setAuditSchedule( auditScheduleDTOToAuditSchedule( auditProgramDTO.getAuditSchedule() ) );

        return auditProgram;
    }
}
