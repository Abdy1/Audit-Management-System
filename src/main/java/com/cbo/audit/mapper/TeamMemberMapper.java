package com.cbo.audit.mapper;

import com.cbo.audit.dto.TeamMemberDTO;
import com.cbo.audit.persistence.model.TeamMember;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMemberMapper {

    TeamMemberMapper INSTANCE = Mappers.getMapper(TeamMemberMapper.class);


    TeamMemberDTO toDTO(TeamMember teamMember);

    void copyToDTO(TeamMember teamMember, @MappingTarget TeamMemberDTO teamMemberDTO);


    TeamMember toEntity(TeamMemberDTO teamMemberDTO);

    default List<TeamMemberDTO> teamMembersToTeamMemberDTOs(List<TeamMember> teamMembers) {
        if (teamMembers == null) {
            return null;
        }

        List<TeamMemberDTO> list = new ArrayList<TeamMemberDTO>(teamMembers.size());
        for (TeamMember teamMember : teamMembers) {
            list.add(toDTO(teamMember));
        }

        return list;
    }
}