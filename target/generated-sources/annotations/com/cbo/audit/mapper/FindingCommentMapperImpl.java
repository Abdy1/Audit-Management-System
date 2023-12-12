package com.cbo.audit.mapper;

import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.AuditObjectDTO;
import com.cbo.audit.dto.AuditProgramDTO;
import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.dto.AuditStaffDTO;
import com.cbo.audit.dto.AuditTypeDTO;
import com.cbo.audit.dto.AuditUniverseDTO;
import com.cbo.audit.dto.AuditableAreaDTO;
import com.cbo.audit.dto.EmployeeDTO;
import com.cbo.audit.dto.EngagementDTO;
import com.cbo.audit.dto.FindingCommentDTO;
import com.cbo.audit.dto.FindingDTO;
import com.cbo.audit.dto.TeamMemberDTO;
import com.cbo.audit.dto.UserDTO;
import com.cbo.audit.persistence.model.AnnualPlan;
import com.cbo.audit.persistence.model.AuditObject;
import com.cbo.audit.persistence.model.AuditProgram;
import com.cbo.audit.persistence.model.AuditSchedule;
import com.cbo.audit.persistence.model.AuditStaff;
import com.cbo.audit.persistence.model.AuditType;
import com.cbo.audit.persistence.model.AuditUniverse;
import com.cbo.audit.persistence.model.AuditableArea;
import com.cbo.audit.persistence.model.Employee;
import com.cbo.audit.persistence.model.EngagementInfo;
import com.cbo.audit.persistence.model.Finding;
import com.cbo.audit.persistence.model.FindingComment;
import com.cbo.audit.persistence.model.TeamMember;
import com.cbo.audit.persistence.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-11T15:28:32+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class FindingCommentMapperImpl implements FindingCommentMapper {

    @Override
    public FindingCommentDTO toDTO(FindingComment findingComment) {
        if ( findingComment == null ) {
            return null;
        }

        FindingCommentDTO findingCommentDTO = new FindingCommentDTO();

        findingCommentDTO.setId( findingComment.getId() );
        findingCommentDTO.setCreatedUser( findingComment.getCreatedUser() );
        findingCommentDTO.setModifiedUser( findingComment.getModifiedUser() );
        findingCommentDTO.setCreatedTimestamp( findingComment.getCreatedTimestamp() );
        findingCommentDTO.setModifiedTimestamp( findingComment.getModifiedTimestamp() );
        findingCommentDTO.setFinding( findingToFindingDTO( findingComment.getFinding() ) );
        findingCommentDTO.setOriginalfinding( findingComment.getOriginalfinding() );
        findingCommentDTO.setComment( findingComment.getComment() );
        findingCommentDTO.setProvidedBy( findingComment.getProvidedBy() );
        findingCommentDTO.setSatus( findingComment.getSatus() );

        return findingCommentDTO;
    }

    @Override
    public void copyToDTO(FindingComment findingComment, FindingCommentDTO findingCommentDTO) {
        if ( findingComment == null ) {
            return;
        }

        findingCommentDTO.setId( findingComment.getId() );
        findingCommentDTO.setCreatedUser( findingComment.getCreatedUser() );
        findingCommentDTO.setModifiedUser( findingComment.getModifiedUser() );
        findingCommentDTO.setCreatedTimestamp( findingComment.getCreatedTimestamp() );
        findingCommentDTO.setModifiedTimestamp( findingComment.getModifiedTimestamp() );
        if ( findingComment.getFinding() != null ) {
            if ( findingCommentDTO.getFinding() == null ) {
                findingCommentDTO.setFinding( new FindingDTO() );
            }
            findingToFindingDTO1( findingComment.getFinding(), findingCommentDTO.getFinding() );
        }
        else {
            findingCommentDTO.setFinding( null );
        }
        findingCommentDTO.setOriginalfinding( findingComment.getOriginalfinding() );
        findingCommentDTO.setComment( findingComment.getComment() );
        findingCommentDTO.setProvidedBy( findingComment.getProvidedBy() );
        findingCommentDTO.setSatus( findingComment.getSatus() );
    }

    @Override
    public FindingComment toEntity(FindingCommentDTO findingCommentDTO) {
        if ( findingCommentDTO == null ) {
            return null;
        }

        FindingComment findingComment = new FindingComment();

        findingComment.setId( findingCommentDTO.getId() );
        findingComment.setCreatedUser( findingCommentDTO.getCreatedUser() );
        findingComment.setModifiedUser( findingCommentDTO.getModifiedUser() );
        findingComment.setCreatedTimestamp( findingCommentDTO.getCreatedTimestamp() );
        findingComment.setModifiedTimestamp( findingCommentDTO.getModifiedTimestamp() );
        findingComment.setFinding( findingDTOToFinding( findingCommentDTO.getFinding() ) );
        findingComment.setOriginalfinding( findingCommentDTO.getOriginalfinding() );
        findingComment.setComment( findingCommentDTO.getComment() );
        findingComment.setProvidedBy( findingCommentDTO.getProvidedBy() );
        findingComment.setSatus( findingCommentDTO.getSatus() );

        return findingComment;
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
        auditProgramDTO.setObjectives( auditProgram.getObjectives() );
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

    protected EmployeeDTO employeeToEmployeeDTO(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId( employee.getId() );
        employeeDTO.setEmployeeId( employee.getEmployeeId() );
        employeeDTO.setFullName( employee.getFullName() );
        employeeDTO.setJobTitle( employee.getJobTitle() );
        employeeDTO.setPhoneNumber( employee.getPhoneNumber() );
        employeeDTO.setPersonalEmail( employee.getPersonalEmail() );
        employeeDTO.setCompanyEmail( employee.getCompanyEmail() );
        employeeDTO.setGender( employee.getGender() );
        employeeDTO.setBirthDate( employee.getBirthDate() );
        employeeDTO.setEmployeeImage( employee.getEmployeeImage() );
        employeeDTO.setSignatureImage( employee.getSignatureImage() );
        employeeDTO.setActive( employee.getActive() );

        return employeeDTO;
    }

    protected UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setCreatedUser( user.getCreatedUser() );
        userDTO.setModifiedUser( user.getModifiedUser() );
        userDTO.setCreatedTimestamp( user.getCreatedTimestamp() );
        userDTO.setModifiedTimestamp( user.getModifiedTimestamp() );
        userDTO.setUsername( user.getUsername() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setActive( user.getActive() );
        userDTO.setEmployee( employeeToEmployeeDTO( user.getEmployee() ) );

        return userDTO;
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
        auditStaffDTO.setUser( userToUserDTO( auditStaff.getUser() ) );
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
        findingDTO.setRegisteredBy( auditStaffToAuditStaffDTO( finding.getRegisteredBy() ) );
        findingDTO.setApprovedBY( auditStaffToAuditStaffDTO( finding.getApprovedBY() ) );
        findingDTO.setResponseTime( finding.getResponseTime() );
        findingDTO.setRectificationStatus( finding.getRectificationStatus() );
        findingDTO.setRectificationProgress( finding.getRectificationProgress() );
        findingDTO.setRectificationEvidenceAttachmentPath( finding.getRectificationEvidenceAttachmentPath() );
        findingDTO.setRectificationTime( finding.getRectificationTime() );
        findingDTO.setIsRectificationApproved( finding.getIsRectificationApproved() );
        findingDTO.setFindingEvidenceFileUploadedToSupplementTheFindings( finding.getFindingEvidenceFileUploadedToSupplementTheFindings() );

        return findingDTO;
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
        mappingTarget.setObjectives( auditProgram.getObjectives() );
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

    protected void employeeToEmployeeDTO1(Employee employee, EmployeeDTO mappingTarget) {
        if ( employee == null ) {
            return;
        }

        mappingTarget.setId( employee.getId() );
        mappingTarget.setEmployeeId( employee.getEmployeeId() );
        mappingTarget.setFullName( employee.getFullName() );
        mappingTarget.setJobTitle( employee.getJobTitle() );
        mappingTarget.setPhoneNumber( employee.getPhoneNumber() );
        mappingTarget.setPersonalEmail( employee.getPersonalEmail() );
        mappingTarget.setCompanyEmail( employee.getCompanyEmail() );
        mappingTarget.setGender( employee.getGender() );
        mappingTarget.setBirthDate( employee.getBirthDate() );
        mappingTarget.setEmployeeImage( employee.getEmployeeImage() );
        mappingTarget.setSignatureImage( employee.getSignatureImage() );
        mappingTarget.setActive( employee.getActive() );
    }

    protected void userToUserDTO1(User user, UserDTO mappingTarget) {
        if ( user == null ) {
            return;
        }

        mappingTarget.setId( user.getId() );
        mappingTarget.setCreatedUser( user.getCreatedUser() );
        mappingTarget.setModifiedUser( user.getModifiedUser() );
        mappingTarget.setCreatedTimestamp( user.getCreatedTimestamp() );
        mappingTarget.setModifiedTimestamp( user.getModifiedTimestamp() );
        mappingTarget.setUsername( user.getUsername() );
        mappingTarget.setPassword( user.getPassword() );
        mappingTarget.setActive( user.getActive() );
        if ( user.getEmployee() != null ) {
            if ( mappingTarget.getEmployee() == null ) {
                mappingTarget.setEmployee( new EmployeeDTO() );
            }
            employeeToEmployeeDTO1( user.getEmployee(), mappingTarget.getEmployee() );
        }
        else {
            mappingTarget.setEmployee( null );
        }
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
        if ( auditStaff.getUser() != null ) {
            if ( mappingTarget.getUser() == null ) {
                mappingTarget.setUser( new UserDTO() );
            }
            userToUserDTO1( auditStaff.getUser(), mappingTarget.getUser() );
        }
        else {
            mappingTarget.setUser( null );
        }
        mappingTarget.setStatus( auditStaff.getStatus() );
    }

    protected void findingToFindingDTO1(Finding finding, FindingDTO mappingTarget) {
        if ( finding == null ) {
            return;
        }

        mappingTarget.setId( finding.getId() );
        mappingTarget.setCreatedUser( finding.getCreatedUser() );
        mappingTarget.setModifiedUser( finding.getModifiedUser() );
        mappingTarget.setCreatedTimestamp( finding.getCreatedTimestamp() );
        mappingTarget.setModifiedTimestamp( finding.getModifiedTimestamp() );
        if ( finding.getAuditProgram() != null ) {
            if ( mappingTarget.getAuditProgram() == null ) {
                mappingTarget.setAuditProgram( new AuditProgramDTO() );
            }
            auditProgramToAuditProgramDTO1( finding.getAuditProgram(), mappingTarget.getAuditProgram() );
        }
        else {
            mappingTarget.setAuditProgram( null );
        }
        mappingTarget.setFinding( finding.getFinding() );
        mappingTarget.setCriteria( finding.getCriteria() );
        if ( finding.getArea() != null ) {
            if ( mappingTarget.getArea() == null ) {
                mappingTarget.setArea( new AuditableAreaDTO() );
            }
            auditableAreaToAuditableAreaDTO1( finding.getArea(), mappingTarget.getArea() );
        }
        else {
            mappingTarget.setArea( null );
        }
        mappingTarget.setCause( finding.getCause() );
        mappingTarget.setImplementedControls( finding.getImplementedControls() );
        mappingTarget.setImpact( finding.getImpact() );
        mappingTarget.setRecommendations( finding.getRecommendations() );
        mappingTarget.setAuditees( finding.getAuditees() );
        mappingTarget.setAuditeesResponse( finding.getAuditeesResponse() );
        mappingTarget.setJustifications( finding.getJustifications() );
        if ( finding.getRegisteredBy() != null ) {
            if ( mappingTarget.getRegisteredBy() == null ) {
                mappingTarget.setRegisteredBy( new AuditStaffDTO() );
            }
            auditStaffToAuditStaffDTO1( finding.getRegisteredBy(), mappingTarget.getRegisteredBy() );
        }
        else {
            mappingTarget.setRegisteredBy( null );
        }
        if ( finding.getApprovedBY() != null ) {
            if ( mappingTarget.getApprovedBY() == null ) {
                mappingTarget.setApprovedBY( new AuditStaffDTO() );
            }
            auditStaffToAuditStaffDTO1( finding.getApprovedBY(), mappingTarget.getApprovedBY() );
        }
        else {
            mappingTarget.setApprovedBY( null );
        }
        mappingTarget.setResponseTime( finding.getResponseTime() );
        mappingTarget.setRectificationStatus( finding.getRectificationStatus() );
        mappingTarget.setRectificationProgress( finding.getRectificationProgress() );
        mappingTarget.setRectificationEvidenceAttachmentPath( finding.getRectificationEvidenceAttachmentPath() );
        mappingTarget.setRectificationTime( finding.getRectificationTime() );
        mappingTarget.setIsRectificationApproved( finding.getIsRectificationApproved() );
        mappingTarget.setFindingEvidenceFileUploadedToSupplementTheFindings( finding.getFindingEvidenceFileUploadedToSupplementTheFindings() );
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
        auditProgram.setObjectives( auditProgramDTO.getObjectives() );
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

    protected Employee employeeDTOToEmployee(EmployeeDTO employeeDTO) {
        if ( employeeDTO == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( employeeDTO.getId() );
        employee.setEmployeeId( employeeDTO.getEmployeeId() );
        employee.setFullName( employeeDTO.getFullName() );
        employee.setJobTitle( employeeDTO.getJobTitle() );
        employee.setPhoneNumber( employeeDTO.getPhoneNumber() );
        employee.setPersonalEmail( employeeDTO.getPersonalEmail() );
        employee.setCompanyEmail( employeeDTO.getCompanyEmail() );
        employee.setGender( employeeDTO.getGender() );
        employee.setBirthDate( employeeDTO.getBirthDate() );
        employee.setEmployeeImage( employeeDTO.getEmployeeImage() );
        employee.setSignatureImage( employeeDTO.getSignatureImage() );
        employee.setActive( employeeDTO.getActive() );

        return employee;
    }

    protected User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setCreatedUser( userDTO.getCreatedUser() );
        user.setModifiedUser( userDTO.getModifiedUser() );
        user.setCreatedTimestamp( userDTO.getCreatedTimestamp() );
        user.setModifiedTimestamp( userDTO.getModifiedTimestamp() );
        user.setUsername( userDTO.getUsername() );
        user.setPassword( userDTO.getPassword() );
        user.setActive( userDTO.getActive() );
        user.setEmployee( employeeDTOToEmployee( userDTO.getEmployee() ) );

        return user;
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
        auditStaff.setUser( userDTOToUser( auditStaffDTO.getUser() ) );
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
        finding.setRegisteredBy( auditStaffDTOToAuditStaff( findingDTO.getRegisteredBy() ) );
        finding.setApprovedBY( auditStaffDTOToAuditStaff( findingDTO.getApprovedBY() ) );
        finding.setResponseTime( findingDTO.getResponseTime() );
        finding.setRectificationStatus( findingDTO.getRectificationStatus() );
        finding.setRectificationProgress( findingDTO.getRectificationProgress() );
        finding.setRectificationEvidenceAttachmentPath( findingDTO.getRectificationEvidenceAttachmentPath() );
        finding.setRectificationTime( findingDTO.getRectificationTime() );
        finding.setIsRectificationApproved( findingDTO.getIsRectificationApproved() );
        finding.setFindingEvidenceFileUploadedToSupplementTheFindings( findingDTO.getFindingEvidenceFileUploadedToSupplementTheFindings() );

        return finding;
    }
}
