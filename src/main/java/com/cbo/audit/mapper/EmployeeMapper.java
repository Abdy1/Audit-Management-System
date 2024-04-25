package com.cbo.audit.mapper;

import com.cbo.audit.dto.EmployeeDTO;
import com.cbo.audit.persistence.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO toDTO(Employee user);

    void copyToDTO(Employee user, @MappingTarget EmployeeDTO userDTO);

    Employee toEntity(EmployeeDTO userDTO);

    default List<EmployeeDTO> usersToEmployeeDTOs(List<Employee> users) {
        if (users == null) {
            return null;
        }

        List<EmployeeDTO> list = new ArrayList<EmployeeDTO>(users.size());
        for (Employee user : users) {
            list.add(toDTO(user));
        }

        return list;
    }
}
