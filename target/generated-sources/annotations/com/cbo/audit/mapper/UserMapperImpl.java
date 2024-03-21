package com.cbo.audit.mapper;

import com.cbo.audit.dto.EmployeeDTO;
import com.cbo.audit.dto.UserDTO;
import com.cbo.audit.persistence.model.Employee;
import com.cbo.audit.persistence.model.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-21T15:39:57+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(User user) {
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

    @Override
    public void copyToDTO(User user, UserDTO userDTO) {
        if ( user == null ) {
            return;
        }

        userDTO.setId( user.getId() );
        userDTO.setCreatedUser( user.getCreatedUser() );
        userDTO.setModifiedUser( user.getModifiedUser() );
        userDTO.setCreatedTimestamp( user.getCreatedTimestamp() );
        userDTO.setModifiedTimestamp( user.getModifiedTimestamp() );
        userDTO.setUsername( user.getUsername() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setActive( user.getActive() );
        if ( user.getEmployee() != null ) {
            if ( userDTO.getEmployee() == null ) {
                userDTO.setEmployee( new EmployeeDTO() );
            }
            employeeToEmployeeDTO1( user.getEmployee(), userDTO.getEmployee() );
        }
        else {
            userDTO.setEmployee( null );
        }
    }

    @Override
    public User toEntity(UserDTO userDTO) {
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
}
