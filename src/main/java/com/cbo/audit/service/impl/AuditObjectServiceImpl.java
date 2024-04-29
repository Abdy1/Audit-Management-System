package com.cbo.audit.service.impl;

import com.cbo.audit.dto.AuditObjectDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.enums.AuditUniverseStatus;
import com.cbo.audit.mapper.AuditObjectMapper;
import com.cbo.audit.persistence.model.AuditObject;
import com.cbo.audit.persistence.model.AuditType;
import com.cbo.audit.persistence.model.AuditUniverse;
import com.cbo.audit.persistence.repository.AuditObjectRepository;
import com.cbo.audit.persistence.repository.AuditTypeRepository;
import com.cbo.audit.service.AuditObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service("auditObjectService")
@Transactional
public class AuditObjectServiceImpl implements AuditObjectService {


    @Autowired
    private AuditObjectRepository auditObjectRepository;

    @Autowired
    private AuditTypeRepository auditTypeRepository;

    @Override
    public ResultWrapper<AuditObjectDTO> registerAuditObject(AuditObjectDTO auditObjectDTO) {
        ResultWrapper<AuditObjectDTO> resultWrapper = new ResultWrapper<>();

        if (auditObjectDTO.getName() == null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Object name cannot be null.");
            return resultWrapper;
        } else if (auditObjectDTO.getAuditType() == null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Object type cannot be null.");
        }

        AuditObject auditObject = AuditObjectMapper.INSTANCE.toEntity(auditObjectDTO);
        auditObject.setCreatedTimestamp(LocalDateTime.now());
        auditObject.setStatus(AuditUniverseStatus.PendingApproval.name());
        AuditObject savedPlan = auditObjectRepository.save(auditObject);

        resultWrapper.setStatus(true);
        resultWrapper.setResult(AuditObjectMapper.INSTANCE.toDTO(savedPlan));
        resultWrapper.setMessage("Audit Object created successfully.");
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AuditObjectDTO>> getAllAuditObject() {
        ResultWrapper<List<AuditObjectDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditObject> auditObjects = auditObjectRepository.findAll();
        if (!auditObjects.isEmpty()) {
            List<AuditObjectDTO> auditObjectDTOS = AuditObjectMapper.INSTANCE.auditObjectsToAuditObjectDTOs(auditObjects);
            resultWrapper.setResult(auditObjectDTOS);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }


    @Override
    public ResultWrapper<AuditObjectDTO> getAuditObjectById(Long id) {

        ResultWrapper<AuditObjectDTO> resultWrapper = new ResultWrapper<>();
        AuditObject auditObject = auditObjectRepository.findById(id).orElse(null);
        if (auditObject != null) {
            AuditObjectDTO auditObjectDTO = AuditObjectMapper.INSTANCE.toDTO(auditObject);
            resultWrapper.setResult(auditObjectDTO);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public Optional<AuditObject> findAuditObjectById(Long id) {
        return auditObjectRepository.findById(id);
    }


    @Override
    public ResultWrapper<List<AuditType>> getAllAuditType() {

        ResultWrapper<List<AuditType>> resultWrapper = new ResultWrapper<>();
        List<AuditType> auditObjects = auditTypeRepository.findAll();
        if (!auditObjects.isEmpty()) {
            resultWrapper.setResult(auditObjects);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AuditObjectDTO>> getAuditObjectByAuditType(String auditType) {

        ResultWrapper<List<AuditObjectDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditObject> auditObjects = auditObjectRepository.findAuditObjectsByAuditType(auditType);
        if (!auditObjects.isEmpty()) {
            List<AuditObjectDTO> auditObjectDTOS = AuditObjectMapper.INSTANCE.auditObjectsToAuditObjectDTOs(auditObjects);
            resultWrapper.setResult(auditObjectDTOS);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }


    @Override
    public ResultWrapper<AuditObjectDTO> updateAuditObject(AuditObjectDTO auditObjectDTO) {
        ResultWrapper<AuditObjectDTO> resultWrapper = new ResultWrapper<>(auditObjectDTO);

        AuditObject oldUniverse = auditObjectRepository.findById(auditObjectDTO.getId()).orElse(null);

        if (oldUniverse != null) {
            if (auditObjectDTO.getName() == null) {
                resultWrapper.setStatus(false);
                resultWrapper.setMessage("Audit Object name cannot be null.");
            } else if (auditObjectDTO.getAuditType() == null) {
                resultWrapper.setStatus(false);
                resultWrapper.setMessage("Audit Object type cannot be null.");
            } else {

                AuditObject auditObject = AuditObjectMapper.INSTANCE.toEntity(auditObjectDTO);

                auditObject.setCreatedTimestamp(oldUniverse.getCreatedTimestamp());
                auditObject.setCreatedUser(oldUniverse.getCreatedUser());

                AuditObject savedUniverse = auditObjectRepository.save(auditObject);
                resultWrapper.setResult(AuditObjectMapper.INSTANCE.toDTO(savedUniverse));
                resultWrapper.setStatus(true);
                resultWrapper.setMessage("Audit Object updated successfully.");
            }
        } else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit object with the provided id is not available.");
        }

        return resultWrapper;
    }

}
