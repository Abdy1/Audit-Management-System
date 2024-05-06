package com.cbo.audit.mapper;

import com.cbo.audit.dto.FindingCommentDTO;
import com.cbo.audit.persistence.model.FindingComment;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T13:54:46+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class FindingCommentMapperImpl implements FindingCommentMapper {

    @Override
    public FindingCommentDTO toDTO(FindingComment findingComment) {
        if ( findingComment == null ) {
            return null;
        }

        FindingCommentDTO findingCommentDTO = new FindingCommentDTO();

        return findingCommentDTO;
    }

    @Override
    public void copyToDTO(FindingComment findingComment, FindingCommentDTO findingCommentDTO) {
        if ( findingComment == null ) {
            return;
        }
    }

    @Override
    public FindingComment toEntity(FindingCommentDTO findingCommentDTO) {
        if ( findingCommentDTO == null ) {
            return null;
        }

        FindingComment findingComment = new FindingComment();

        return findingComment;
    }
}
