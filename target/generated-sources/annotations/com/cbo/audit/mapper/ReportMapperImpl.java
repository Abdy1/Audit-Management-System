package com.cbo.audit.mapper;

import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.AuditObjectDTO;
import com.cbo.audit.dto.AuditProgramDTO;
import com.cbo.audit.dto.AuditProgramObjectiveDTO;
import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.dto.AuditStaffDTO;
import com.cbo.audit.dto.AuditTypeDTO;
import com.cbo.audit.dto.AuditUniverseDTO;
import com.cbo.audit.dto.AuditableAreaDTO;
import com.cbo.audit.dto.EngagementDTO;
import com.cbo.audit.dto.FindingDTO;
import com.cbo.audit.dto.ReportDTO;
import com.cbo.audit.dto.TeamMemberDTO;
import com.cbo.audit.persistence.model.AnnualPlan;
import com.cbo.audit.persistence.model.AuditObject;
import com.cbo.audit.persistence.model.AuditProgram;
import com.cbo.audit.persistence.model.AuditProgramObjective;
import com.cbo.audit.persistence.model.AuditSchedule;
import com.cbo.audit.persistence.model.AuditStaff;
import com.cbo.audit.persistence.model.AuditType;
import com.cbo.audit.persistence.model.AuditUniverse;
import com.cbo.audit.persistence.model.AuditableArea;
import com.cbo.audit.persistence.model.EngagementInfo;
import com.cbo.audit.persistence.model.Finding;
import com.cbo.audit.persistence.model.Report;
import com.cbo.audit.persistence.model.TeamMember;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-29T09:08:14+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class ReportMapperImpl implements ReportMapper {

    @Override
    public ReportDTO toDTO(Report report) {
        if ( report == null ) {
            return null;
        }

        ReportDTO reportDTO = new ReportDTO();

        reportDTO.setId( report.getId() );
        reportDTO.setCreatedUser( report.getCreatedUser() );
        reportDTO.setModifiedUser( report.getModifiedUser() );
        reportDTO.setCreatedTimestamp( report.getCreatedTimestamp() );
        reportDTO.setModifiedTimestamp( report.getModifiedTimestamp() );
        reportDTO.setAuditSchedule( auditScheduleToAuditScheduleDTO( report.getAuditSchedule() ) );
        reportDTO.setIntroduction( report.getIntroduction() );
        reportDTO.setDateGenerated( report.getDateGenerated() );
        reportDTO.setGeneratedBy( report.getGeneratedBy() );
        reportDTO.setSentTime( report.getSentTime() );
        reportDTO.setArchiveTie( report.getArchiveTie() );
        reportDTO.setSummary( report.getSummary() );
        reportDTO.setScope( report.getScope() );
        reportDTO.setObjectives( auditProgramObjectiveListToAuditProgramObjectiveDTOList( report.getObjectives() ) );
        reportDTO.setMethodology( report.getMethodology() );
        reportDTO.setStatus( report.getStatus() );
        reportDTO.setTotalRectification( report.getTotalRectification() );
        reportDTO.setFindings( findingListToFindingDTOList( report.getFindings() ) );

        return reportDTO;
    }

    @Override
    public void copyToDTO(Report report, ReportDTO reportDTO) {
        if ( report == null ) {
            return;
        }

        reportDTO.setId( report.getId() );
        reportDTO.setCreatedUser( report.getCreatedUser() );
        reportDTO.setModifiedUser( report.getModifiedUser() );
        reportDTO.setCreatedTimestamp( report.getCreatedTimestamp() );
        reportDTO.setModifiedTimestamp( report.getModifiedTimestamp() );
        if ( report.getAuditSchedule() != null ) {
            if ( reportDTO.getAuditSchedule() == null ) {
                reportDTO.setAuditSchedule( new AuditScheduleDTO() );
            }
            auditScheduleToAuditScheduleDTO1( report.getAuditSchedule(), reportDTO.getAuditSchedule() );
        }
        else {
            reportDTO.setAuditSchedule( null );
        }
        reportDTO.setIntroduction( report.getIntroduction() );
        reportDTO.setDateGenerated( report.getDateGenerated() );
        reportDTO.setGeneratedBy( report.getGeneratedBy() );
        reportDTO.setSentTime( report.getSentTime() );
        reportDTO.setArchiveTie( report.getArchiveTie() );
        reportDTO.setSummary( report.getSummary() );
        reportDTO.setScope( report.getScope() );
        if ( reportDTO.getObjectives() != null ) {
            List<AuditProgramObjectiveDTO> list = auditProgramObjectiveListToAuditProgramObjectiveDTOList( report.getObjectives() );
            if ( list != null ) {
                reportDTO.getObjectives().clear();
                reportDTO.getObjectives().addAll( list );
            }
            else {
                reportDTO.setObjectives( null );
            }
        }
        else {
            List<AuditProgramObjectiveDTO> list = auditProgramObjectiveListToAuditProgramObjectiveDTOList( report.getObjectives() );
            if ( list != null ) {
                reportDTO.setObjectives( list );
            }
        }
        reportDTO.setMethodology( report.getMethodology() );
        reportDTO.setStatus( report.getStatus() );
        reportDTO.setTotalRectification( report.getTotalRectification() );
        if ( reportDTO.getFindings() != null ) {
            List<FindingDTO> list1 = findingListToFindingDTOList( report.getFindings() );
            if ( list1 != null ) {
                reportDTO.getFindings().clear();
                reportDTO.getFindings().addAll( list1 );
            }
            else {
                reportDTO.setFindings( null );
            }
        }
        else {
            List<FindingDTO> list1 = findingListToFindingDTOList( report.getFindings() );
            if ( list1 != null ) {
                reportDTO.setFindings( list1 );
            }
        }
    }

    @Override
    public Report toEntity(ReportDTO reportDTO) {
        if ( reportDTO == null ) {
            return null;
        }

        Report report = new Report();

        report.setId( reportDTO.getId() );
        report.setCreatedUser( reportDTO.getCreatedUser() );
        report.setModifiedUser( reportDTO.getModifiedUser() );
        report.setCreatedTimestamp( reportDTO.getCreatedTimestamp() );
        report.setModifiedTimestamp( reportDTO.getModifiedTimestamp() );
        report.setAuditSchedule( auditScheduleDTOToAuditSchedule( reportDTO.getAuditSchedule() ) );
        report.setIntroduction( reportDTO.getIntroduction() );
        report.setDateGenerated( reportDTO.getDateGenerated() );
        report.setGeneratedBy( reportDTO.getGeneratedBy() );
        report.setSentTime( reportDTO.getSentTime() );
        report.setArchiveTie( reportDTO.getArchiveTie() );
        report.setSummary( reportDTO.getSummary() );
        report.setScope( reportDTO.getScope() );
        report.setObjectives( auditProgramObjectiveDTOListToAuditProgramObjectiveList( reportDTO.getObjectives() ) );
        report.setMethodology( reportDTO.getMethodology() );
        report.setStatus( reportDTO.getStatus() );
        report.setTotalRectification( reportDTO.getTotalRectification() );
        report.setFindings( findingDTOListToFindingList( reportDTO.getFindings() ) );

        return report;
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

    protected FindingDTO findingToFindingDTO(Finding finding) {
        if ( finding == null ) {
            return null;
        }

        FindingDTO findingDTO = new FindingDTO();

        findingDTO.setId( finding.getId() );
        findingDTO.setCreatedUser( finding.getCreatedUser() );
        findingDTO.setModifiedUser( finding.getModifiedUser() );
        findingDTO.setCreatedTimestamp( finding.getCreatedTimestamp() );
        findingDTO.setModifiedTimestamp( finding.getModifiedTimestamp() );
        findingDTO.setAuditProgram( auditProgramToAuditProgramDTO( finding.getAuditProgram() ) );
        findingDTO.setFinding( finding.getFinding() );
        findingDTO.setCriteria( finding.getCriteria() );
        findingDTO.setArea( auditableAreaToAuditableAreaDTO( finding.getArea() ) );
        findingDTO.setCause( finding.getCause() );
        findingDTO.setImplementedControls( finding.getImplementedControls() );
        findingDTO.setImpact( finding.getImpact() );
        findingDTO.setRecommendations( finding.getRecommendations() );
        findingDTO.setAuditees( finding.getAuditees() );
        findingDTO.setAuditeesResponse( finding.getAuditeesResponse() );
        findingDTO.setJustifications( finding.getJustifications() );
        findingDTO.setIsVisibleToAuditees( finding.getIsVisibleToAuditees() );
        findingDTO.setRegisteredBy( auditStaffToAuditStaffDTO( finding.getRegisteredBy() ) );
        findingDTO.setApprovedBY( auditStaffToAuditStaffDTO( finding.getApprovedBY() ) );
        findingDTO.setResponseTime( finding.getResponseTime() );
        findingDTO.setRectificationStatus( finding.getRectificationStatus() );
        findingDTO.setRectificationProgress( finding.getRectificationProgress() );
        findingDTO.setRectificationEvidenceAttachmentPath( finding.getRectificationEvidenceAttachmentPath() );
        findingDTO.setRectificationTime( finding.getRectificationTime() );
        findingDTO.setIsRectificationApproved( finding.getIsRectificationApproved() );
        findingDTO.setFindingEvidenceFileUploadedToSupplementTheFindingsPath( finding.getFindingEvidenceFileUploadedToSupplementTheFindingsPath() );

        return findingDTO;
    }

    protected List<FindingDTO> findingListToFindingDTOList(List<Finding> list) {
        if ( list == null ) {
            return null;
        }

        List<FindingDTO> list1 = new ArrayList<FindingDTO>( list.size() );
        for ( Finding finding : list ) {
            list1.add( findingToFindingDTO( finding ) );
        }

        return list1;
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

    protected Finding findingDTOToFinding(FindingDTO findingDTO) {
        if ( findingDTO == null ) {
            return null;
        }

        Finding finding = new Finding();

        finding.setId( findingDTO.getId() );
        finding.setCreatedUser( findingDTO.getCreatedUser() );
        finding.setModifiedUser( findingDTO.getModifiedUser() );
        finding.setCreatedTimestamp( findingDTO.getCreatedTimestamp() );
        finding.setModifiedTimestamp( findingDTO.getModifiedTimestamp() );
        finding.setAuditProgram( auditProgramDTOToAuditProgram( findingDTO.getAuditProgram() ) );
        finding.setFinding( findingDTO.getFinding() );
        finding.setCriteria( findingDTO.getCriteria() );
        finding.setArea( auditableAreaDTOToAuditableArea( findingDTO.getArea() ) );
        finding.setCause( findingDTO.getCause() );
        finding.setImplementedControls( findingDTO.getImplementedControls() );
        finding.setImpact( findingDTO.getImpact() );
        finding.setRecommendations( findingDTO.getRecommendations() );
        finding.setAuditees( findingDTO.getAuditees() );
        finding.setAuditeesResponse( findingDTO.getAuditeesResponse() );
        finding.setJustifications( findingDTO.getJustifications() );
        finding.setIsVisibleToAuditees( findingDTO.getIsVisibleToAuditees() );
        finding.setRegisteredBy( auditStaffDTOToAuditStaff( findingDTO.getRegisteredBy() ) );
        finding.setApprovedBY( auditStaffDTOToAuditStaff( findingDTO.getApprovedBY() ) );
        finding.setResponseTime( findingDTO.getResponseTime() );
        finding.setRectificationStatus( findingDTO.getRectificationStatus() );
        finding.setRectificationProgress( findingDTO.getRectificationProgress() );
        finding.setRectificationEvidenceAttachmentPath( findingDTO.getRectificationEvidenceAttachmentPath() );
        finding.setRectificationTime( findingDTO.getRectificationTime() );
        finding.setIsRectificationApproved( findingDTO.getIsRectificationApproved() );
        finding.setFindingEvidenceFileUploadedToSupplementTheFindingsPath( findingDTO.getFindingEvidenceFileUploadedToSupplementTheFindingsPath() );

        return finding;
    }

    protected List<Finding> findingDTOListToFindingList(List<FindingDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Finding> list1 = new ArrayList<Finding>( list.size() );
        for ( FindingDTO findingDTO : list ) {
            list1.add( findingDTOToFinding( findingDTO ) );
        }

        return list1;
    }
}
