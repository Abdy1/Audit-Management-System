package com.cbo.audit.mapper;

import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.AuditObjectDTO;
import com.cbo.audit.dto.AuditProgramDTO;
import com.cbo.audit.dto.AuditProgramObjectiveDTO;
import com.cbo.audit.dto.AuditProgramWBSDTO;
import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.dto.AuditTypeDTO;
import com.cbo.audit.dto.EngagementDTO;
import com.cbo.audit.dto.RiskItemDTO;
import com.cbo.audit.dto.RiskScoreDTO;
import com.cbo.audit.dto.TeamMemberDTO;
import com.cbo.audit.persistence.model.AnnualPlan;
import com.cbo.audit.persistence.model.AuditObject;
import com.cbo.audit.persistence.model.AuditProgram;
import com.cbo.audit.persistence.model.AuditProgramObjective;
import com.cbo.audit.persistence.model.AuditSchedule;
import com.cbo.audit.persistence.model.AuditType;
import com.cbo.audit.persistence.model.EngagementInfo;
import com.cbo.audit.persistence.model.RiskItem;
import com.cbo.audit.persistence.model.RiskScore;
import com.cbo.audit.persistence.model.TeamMember;
import com.cbo.audit.persistence.model.WBS;
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

    protected AuditProgramObjectiveDTO auditProgramObjectiveToAuditProgramObjectiveDTO(AuditProgramObjective auditProgramObjective) {
        if ( auditProgramObjective == null ) {
            return null;
        }

        AuditProgramObjectiveDTO auditProgramObjectiveDTO = new AuditProgramObjectiveDTO();

        auditProgramObjectiveDTO.setId( auditProgramObjective.getId() );
        auditProgramObjectiveDTO.setCreatedUser( auditProgramObjective.getCreatedUser() );
        auditProgramObjectiveDTO.setModifiedUser( auditProgramObjective.getModifiedUser() );
        auditProgramObjectiveDTO.setCreatedTimestamp( auditProgramObjective.getCreatedTimestamp() );
        auditProgramObjectiveDTO.setModifiedTimestamp( auditProgramObjective.getModifiedTimestamp() );
        auditProgramObjectiveDTO.setDescription( auditProgramObjective.getDescription() );

        return auditProgramObjectiveDTO;
    }

    protected List<AuditProgramObjectiveDTO> auditProgramObjectiveListToAuditProgramObjectiveDTOList(List<AuditProgramObjective> list) {
        if ( list == null ) {
            return null;
        }

        List<AuditProgramObjectiveDTO> list1 = new ArrayList<AuditProgramObjectiveDTO>( list.size() );
        for ( AuditProgramObjective auditProgramObjective : list ) {
            list1.add( auditProgramObjectiveToAuditProgramObjectiveDTO( auditProgramObjective ) );
        }

        return list1;
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

    protected EngagementDTO engagementInfoToEngagementDTO(EngagementInfo engagementInfo) {
        if ( engagementInfo == null ) {
            return null;
        }

        EngagementDTO engagementDTO = new EngagementDTO();

        engagementDTO.setId( engagementInfo.getId() );
        engagementDTO.setCreatedUser( engagementInfo.getCreatedUser() );
        engagementDTO.setModifiedUser( engagementInfo.getModifiedUser() );
        engagementDTO.setCreatedTimestamp( engagementInfo.getCreatedTimestamp() );
        engagementDTO.setModifiedTimestamp( engagementInfo.getModifiedTimestamp() );
        engagementDTO.setMessage( engagementInfo.getMessage() );
        engagementDTO.setAuditSchedule( auditScheduleToAuditScheduleDTO( engagementInfo.getAuditSchedule() ) );
        engagementDTO.setStatus( engagementInfo.getStatus() );
        engagementDTO.setRefNum( engagementInfo.getRefNum() );
        engagementDTO.setDate( engagementInfo.getDate() );

        return engagementDTO;
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
        auditProgramDTO.setObjectives( auditProgramObjectiveListToAuditProgramObjectiveDTOList( auditProgram.getObjectives() ) );
        auditProgramDTO.setPreviousDescription( auditProgram.getPreviousDescription() );
        auditProgramDTO.setScopeDescription( auditProgram.getScopeDescription() );
        auditProgramDTO.setMethodology( auditProgram.getMethodology() );
        auditProgramDTO.setOverAllTime( auditProgram.getOverAllTime() );
        auditProgramDTO.setEngagementInfo( engagementInfoToEngagementDTO( auditProgram.getEngagementInfo() ) );

        return auditProgramDTO;
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

    protected void engagementInfoToEngagementDTO1(EngagementInfo engagementInfo, EngagementDTO mappingTarget) {
        if ( engagementInfo == null ) {
            return;
        }

        mappingTarget.setId( engagementInfo.getId() );
        mappingTarget.setCreatedUser( engagementInfo.getCreatedUser() );
        mappingTarget.setModifiedUser( engagementInfo.getModifiedUser() );
        mappingTarget.setCreatedTimestamp( engagementInfo.getCreatedTimestamp() );
        mappingTarget.setModifiedTimestamp( engagementInfo.getModifiedTimestamp() );
        mappingTarget.setMessage( engagementInfo.getMessage() );
        if ( engagementInfo.getAuditSchedule() != null ) {
            if ( mappingTarget.getAuditSchedule() == null ) {
                mappingTarget.setAuditSchedule( new AuditScheduleDTO() );
            }
            auditScheduleToAuditScheduleDTO1( engagementInfo.getAuditSchedule(), mappingTarget.getAuditSchedule() );
        }
        else {
            mappingTarget.setAuditSchedule( null );
        }
        mappingTarget.setStatus( engagementInfo.getStatus() );
        mappingTarget.setRefNum( engagementInfo.getRefNum() );
        mappingTarget.setDate( engagementInfo.getDate() );
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
        if ( mappingTarget.getObjectives() != null ) {
            List<AuditProgramObjectiveDTO> list = auditProgramObjectiveListToAuditProgramObjectiveDTOList( auditProgram.getObjectives() );
            if ( list != null ) {
                mappingTarget.getObjectives().clear();
                mappingTarget.getObjectives().addAll( list );
            }
            else {
                mappingTarget.setObjectives( null );
            }
        }
        else {
            List<AuditProgramObjectiveDTO> list = auditProgramObjectiveListToAuditProgramObjectiveDTOList( auditProgram.getObjectives() );
            if ( list != null ) {
                mappingTarget.setObjectives( list );
            }
        }
        mappingTarget.setPreviousDescription( auditProgram.getPreviousDescription() );
        mappingTarget.setScopeDescription( auditProgram.getScopeDescription() );
        mappingTarget.setMethodology( auditProgram.getMethodology() );
        mappingTarget.setOverAllTime( auditProgram.getOverAllTime() );
        if ( auditProgram.getEngagementInfo() != null ) {
            if ( mappingTarget.getEngagementInfo() == null ) {
                mappingTarget.setEngagementInfo( new EngagementDTO() );
            }
            engagementInfoToEngagementDTO1( auditProgram.getEngagementInfo(), mappingTarget.getEngagementInfo() );
        }
        else {
            mappingTarget.setEngagementInfo( null );
        }
    }

    protected AuditProgramObjective auditProgramObjectiveDTOToAuditProgramObjective(AuditProgramObjectiveDTO auditProgramObjectiveDTO) {
        if ( auditProgramObjectiveDTO == null ) {
            return null;
        }

        AuditProgramObjective auditProgramObjective = new AuditProgramObjective();

        auditProgramObjective.setId( auditProgramObjectiveDTO.getId() );
        auditProgramObjective.setCreatedUser( auditProgramObjectiveDTO.getCreatedUser() );
        auditProgramObjective.setModifiedUser( auditProgramObjectiveDTO.getModifiedUser() );
        auditProgramObjective.setCreatedTimestamp( auditProgramObjectiveDTO.getCreatedTimestamp() );
        auditProgramObjective.setModifiedTimestamp( auditProgramObjectiveDTO.getModifiedTimestamp() );
        auditProgramObjective.setDescription( auditProgramObjectiveDTO.getDescription() );

        return auditProgramObjective;
    }

    protected List<AuditProgramObjective> auditProgramObjectiveDTOListToAuditProgramObjectiveList(List<AuditProgramObjectiveDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<AuditProgramObjective> list1 = new ArrayList<AuditProgramObjective>( list.size() );
        for ( AuditProgramObjectiveDTO auditProgramObjectiveDTO : list ) {
            list1.add( auditProgramObjectiveDTOToAuditProgramObjective( auditProgramObjectiveDTO ) );
        }

        return list1;
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

    protected EngagementInfo engagementDTOToEngagementInfo(EngagementDTO engagementDTO) {
        if ( engagementDTO == null ) {
            return null;
        }

        EngagementInfo engagementInfo = new EngagementInfo();

        engagementInfo.setId( engagementDTO.getId() );
        engagementInfo.setCreatedUser( engagementDTO.getCreatedUser() );
        engagementInfo.setModifiedUser( engagementDTO.getModifiedUser() );
        engagementInfo.setCreatedTimestamp( engagementDTO.getCreatedTimestamp() );
        engagementInfo.setModifiedTimestamp( engagementDTO.getModifiedTimestamp() );
        engagementInfo.setMessage( engagementDTO.getMessage() );
        engagementInfo.setAuditSchedule( auditScheduleDTOToAuditSchedule( engagementDTO.getAuditSchedule() ) );
        engagementInfo.setStatus( engagementDTO.getStatus() );
        engagementInfo.setRefNum( engagementDTO.getRefNum() );
        engagementInfo.setDate( engagementDTO.getDate() );

        return engagementInfo;
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
        auditProgram.setMethodology( auditProgramDTO.getMethodology() );
        auditProgram.setPreviousDescription( auditProgramDTO.getPreviousDescription() );
        auditProgram.setObjectives( auditProgramObjectiveDTOListToAuditProgramObjectiveList( auditProgramDTO.getObjectives() ) );
        auditProgram.setScopeDescription( auditProgramDTO.getScopeDescription() );
        auditProgram.setOverAllTime( auditProgramDTO.getOverAllTime() );
        auditProgram.setEngagementInfo( engagementDTOToEngagementInfo( auditProgramDTO.getEngagementInfo() ) );

        return auditProgram;
    }
}
