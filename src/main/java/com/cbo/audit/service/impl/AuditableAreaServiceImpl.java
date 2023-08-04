package com.cbo.audit.service.impl;

import com.cbo.audit.dto.AuditableAreaDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.mapper.AuditableAreaMapper;
import com.cbo.audit.persistence.model.AuditableArea;
import com.cbo.audit.persistence.repository.AuditableAreaRepository;
import com.cbo.audit.service.AuditableAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service("auditableAreaService")
@Transactional
public class AuditableAreaServiceImpl implements AuditableAreaService {


    @Autowired
    private AuditableAreaRepository auditableAreaRepository;


    @Override
    public ResultWrapper<AuditableAreaDTO> registerAuditableArea(AuditableAreaDTO auditableAreaDTO) {
        ResultWrapper<AuditableAreaDTO> resultWrapper = new ResultWrapper<>(auditableAreaDTO);

        List<AuditableArea> auditableAreaName = auditableAreaRepository.findByName(auditableAreaDTO.getName());
        if (auditableAreaDTO.getName() == null){
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Universe name cannot be null.");
        }else if(!auditableAreaName.isEmpty()){
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Universe duplicate name is not allowed.");
        }else {

            AuditableArea auditableArea = AuditableAreaMapper.INSTANCE.toEntity(auditableAreaDTO);
            auditableArea.setCreatedTimestamp(LocalDateTime.now());
            auditableArea.setCreatedUser("TODO");
            AuditableArea savedUniverse = auditableAreaRepository.save(auditableArea);
            resultWrapper.setResult(AuditableAreaMapper.INSTANCE.toDTO(savedUniverse));
            resultWrapper.setStatus(true);
            resultWrapper.setMessage("Audit Universe created successfully.");
        }

        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AuditableAreaDTO>> getAllAuditableArea() {
        ResultWrapper<List<AuditableAreaDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditableArea> auditableAreas=auditableAreaRepository.findAll();
        if (!auditableAreas.isEmpty()){
            List<AuditableAreaDTO> auditableAreaDTOS = AuditableAreaMapper.INSTANCE.auditableAreasToAuditableAreaDTOs(auditableAreas);
            resultWrapper.setResult(auditableAreaDTOS);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public Optional<AuditableArea> findAuditableAreaById(Long id) {

        return auditableAreaRepository.findById(id);
    }

    @Override
    public ResultWrapper<AuditableAreaDTO> getAuditableAreaById(Long id) {

        ResultWrapper<AuditableAreaDTO> resultWrapper = new ResultWrapper<>();
        AuditableArea auditableArea=auditableAreaRepository.findById(id).orElse(null);
        if (auditableArea != null){
            AuditableAreaDTO auditableAreaDTO = AuditableAreaMapper.INSTANCE.toDTO(auditableArea);
            resultWrapper.setResult(auditableAreaDTO);
            resultWrapper.setStatus(true);
        }else{
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Universe with the provided id not found.");
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<AuditableAreaDTO> updateAuditableArea(AuditableAreaDTO auditableAreaDTO) {
        ResultWrapper<AuditableAreaDTO> resultWrapper = new ResultWrapper<>(auditableAreaDTO);

        AuditableArea oldUniverse = auditableAreaRepository.findById(auditableAreaDTO.getId()).orElse(null);

        if (oldUniverse != null){
            if (auditableAreaDTO.getName() == null){
                resultWrapper.setStatus(false);
                resultWrapper.setMessage("Audit Universe name cannot be null.");
            }else{

                AuditableArea auditableArea = AuditableAreaMapper.INSTANCE.toEntity(auditableAreaDTO);

                auditableArea.setCreatedTimestamp(oldUniverse.getCreatedTimestamp());
                auditableArea.setCreatedUser(oldUniverse.getCreatedUser());

                AuditableArea savedUniverse = auditableAreaRepository.save(auditableArea);
                resultWrapper.setResult(AuditableAreaMapper.INSTANCE.toDTO(savedUniverse));
                resultWrapper.setStatus(true);
                resultWrapper.setMessage("Audit Universe created successfully.");
            }
        }else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Universe with the provided id is not available.");
        }

        return resultWrapper;
    }

}
