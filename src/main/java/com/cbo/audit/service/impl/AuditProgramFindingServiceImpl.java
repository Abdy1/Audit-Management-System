package com.cbo.audit.service.impl;

import com.cbo.audit.dto.AmendedFindingDTO;
import com.cbo.audit.dto.FindingDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.mapper.AmendedFindingMapper;
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
import com.cbo.audit.utils.FileUploadUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
            return resultWrapper;
        }


        Finding finding= FindingMapper.INSTANCE.toEntity(findingDTO);
        finding.setCreatedTimestamp(LocalDateTime.now());
        finding.setFindingEvidenceFileUploadedToSupplementTheFindingsPath(null);
        Finding savedFinding=auditProgramFindingRepository.save(finding);


        resultWrapper.setResult(FindingMapper.INSTANCE.toDTO(savedFinding));
        resultWrapper.setStatus(true);


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

    @Override
    public ResultWrapper<List<AmendedFindingDTO>> getAllAmendedFindingsByFindingId(long id) {
        List<AmendedFinding> amendedFindings=amendedFindingRepository.findAllAmendedFindingByFindingId(id);
        ResultWrapper<List<AmendedFindingDTO>> resultWrapper=new ResultWrapper<>();
        if (amendedFindings.isEmpty()){
            resultWrapper.setMessage("There are no amendment made with the given information");
            resultWrapper.setStatus(false);
            resultWrapper.setResult(null);
            return resultWrapper;

        }
        resultWrapper.setMessage("success");
        List<AmendedFindingDTO> amendedFindingDTOS=AmendedFindingMapper.INSTANCE.AmendedFindingToAmendedFindingDTOs(amendedFindings);
        resultWrapper.setResult(amendedFindingDTOS);
        resultWrapper.setStatus(true);
        return resultWrapper;
    }



    @Override
    public ResultWrapper<String> attachFile(MultipartFile file,Long id) throws IOException {
        ResultWrapper<String> resultWrapper=new ResultWrapper<>();
Finding finding=auditProgramFindingRepository.findById(id).orElse(null);
if(finding == null){
    resultWrapper.setStatus(false);
    resultWrapper.setResult(null);
    resultWrapper.setMessage("There is no Finding with the provided Information");
    return resultWrapper;
}
Path path = saveFile("findings/evidences",file.getOriginalFilename(),file);
finding.setFindingEvidenceFileUploadedToSupplementTheFindingsPath(path.toString());
resultWrapper.setMessage("success");
resultWrapper.setStatus(true);
resultWrapper.setResult(finding.getFindingEvidenceFileUploadedToSupplementTheFindingsPath());
return resultWrapper;

    }
    public Path saveFile(String uploadDir, String fileName,
                                MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            return filePath;
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }

    }

