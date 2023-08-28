package com.cbo.audit.service.impl;

import com.cbo.audit.dto.AuditUniverseDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.enums.AuditUniverseStatus;
import com.cbo.audit.mapper.AuditUniverseMapper;
import com.cbo.audit.persistence.model.AuditUniverse;
import com.cbo.audit.persistence.repository.AuditUniverseRepository;
import com.cbo.audit.service.AuditUniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service("auditUniverseService")
@Transactional
public class AuditUniverseServiceImpl implements AuditUniverseService {


    @Autowired
    private AuditUniverseRepository auditUniverseRepository;

    @Override
    public ResultWrapper<AuditUniverseDTO> registerAuditUniverse(AuditUniverseDTO auditUniverseDTO) {
        ResultWrapper<AuditUniverseDTO> resultWrapper = new ResultWrapper<>(auditUniverseDTO);

        List<AuditUniverse> auditUniverseName=auditUniverseRepository.findAuditUniverseByStateAndName(AuditUniverseStatus.Active.name(), auditUniverseDTO.getName());
        if (auditUniverseDTO.getName() == null){
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Universe name cannot be null.");
        }else if(!auditUniverseName.isEmpty()){
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Universe duplicate name is not allowed.");
        }else if(auditUniverseDTO.getAuditType() == null){
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Universe audit type cannot be null.");
        }else {

            AuditUniverse auditUniverse = AuditUniverseMapper.INSTANCE.toEntity(auditUniverseDTO);
            auditUniverse.setCreatedTimestamp(LocalDateTime.now());
            auditUniverse.setCreatedUser("TODO");
            auditUniverse.setStatus(AuditUniverseStatus.Active.getType());
            AuditUniverse savedUniverse = auditUniverseRepository.save(auditUniverse);
            resultWrapper.setResult(AuditUniverseMapper.INSTANCE.toDTO(savedUniverse));
            resultWrapper.setStatus(true);
            resultWrapper.setMessage("Audit Universe created successfully.");
        }

        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AuditUniverseDTO>> getAllAuditUniverse() {
        ResultWrapper<List<AuditUniverseDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditUniverse> auditUniverses=auditUniverseRepository.findAll();
        if (!auditUniverses.isEmpty()){
            List<AuditUniverseDTO> auditUniverseDTOS = AuditUniverseMapper.INSTANCE.auditUniversesToAuditUniverseDTOs(auditUniverses);
            resultWrapper.setResult(auditUniverseDTOS);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public List<AuditUniverse> getAllActiveAuditUniverse() {
        List<AuditUniverse> auditUniverses=auditUniverseRepository.findAuditUniverseByState(AuditUniverseStatus.Active.name());

        return auditUniverses;
    }

    @Override
    public Optional<AuditUniverse> findAuditUniverseById(Long id) {

        return auditUniverseRepository.findById(id);
    }

    @Override
    public ResultWrapper<AuditUniverseDTO> getAuditUniverseById(Long id) {

        ResultWrapper<AuditUniverseDTO> resultWrapper = new ResultWrapper<>();
        AuditUniverse auditUniverse=auditUniverseRepository.findById(id).orElse(null);
        if (auditUniverse != null){
            AuditUniverseDTO auditUniverseDTO = AuditUniverseMapper.INSTANCE.toDTO(auditUniverse);
            resultWrapper.setResult(auditUniverseDTO);
            resultWrapper.setStatus(true);
        }else{
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Universe with the provided id not found.");
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<AuditUniverseDTO> updateAuditUniverse(AuditUniverseDTO auditUniverseDTO) {
        ResultWrapper<AuditUniverseDTO> resultWrapper = new ResultWrapper<>(auditUniverseDTO);

        AuditUniverse oldUniverse = auditUniverseRepository.findById(auditUniverseDTO.getId()).orElse(null);

        if (oldUniverse != null){
        if (auditUniverseDTO.getName() == null){
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Universe name cannot be null.");
        }else if(auditUniverseDTO.getAuditType() == null){
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Universe audit type cannot be null.");
        }else {

            AuditUniverse auditUniverse = AuditUniverseMapper.INSTANCE.toEntity(auditUniverseDTO);


            auditUniverse.setCreatedTimestamp(oldUniverse.getCreatedTimestamp());
            auditUniverse.setCreatedUser(oldUniverse.getCreatedUser());

            AuditUniverse savedUniverse = auditUniverseRepository.save(auditUniverse);
            resultWrapper.setResult(AuditUniverseMapper.INSTANCE.toDTO(savedUniverse));
            resultWrapper.setStatus(true);
            resultWrapper.setMessage("Audit Universe updated successfully.");
        }
        }else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Universe with the provided id is not available.");
        }

        return resultWrapper;
    }
}
