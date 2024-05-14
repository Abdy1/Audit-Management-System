package com.cbo.audit.mapper;

import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.AuditObjectDTO;
import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.dto.AuditUniverseDTO;
import com.cbo.audit.dto.ResourceDTO;
import com.cbo.audit.dto.TeamMemberDTO;
import com.cbo.audit.persistence.model.AnnualPlan;
import com.cbo.audit.persistence.model.AuditObject;
import com.cbo.audit.persistence.model.AuditSchedule;
import com.cbo.audit.persistence.model.AuditUniverse;
import com.cbo.audit.persistence.model.Resource;
import com.cbo.audit.persistence.model.TeamMember;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-13T16:18:16+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class ResourceMapperImpl implements ResourceMapper {

    @Override
    public ResourceDTO toDTO(Resource resource) {
        if ( resource == null ) {
            return null;
        }

        ResourceDTO resourceDTO = new ResourceDTO();

        resourceDTO.setId( resource.getId() );
        resourceDTO.setCreatedUser( resource.getCreatedUser() );
        resourceDTO.setModifiedUser( resource.getModifiedUser() );
        resourceDTO.setCreatedTimestamp( resource.getCreatedTimestamp() );
        resourceDTO.setModifiedTimestamp( resource.getModifiedTimestamp() );
        resourceDTO.setName( resource.getName() );
        resourceDTO.setQuantity( resource.getQuantity() );
        resourceDTO.setResourceType( resource.getResourceType() );
        resourceDTO.setResourceStatus( resource.getResourceStatus() );
        resourceDTO.setAuditSchedule( auditScheduleToAuditScheduleDTO( resource.getAuditSchedule() ) );

        return resourceDTO;
    }

    @Override
    public void copyToDTO(Resource resource, ResourceDTO resourceDTO) {
        if ( resource == null ) {
            return;
        }

        resourceDTO.setId( resource.getId() );
        resourceDTO.setCreatedUser( resource.getCreatedUser() );
        resourceDTO.setModifiedUser( resource.getModifiedUser() );
        resourceDTO.setCreatedTimestamp( resource.getCreatedTimestamp() );
        resourceDTO.setModifiedTimestamp( resource.getModifiedTimestamp() );
        resourceDTO.setName( resource.getName() );
        resourceDTO.setQuantity( resource.getQuantity() );
        resourceDTO.setResourceType( resource.getResourceType() );
        resourceDTO.setResourceStatus( resource.getResourceStatus() );
        if ( resource.getAuditSchedule() != null ) {
            if ( resourceDTO.getAuditSchedule() == null ) {
                resourceDTO.setAuditSchedule( new AuditScheduleDTO() );
            }
            auditScheduleToAuditScheduleDTO1( resource.getAuditSchedule(), resourceDTO.getAuditSchedule() );
        }
        else {
            resourceDTO.setAuditSchedule( null );
        }
    }

    @Override
    public Resource toEntity(ResourceDTO resourceDTO) {
        if ( resourceDTO == null ) {
            return null;
        }

        Resource resource = new Resource();

        resource.setId( resourceDTO.getId() );
        resource.setCreatedUser( resourceDTO.getCreatedUser() );
        resource.setModifiedUser( resourceDTO.getModifiedUser() );
        resource.setCreatedTimestamp( resourceDTO.getCreatedTimestamp() );
        resource.setModifiedTimestamp( resourceDTO.getModifiedTimestamp() );
        resource.setName( resourceDTO.getName() );
        resource.setQuantity( resourceDTO.getQuantity() );
        resource.setResourceType( resourceDTO.getResourceType() );
        resource.setResourceStatus( resourceDTO.getResourceStatus() );
        resource.setAuditSchedule( auditScheduleDTOToAuditSchedule( resourceDTO.getAuditSchedule() ) );

        return resource;
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

        return auditUniverseDTO;
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
        auditObjectDTO.setStatus( auditObject.getStatus() );
        auditObjectDTO.setAuditUniverse( auditObject.getAuditUniverse() );

        return auditObjectDTO;
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
        annualPlanDTO.setAuditObject( auditObjectToAuditObjectDTO( annualPlan.getAuditObject() ) );

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
        mappingTarget.setStatus( auditObject.getStatus() );
        mappingTarget.setAuditUniverse( auditObject.getAuditUniverse() );
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
        if ( annualPlan.getAuditObject() != null ) {
            if ( mappingTarget.getAuditObject() == null ) {
                mappingTarget.setAuditObject( new AuditObjectDTO() );
            }
            auditObjectToAuditObjectDTO1( annualPlan.getAuditObject(), mappingTarget.getAuditObject() );
        }
        else {
            mappingTarget.setAuditObject( null );
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

        return auditUniverse;
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
        auditObject.setStatus( auditObjectDTO.getStatus() );
        auditObject.setAuditUniverse( auditObjectDTO.getAuditUniverse() );

        return auditObject;
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
        annualPlan.setAuditObject( auditObjectDTOToAuditObject( annualPlanDTO.getAuditObject() ) );

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
}
