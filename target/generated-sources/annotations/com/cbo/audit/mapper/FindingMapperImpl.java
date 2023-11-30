package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditObjectDTO;
import com.cbo.audit.dto.AuditProgramDTO;
import com.cbo.audit.dto.AuditStaffDTO;
import com.cbo.audit.dto.AuditTypeDTO;
import com.cbo.audit.dto.AuditableAreaDTO;
import com.cbo.audit.dto.EmployeeDTO;
import com.cbo.audit.dto.FindingDTO;
import com.cbo.audit.dto.UserDTO;
import com.cbo.audit.persistence.model.AuditObject;
import com.cbo.audit.persistence.model.AuditProgram;
import com.cbo.audit.persistence.model.AuditStaff;
import com.cbo.audit.persistence.model.AuditType;
import com.cbo.audit.persistence.model.AuditableArea;
import com.cbo.audit.persistence.model.Employee;
import com.cbo.audit.persistence.model.Finding;
import com.cbo.audit.persistence.model.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-30T09:57:20+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class FindingMapperImpl implements FindingMapper {

    @Override
    public FindingDTO toDTO(Finding finding) {
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

    @Override
    public void copyToDTO(Finding finding, FindingDTO findingDTO) {
        if ( finding == null ) {
            return;
        }

        findingDTO.setId( finding.getId() );
        findingDTO.setCreatedUser( finding.getCreatedUser() );
        findingDTO.setModifiedUser( finding.getModifiedUser() );
        findingDTO.setCreatedTimestamp( finding.getCreatedTimestamp() );
        findingDTO.setModifiedTimestamp( finding.getModifiedTimestamp() );
        if ( finding.getAuditProgram() != null ) {
            if ( findingDTO.getAuditProgram() == null ) {
                findingDTO.setAuditProgram( new AuditProgramDTO() );
            }
            auditProgramToAuditProgramDTO1( finding.getAuditProgram(), findingDTO.getAuditProgram() );
        }
        else {
            findingDTO.setAuditProgram( null );
        }
        findingDTO.setFinding( finding.getFinding() );
        findingDTO.setCriteria( finding.getCriteria() );
        if ( finding.getArea() != null ) {
            if ( findingDTO.getArea() == null ) {
                findingDTO.setArea( new AuditableAreaDTO() );
            }
            auditableAreaToAuditableAreaDTO1( finding.getArea(), findingDTO.getArea() );
        }
        else {
            findingDTO.setArea( null );
        }
        findingDTO.setCause( finding.getCause() );
        findingDTO.setImplementedControls( finding.getImplementedControls() );
        findingDTO.setImpact( finding.getImpact() );
        findingDTO.setRecommendations( finding.getRecommendations() );
        findingDTO.setAuditees( finding.getAuditees() );
        findingDTO.setAuditeesResponse( finding.getAuditeesResponse() );
        findingDTO.setJustifications( finding.getJustifications() );
        if ( finding.getRegisteredBy() != null ) {
            if ( findingDTO.getRegisteredBy() == null ) {
                findingDTO.setRegisteredBy( new AuditStaffDTO() );
            }
            auditStaffToAuditStaffDTO1( finding.getRegisteredBy(), findingDTO.getRegisteredBy() );
        }
        else {
            findingDTO.setRegisteredBy( null );
        }
        if ( finding.getApprovedBY() != null ) {
            if ( findingDTO.getApprovedBY() == null ) {
                findingDTO.setApprovedBY( new AuditStaffDTO() );
            }
            auditStaffToAuditStaffDTO1( finding.getApprovedBY(), findingDTO.getApprovedBY() );
        }
        else {
            findingDTO.setApprovedBY( null );
        }
        findingDTO.setResponseTime( finding.getResponseTime() );
        findingDTO.setRectificationStatus( finding.getRectificationStatus() );
        findingDTO.setRectificationProgress( finding.getRectificationProgress() );
        findingDTO.setRectificationEvidenceAttachmentPath( finding.getRectificationEvidenceAttachmentPath() );
        findingDTO.setRectificationTime( finding.getRectificationTime() );
        findingDTO.setIsRectificationApproved( finding.getIsRectificationApproved() );
        findingDTO.setFindingEvidenceFileUploadedToSupplementTheFindings( finding.getFindingEvidenceFileUploadedToSupplementTheFindings() );
    }

    @Override
    public Finding toEntity(FindingDTO findingDTO) {
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
}
