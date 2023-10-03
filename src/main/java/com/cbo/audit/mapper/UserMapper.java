package com.cbo.audit.mapper;

import com.cbo.audit.dto.UserDTO;
import com.cbo.audit.persistence.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User user);

    void copyToDTO(User user, @MappingTarget UserDTO userDTO);

    User toEntity(UserDTO userDTO);

    default List<UserDTO> usersToUserDTOs(List<User> users) {
        if (users == null) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>(users.size());
        for (User user : users) {
            list.add(toDTO(user));
        }

        return list;
    }
}
