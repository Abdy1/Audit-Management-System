package com.cbo.audit.mapper;

import com.cbo.audit.dto.EmployeeDTO;
import com.cbo.audit.persistence.model.Employee;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-14T14:51:46+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDTO toDTO(Employee user) {
        if ( user == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId( user.getId() );
        employeeDTO.setEmployeeId( user.getEmployeeId() );
        employeeDTO.setFullName( user.getFullName() );
        employeeDTO.setJobTitle( user.getJobTitle() );
        employeeDTO.setPhoneNumber( user.getPhoneNumber() );
        employeeDTO.setPersonalEmail( user.getPersonalEmail() );
        employeeDTO.setCompanyEmail( user.getCompanyEmail() );
        employeeDTO.setGender( user.getGender() );
        employeeDTO.setBirthDate( user.getBirthDate() );
        employeeDTO.setEmployeeImage( user.getEmployeeImage() );
        employeeDTO.setSignatureImage( user.getSignatureImage() );
        employeeDTO.setActive( user.getActive() );

        return employeeDTO;
    }

    @Override
    public void copyToDTO(Employee user, EmployeeDTO userDTO) {
        if ( user == null ) {
            return;
        }

        userDTO.setId( user.getId() );
        userDTO.setEmployeeId( user.getEmployeeId() );
        userDTO.setFullName( user.getFullName() );
        userDTO.setJobTitle( user.getJobTitle() );
        userDTO.setPhoneNumber( user.getPhoneNumber() );
        userDTO.setPersonalEmail( user.getPersonalEmail() );
        userDTO.setCompanyEmail( user.getCompanyEmail() );
        userDTO.setGender( user.getGender() );
        userDTO.setBirthDate( user.getBirthDate() );
        userDTO.setEmployeeImage( user.getEmployeeImage() );
        userDTO.setSignatureImage( user.getSignatureImage() );
        userDTO.setActive( user.getActive() );
    }

    @Override
    public Employee toEntity(EmployeeDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( userDTO.getId() );
        employee.setEmployeeId( userDTO.getEmployeeId() );
        employee.setFullName( userDTO.getFullName() );
        employee.setJobTitle( userDTO.getJobTitle() );
        employee.setPhoneNumber( userDTO.getPhoneNumber() );
        employee.setPersonalEmail( userDTO.getPersonalEmail() );
        employee.setCompanyEmail( userDTO.getCompanyEmail() );
        employee.setGender( userDTO.getGender() );
        employee.setBirthDate( userDTO.getBirthDate() );
        employee.setEmployeeImage( userDTO.getEmployeeImage() );
        employee.setSignatureImage( userDTO.getSignatureImage() );
        employee.setActive( userDTO.getActive() );

        return employee;
    }
}
