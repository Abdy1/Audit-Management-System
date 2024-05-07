package com.cbo.audit.mapper;

import com.cbo.audit.dto.EmployeeDTO;
import com.cbo.audit.persistence.model.Employee;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T13:54:46+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDTO toDTO(Employee user) {
        if ( user == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        return employeeDTO;
    }

    @Override
    public void copyToDTO(Employee user, EmployeeDTO userDTO) {
        if ( user == null ) {
            return;
        }
    }

    @Override
    public Employee toEntity(EmployeeDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        Employee employee = new Employee();

        return employee;
    }
}
