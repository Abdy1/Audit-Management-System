package com.cbo.audit.service;

import com.cbo.audit.dto.FindingCommentDTO;
import com.cbo.audit.dto.ResultWrapper;

import java.util.List;

public interface FindingCommentService {
    ResultWrapper<FindingCommentDTO> addCommentToFinding(FindingCommentDTO findingCommentDTO);

    ResultWrapper<List<FindingCommentDTO>> listAllFindingCommentByFindingId(Long findingId);

    ResultWrapper<FindingCommentDTO> updateCommentFinding(FindingCommentDTO findingCommentDTO);
}
