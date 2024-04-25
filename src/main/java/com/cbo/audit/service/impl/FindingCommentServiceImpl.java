package com.cbo.audit.service.impl;

import com.cbo.audit.dto.FindingCommentDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.mapper.FindingCommentMapper;
import com.cbo.audit.persistence.model.Finding;
import com.cbo.audit.persistence.model.FindingComment;
import com.cbo.audit.persistence.repository.FindingCommentRepository;
import com.cbo.audit.persistence.repository.FindingRepository;
import com.cbo.audit.service.FindingCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FindingCommentServiceImpl implements FindingCommentService {
    @Autowired
    FindingCommentRepository findingCommentRepository;
    @Autowired
    FindingRepository findingRepository;

    @Override
    public ResultWrapper<FindingCommentDTO> addCommentToFinding(FindingCommentDTO findingCommentDTO) {
        ResultWrapper<FindingCommentDTO> resultWrapper = new ResultWrapper<>();
        Optional<Finding> finding = findingRepository.findById(findingCommentDTO.getFinding().getId());
        if (!finding.isPresent()) {
            resultWrapper.setMessage("there is no such finding in the system");
            resultWrapper.setResult(null);
            resultWrapper.setStatus(false);
            return resultWrapper;


        }
        FindingComment comment = findingCommentRepository.save(FindingCommentMapper.INSTANCE.toEntity(findingCommentDTO));

        FindingCommentDTO commentDTO = FindingCommentMapper.INSTANCE.toDTO(comment);
        resultWrapper.setResult(findingCommentDTO);
        resultWrapper.setMessage("successfully commented");
        resultWrapper.setStatus(true);
        return resultWrapper;


    }

    @Override
    public ResultWrapper<List<FindingCommentDTO>> listAllFindingCommentByFindingId(Long finding_id) {
        ResultWrapper<List<FindingCommentDTO>> resultWrapper = new ResultWrapper<>();
        List<FindingComment> findingComments = findingCommentRepository.findFindingCommentByFindingId(finding_id);
        if (findingComments.isEmpty()) {
            resultWrapper.setResult(null);
            resultWrapper.setMessage("There is no Finding exist");
            resultWrapper.setStatus(false);
            return resultWrapper;
        }
        List<FindingCommentDTO> findingCommentDTOS = FindingCommentMapper.INSTANCE.FindingToFindingDTOs(findingComments);
        resultWrapper.setStatus(true);
        resultWrapper.setMessage("success");
        resultWrapper.setResult(findingCommentDTOS);

        return resultWrapper;
    }

    @Override
    public ResultWrapper<FindingCommentDTO> updateCommentFinding(FindingCommentDTO findingCommentDTO) {
        Optional<Finding> findingOpt = findingRepository.findById(findingCommentDTO.getFinding().getId());
        ResultWrapper<FindingCommentDTO> resultWrapper = new ResultWrapper<>();
        if (findingOpt.isPresent()) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("The comment does not have Finding related with it");
            resultWrapper.setResult(null);
            return resultWrapper;
        }
        FindingComment newFindingComment = FindingCommentMapper.INSTANCE.toEntity(findingCommentDTO);
        FindingComment savedFindingComment = findingCommentRepository.save(newFindingComment);
        FindingCommentDTO savedFindingCommentDTO = FindingCommentMapper.INSTANCE.toDTO(savedFindingComment);
        resultWrapper.setStatus(true);
        resultWrapper.setMessage("successfully updated");
        resultWrapper.setResult(savedFindingCommentDTO);
        return resultWrapper;

    }

}
