package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditStaffDTO;
import com.cbo.audit.dto.AuditTypeDTO;
import com.cbo.audit.dto.EmployeeDTO;
import com.cbo.audit.dto.UserDTO;
import com.cbo.audit.persistence.model.AuditStaff;
import com.cbo.audit.persistence.model.AuditType;
import com.cbo.audit.persistence.model.Employee;
import com.cbo.audit.persistence.model.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-01T21:13:40+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class AuditStaffMapperImpl implements AuditStaffMapper {

    @Override
    public AuditStaffDTO toDTO(AuditStaff auditStaff) {
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

    @Override
    public void copyToDTO(AuditStaff auditStaff, AuditStaffDTO auditStaffDTO) {
        if ( auditStaff == null ) {
            return;
        }

        auditStaffDTO.setId( auditStaff.getId() );
        auditStaffDTO.setCreatedUser( auditStaff.getCreatedUser() );
        auditStaffDTO.setModifiedUser( auditStaff.getModifiedUser() );
        auditStaffDTO.setCreatedTimestamp( auditStaff.getCreatedTimestamp() );
        auditStaffDTO.setModifiedTimestamp( auditStaff.getModifiedTimestamp() );
        if ( auditStaff.getAuditType() != null ) {
            if ( auditStaffDTO.getAuditType() == null ) {
                auditStaffDTO.setAuditType( new AuditTypeDTO() );
            }
            auditTypeToAuditTypeDTO1( auditStaff.getAuditType(), auditStaffDTO.getAuditType() );
        }
        else {
            auditStaffDTO.setAuditType( null );
        }
        if ( auditStaff.getUser() != null ) {
            if ( auditStaffDTO.getUser() == null ) {
                auditStaffDTO.setUser( new UserDTO() );
            }
            userToUserDTO1( auditStaff.getUser(), auditStaffDTO.getUser() );
        }
        else {
            auditStaffDTO.setUser( null );
        }
        auditStaffDTO.setStatus( auditStaff.getStatus() );
    }

    @Override
    public AuditStaff toEntity(AuditStaffDTO auditStaffDTO) {
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
}
