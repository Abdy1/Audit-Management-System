package com.cbo.audit.mapper;

import com.cbo.audit.dto.AmendedFindingDTO;
import com.cbo.audit.dto.AuditStaffDTO;
import com.cbo.audit.dto.AuditTypeDTO;
import com.cbo.audit.dto.EmployeeDTO;
import com.cbo.audit.dto.UserDTO;
import com.cbo.audit.persistence.model.AmendedFinding;
import com.cbo.audit.persistence.model.AuditStaff;
import com.cbo.audit.persistence.model.AuditType;
import com.cbo.audit.persistence.model.Employee;
import com.cbo.audit.persistence.model.User;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-23T14:50:45+0300",
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
