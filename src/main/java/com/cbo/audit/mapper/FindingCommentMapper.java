package com.cbo.audit.mapper;

import com.cbo.audit.dto.FindingCommentDTO;
import com.cbo.audit.persistence.model.FindingComment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")

public interface FindingCommentMapper {

    FindingCommentMapper INSTANCE = Mappers.getMapper(FindingCommentMapper.class);

    FindingCommentDTO toDTO(FindingComment findingComment);

    void copyToDTO(FindingComment findingComment, @MappingTarget FindingCommentDTO findingCommentDTO);

    FindingComment toEntity(FindingCommentDTO findingCommentDTO);

    default List<FindingCommentDTO> FindingToFindingDTOs(List<FindingComment> findingComments) {
        if (findingComments == null) {
            return null;
        }

        List<FindingCommentDTO> list = new ArrayList<FindingCommentDTO>(findingComments.size());
        for (FindingComment findingComment : findingComments) {
            list.add(toDTO(findingComment));
        }

        return list;
    }

}
