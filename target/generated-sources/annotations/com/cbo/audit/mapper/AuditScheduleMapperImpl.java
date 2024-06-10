package com.cbo.audit.mapper;

import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.AuditObjectDTO;
import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.dto.AuditTypeDTO;
import com.cbo.audit.dto.RiskItemDTO;
import com.cbo.audit.dto.RiskScoreDTO;
import com.cbo.audit.dto.TeamMemberDTO;
import com.cbo.audit.persistence.model.AnnualPlan;
import com.cbo.audit.persistence.model.AuditObject;
import com.cbo.audit.persistence.model.AuditSchedule;
import com.cbo.audit.persistence.model.AuditType;
import com.cbo.audit.persistence.model.RiskItem;
import com.cbo.audit.persistence.model.RiskScore;
import com.cbo.audit.persistence.model.TeamMember;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-07T14:41:02+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class AuditScheduleMapperImpl implements AuditScheduleMapper {

    @Override
    public AuditScheduleDTO toDTO(AuditSchedule auditSchedule) {
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

    @Override
    public void copyToDTO(AuditSchedule auditSchedule, AuditScheduleDTO auditScheduleDTO) {
        if ( auditSchedule == null ) {
            return;
        }

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
        if ( auditScheduleDTO.getTeamMembers() != null ) {
            List<TeamMemberDTO> list = teamMemberListToTeamMemberDTOList( auditSchedule.getTeamMembers() );
            if ( list != null ) {
                auditScheduleDTO.getTeamMembers().clear();
                auditScheduleDTO.getTeamMembers().addAll( list );
            }
            else {
                auditScheduleDTO.setTeamMembers( null );
            }
        }
        else {
            List<TeamMemberDTO> list = teamMemberListToTeamMemberDTOList( auditSchedule.getTeamMembers() );
            if ( list != null ) {
                auditScheduleDTO.setTeamMembers( list );
            }
        }
        if ( auditSchedule.getAnnualPlan() != null ) {
            if ( auditScheduleDTO.getAnnualPlan() == null ) {
                auditScheduleDTO.setAnnualPlan( new AnnualPlanDTO() );
            }
            annualPlanToAnnualPlanDTO1( auditSchedule.getAnnualPlan(), auditScheduleDTO.getAnnualPlan() );
        }
        else {
            auditScheduleDTO.setAnnualPlan( null );
        }
    }

    @Override
    public AuditSchedule toEntity(AuditScheduleDTO auditScheduleDTO) {
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

    protected RiskItemDTO riskItemToRiskItemDTO(RiskItem riskItem) {
        if ( riskItem == null ) {
            return null;
        }

        RiskItemDTO riskItemDTO = new RiskItemDTO();

        riskItemDTO.setId( riskItem.getId() );
        riskItemDTO.setCreatedUser( riskItem.getCreatedUser() );
        riskItemDTO.setModifiedUser( riskItem.getModifiedUser() );
        riskItemDTO.setCreatedTimestamp( riskItem.getCreatedTimestamp() );
        riskItemDTO.setModifiedTimestamp( riskItem.getModifiedTimestamp() );
        riskItemDTO.setName( riskItem.getName() );
        riskItemDTO.setStrategicObjectiveLink( riskItem.getStrategicObjectiveLink() );
        riskItemDTO.setAuditType( riskItem.getAuditType() );

        return riskItemDTO;
    }

    protected RiskScoreDTO riskScoreToRiskScoreDTO(RiskScore riskScore) {
        if ( riskScore == null ) {
            return null;
        }

        RiskScoreDTO riskScoreDTO = new RiskScoreDTO();

        riskScoreDTO.setId( riskScore.getId() );
        riskScoreDTO.setCreatedUser( riskScore.getCreatedUser() );
        riskScoreDTO.setModifiedUser( riskScore.getModifiedUser() );
        riskScoreDTO.setCreatedTimestamp( riskScore.getCreatedTimestamp() );
        riskScoreDTO.setModifiedTimestamp( riskScore.getModifiedTimestamp() );
        riskScoreDTO.setRiskItem( riskItemToRiskItemDTO( riskScore.getRiskItem() ) );
        riskScoreDTO.setLikelihood( riskScore.getLikelihood() );
        riskScoreDTO.setImpact( riskScore.getImpact() );
        riskScoreDTO.setTotal( riskScore.getTotal() );
        riskScoreDTO.setPercentage( riskScore.getPercentage() );
        riskScoreDTO.setWaited( riskScore.isWaited() );

        return riskScoreDTO;
    }

    protected List<RiskScoreDTO> riskScoreListToRiskScoreDTOList(List<RiskScore> list) {
        if ( list == null ) {
            return null;
        }

        List<RiskScoreDTO> list1 = new ArrayList<RiskScoreDTO>( list.size() );
        for ( RiskScore riskScore : list ) {
            list1.add( riskScoreToRiskScoreDTO( riskScore ) );
        }

        return list1;
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
        annualPlanDTO.setYear( annualPlan.getYear() );
        annualPlanDTO.setRiskLevel( annualPlan.getRiskLevel() );
        annualPlanDTO.setRiskScore( annualPlan.getRiskScore() );
        annualPlanDTO.setStatus( annualPlan.getStatus() );
        annualPlanDTO.setRectificationStatus( annualPlan.getRectificationStatus() );
        annualPlanDTO.setAuditObject( auditObjectToAuditObjectDTO( annualPlan.getAuditObject() ) );
        annualPlanDTO.setRiskScores( riskScoreListToRiskScoreDTOList( annualPlan.getRiskScores() ) );

        return annualPlanDTO;
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

    protected void annualPlanToAnnualPlanDTO1(AnnualPlan annualPlan, AnnualPlanDTO mappingTarget) {
        if ( annualPlan == null ) {
            return;
        }

        mappingTarget.setId( annualPlan.getId() );
        mappingTarget.setCreatedUser( annualPlan.getCreatedUser() );
        mappingTarget.setModifiedUser( annualPlan.getModifiedUser() );
        mappingTarget.setCreatedTimestamp( annualPlan.getCreatedTimestamp() );
        mappingTarget.setModifiedTimestamp( annualPlan.getModifiedTimestamp() );
        mappingTarget.setYear( annualPlan.getYear() );
        mappingTarget.setRiskLevel( annualPlan.getRiskLevel() );
        mappingTarget.setRiskScore( annualPlan.getRiskScore() );
        mappingTarget.setStatus( annualPlan.getStatus() );
        mappingTarget.setRectificationStatus( annualPlan.getRectificationStatus() );
        if ( annualPlan.getAuditObject() != null ) {
            if ( mappingTarget.getAuditObject() == null ) {
                mappingTarget.setAuditObject( new AuditObjectDTO() );
            }
            auditObjectToAuditObjectDTO1( annualPlan.getAuditObject(), mappingTarget.getAuditObject() );
        }
        else {
            mappingTarget.setAuditObject( null );
        }
        if ( mappingTarget.getRiskScores() != null ) {
            List<RiskScoreDTO> list = riskScoreListToRiskScoreDTOList( annualPlan.getRiskScores() );
            if ( list != null ) {
                mappingTarget.getRiskScores().clear();
                mappingTarget.getRiskScores().addAll( list );
            }
            else {
                mappingTarget.setRiskScores( null );
            }
        }
        else {
            List<RiskScoreDTO> list = riskScoreListToRiskScoreDTOList( annualPlan.getRiskScores() );
            if ( list != null ) {
                mappingTarget.setRiskScores( list );
            }
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

    protected RiskItem riskItemDTOToRiskItem(RiskItemDTO riskItemDTO) {
        if ( riskItemDTO == null ) {
            return null;
        }

        RiskItem riskItem = new RiskItem();

        riskItem.setId( riskItemDTO.getId() );
        riskItem.setCreatedUser( riskItemDTO.getCreatedUser() );
        riskItem.setModifiedUser( riskItemDTO.getModifiedUser() );
        riskItem.setCreatedTimestamp( riskItemDTO.getCreatedTimestamp() );
        riskItem.setModifiedTimestamp( riskItemDTO.getModifiedTimestamp() );
        riskItem.setName( riskItemDTO.getName() );
        riskItem.setStrategicObjectiveLink( riskItemDTO.getStrategicObjectiveLink() );
        riskItem.setAuditType( riskItemDTO.getAuditType() );

        return riskItem;
    }

    protected RiskScore riskScoreDTOToRiskScore(RiskScoreDTO riskScoreDTO) {
        if ( riskScoreDTO == null ) {
            return null;
        }

        RiskScore riskScore = new RiskScore();

        riskScore.setId( riskScoreDTO.getId() );
        riskScore.setCreatedUser( riskScoreDTO.getCreatedUser() );
        riskScore.setModifiedUser( riskScoreDTO.getModifiedUser() );
        riskScore.setCreatedTimestamp( riskScoreDTO.getCreatedTimestamp() );
        riskScore.setModifiedTimestamp( riskScoreDTO.getModifiedTimestamp() );
        riskScore.setRiskItem( riskItemDTOToRiskItem( riskScoreDTO.getRiskItem() ) );
        riskScore.setLikelihood( riskScoreDTO.getLikelihood() );
        riskScore.setImpact( riskScoreDTO.getImpact() );
        riskScore.setPercentage( riskScoreDTO.getPercentage() );
        riskScore.setWaited( riskScoreDTO.isWaited() );
        riskScore.setTotal( riskScoreDTO.getTotal() );

        return riskScore;
    }

    protected List<RiskScore> riskScoreDTOListToRiskScoreList(List<RiskScoreDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<RiskScore> list1 = new ArrayList<RiskScore>( list.size() );
        for ( RiskScoreDTO riskScoreDTO : list ) {
            list1.add( riskScoreDTOToRiskScore( riskScoreDTO ) );
        }

        return list1;
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
        annualPlan.setYear( annualPlanDTO.getYear() );
        annualPlan.setRiskLevel( annualPlanDTO.getRiskLevel() );
        annualPlan.setRiskScore( annualPlanDTO.getRiskScore() );
        annualPlan.setStatus( annualPlanDTO.getStatus() );
        annualPlan.setRectificationStatus( annualPlanDTO.getRectificationStatus() );
        annualPlan.setAuditObject( auditObjectDTOToAuditObject( annualPlanDTO.getAuditObject() ) );
        annualPlan.setRiskScores( riskScoreDTOListToRiskScoreList( annualPlanDTO.getRiskScores() ) );

        return annualPlan;
    }
}
