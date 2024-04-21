package com.cbo.audit.service.impl;

import com.cbo.audit.dto.AuditTypeDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.persistence.model.AuditType;
import com.cbo.audit.mapper.AuditTypeMapper;
import com.cbo.audit.persistence.repository.AuditTypeRepository;
import com.cbo.audit.service.AuditTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service("auditTypeService")
@Transactional
public class AuditTypeServiceImpl implements AuditTypeService {
    @Autowired
    private AuditTypeRepository auditTypeRepository;


    @Override
    public ResultWrapper<AuditTypeDTO> registerAuditType(AuditTypeDTO auditTypeDTO) {
        ResultWrapper<AuditTypeDTO> resultWrapper = new ResultWrapper<>();

        AuditType auditType = AuditTypeMapper.INSTANCE.toEntity(auditTypeDTO);
        auditType.setCreatedTimestamp(LocalDateTime.now());
        auditType.setCreatedUser("TODO");
        AuditType savedPlan = auditTypeRepository.save(auditType);

        resultWrapper.setStatus(true);
        resultWrapper.setResult(AuditTypeMapper.INSTANCE.toDTO(savedPlan));
        resultWrapper.setMessage("AuditType created successfully.");
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AuditTypeDTO>> getAllAuditType() {
        ResultWrapper<List<AuditTypeDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditType> auditTypes=auditTypeRepository.findAll();
        if (!auditTypes.isEmpty()){
            List<AuditTypeDTO> auditTypeDTOS = AuditTypeMapper.INSTANCE.auditTypesToAuditTypeDTOs(auditTypes);
            resultWrapper.setResult(auditTypeDTOS);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }


    @Override
    public ResultWrapper<AuditTypeDTO> getAuditTypeById(Long id) {

        ResultWrapper<AuditTypeDTO> resultWrapper = new ResultWrapper<>();
        AuditType auditType = auditTypeRepository.findById(id).orElse(null);
        if (auditType != null){
            AuditTypeDTO auditTypeDTO = AuditTypeMapper.INSTANCE.toDTO(auditType);
            resultWrapper.setResult(auditTypeDTO);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public AuditType findAuditTypeById(Long id) {
        return auditTypeRepository.findById(id).orElse(null);
    }

    @Override
    public ResultWrapper<AuditTypeDTO> updateAuditType(AuditTypeDTO auditTypeDTO) {
        ResultWrapper<AuditTypeDTO> resultWrapper = new ResultWrapper<>(auditTypeDTO);

        AuditType oldChecklist = auditTypeRepository.findById(auditTypeDTO.getId()).orElse(null);

        if (oldChecklist != null){
            if (auditTypeDTO.getName() == null){
                resultWrapper.setStatus(false);
                resultWrapper.setMessage("Audit Type name cannot be null.");
            } {

                AuditType auditType = AuditTypeMapper.INSTANCE.toEntity(auditTypeDTO);

                auditType.setCreatedTimestamp(oldChecklist.getCreatedTimestamp());
                auditType.setCreatedUser(oldChecklist.getCreatedUser());

                AuditType savedUniverse = auditTypeRepository.save(auditType);
                resultWrapper.setResult(AuditTypeMapper.INSTANCE.toDTO(savedUniverse));
                resultWrapper.setStatus(true);
                resultWrapper.setMessage("Audit Type updated successfully.");
            }
        }else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Type with the provided id does not exist.");
        }

        return resultWrapper;
    }

    @Override
    public ResultWrapper<AuditTypeDTO> deleteAuditType(AuditTypeDTO auditTypeDTO) {
        ResultWrapper<AuditTypeDTO> resultWrapper = new ResultWrapper<>(auditTypeDTO);

        AuditType oldChecklist = auditTypeRepository.findById(auditTypeDTO.getId()).orElse(null);

        if (oldChecklist != null){
                auditTypeRepository.delete(oldChecklist);
                resultWrapper.setStatus(true);
                resultWrapper.setMessage("Audit Type deleted successfully.");
        }else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Type with the provided id does not exist.");
        }

        return resultWrapper;
    }
}
