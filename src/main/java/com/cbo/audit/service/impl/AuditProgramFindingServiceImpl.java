package com.cbo.audit.service.impl;

import com.cbo.audit.dto.FindingDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.mapper.AuditProgramMapper;
import com.cbo.audit.mapper.FindingMapper;
import com.cbo.audit.persistence.model.AmendedFinding;
import com.cbo.audit.persistence.model.AuditProgram;
import com.cbo.audit.persistence.model.AuditUniverse;
import com.cbo.audit.persistence.model.Finding;
import com.cbo.audit.persistence.repository.AmendedFindingRepository;
import com.cbo.audit.persistence.repository.AuditProgramRepository;
import com.cbo.audit.persistence.repository.FindingRepository;
import com.cbo.audit.service.AuditProgramFindingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuditProgramFindingServiceImpl implements AuditProgramFindingService {
    @Autowired
    private FindingRepository auditProgramFindingRepository;
    @Autowired
    private AuditProgramRepository auditProgramRepository;
    @Autowired
    private AmendedFindingRepository amendedFindingRepository;
    @Override
    public ResultWrapper<FindingDTO> registerAuditProgramFinding(FindingDTO findingDTO) {

        ResultWrapper<FindingDTO> resultWrapper=new ResultWrapper<>();
        Optional<AuditProgram> auditProgramOpt = auditProgramRepository.findById(findingDTO.getAuditProgram().getId());
        if(!auditProgramOpt.isPresent()){
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Program with the Provided information does not exist");
            resultWrapper.setResult(null);
        }
        Finding finding= FindingMapper.INSTANCE.toEntity(findingDTO);
        finding.setCreatedTimestamp(LocalDateTime.now());
        finding.setFindingEvidenceFileUploadedToSupplementTheFindings(findingDTO.getFindingEvidenceFileUploadedToSupplementTheFindings());
        Finding savedFinding=auditProgramFindingRepository.save(finding);

        resultWrapper.setResult(FindingMapper.INSTANCE.toDTO(savedFinding));
        resultWrapper.setStatus(true);

        resultWrapper.setResult(findingDTO);
        return resultWrapper;

    }

    @Override
    public ResultWrapper<List<FindingDTO>> listAllFindingsByAuditProgramId(Long auditProgram_id) {
        ResultWrapper<List<FindingDTO>> resultWrapper=new ResultWrapper<>();
        List<Finding> findings = auditProgramFindingRepository.findFindingByAuditProgramId(auditProgram_id);
        System.out.println(findings.size());
        if (findings.isEmpty()){
            resultWrapper.setMessage("Finding with the provided information does not exist");
            resultWrapper.setStatus(false);
            resultWrapper.setResult(null);
            return resultWrapper;
        }
        List<FindingDTO> findingDTOs=FindingMapper.INSTANCE.FindingToFindingDTOs(findings);
        resultWrapper.setResult(findingDTOs);
        resultWrapper.setStatus(true);
        return resultWrapper;




    }

    @Override
    public ResultWrapper<FindingDTO> updateAuditProgramFinding(FindingDTO findingDTO) {
        ResultWrapper<FindingDTO> resultWrapper=new ResultWrapper<>();
        Finding finding=auditProgramFindingRepository.findById(findingDTO.getId()).orElse(null);
        if (finding == null){
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit program finding with the provided information does not exist");
            resultWrapper.setResult(null);
            return resultWrapper;
        }
        AuditProgram auditProgram = auditProgramRepository.findById(findingDTO.getAuditProgram().getId()).orElse(null);
        if(auditProgram == null){
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit program finding with the provided Audit Program does not exist");
            resultWrapper.setResult(null);
            return resultWrapper;
        }
        AmendedFinding amendedFinding =new AmendedFinding();
        amendedFinding.setFindingBeforeAmendment(finding.getFinding());
        amendedFinding.setAmendedBy(null);
        amendedFinding.setCreatedTimestamp(LocalDateTime.now());
        amendedFinding.setCreatedUser("todo");
        amendedFindingRepository.save(amendedFinding);
        Finding savedFinding=auditProgramFindingRepository.save(FindingMapper.INSTANCE.toEntity(findingDTO));

        FindingDTO savedFindingDTO = FindingMapper.INSTANCE.toDTO(savedFinding);
        resultWrapper.setResult(savedFindingDTO);
        resultWrapper.setStatus(true);
        resultWrapper.setMessage("Successfully updated");
        return resultWrapper;





    }
}
