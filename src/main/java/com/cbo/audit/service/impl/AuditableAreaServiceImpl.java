package com.cbo.audit.service.impl;

import com.cbo.audit.dto.AuditableAreaDTO;
import com.cbo.audit.dto.ChecklistItemDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.mapper.AuditableAreaMapper;
import com.cbo.audit.mapper.ChecklistItemMapper;
import com.cbo.audit.persistence.model.AuditObject;
import com.cbo.audit.persistence.model.AuditableArea;
import com.cbo.audit.persistence.repository.AuditableAreaRepository;
import com.cbo.audit.service.AuditObjectService;
import com.cbo.audit.service.AuditableAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service("auditableAreaService")
@Transactional
public class AuditableAreaServiceImpl implements AuditableAreaService {


    @Autowired
    private AuditableAreaRepository auditableAreaRepository;

    @Autowired
    private AuditObjectService auditObjectService;


    @Override
    public ResultWrapper<AuditableAreaDTO> registerAuditableArea(AuditableAreaDTO auditableAreaDTO) {
        ResultWrapper<AuditableAreaDTO> resultWrapper = new ResultWrapper<>(auditableAreaDTO);

        List<AuditableArea> auditableAreaName = auditableAreaRepository.findByName(auditableAreaDTO.getName());

        Optional<AuditObject> auditObject = auditObjectService.findAuditObjectById(auditableAreaDTO.getAuditObject().getId());

        if (auditableAreaDTO.getName() == null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Auditable Area name cannot be null.");
        } else if (!auditableAreaName.isEmpty()) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Auditable Area duplicate name is not allowed.");
        } else if (!auditObject.isPresent()) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit object cannot be null.");
        } else {

            resultWrapper.setResult(AuditableAreaMapper.INSTANCE.toDTO(saveAuditableArea(auditableAreaDTO, auditObject.get())));
            resultWrapper.setStatus(true);
            resultWrapper.setMessage("AuditableArea created successfully.");
        }

        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AuditableAreaDTO>> getAllAuditableArea() {
        ResultWrapper<List<AuditableAreaDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditableArea> auditableAreas = auditableAreaRepository.findAll();
        if (!auditableAreas.isEmpty()) {
            List<AuditableAreaDTO> auditableAreaDTOS = AuditableAreaMapper.INSTANCE.auditableAreasToAuditableAreaDTOs(auditableAreas);
            resultWrapper.setResult(auditableAreaDTOS);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<ChecklistItemDTO>> getCheckListsByAuditObjectId(Long auditObjectId) {
        ResultWrapper<List<ChecklistItemDTO>> resultWrapper = new ResultWrapper<>();
        List<ChecklistItemDTO> checklistItemDTOS = new ArrayList<>();
        List<AuditableArea> auditableAreas = auditableAreaRepository.findAuditableAreasByAuditObjectId(auditObjectId);
        for (AuditableArea auditableArea : auditableAreas) {
            checklistItemDTOS.addAll(ChecklistItemMapper.INSTANCE.checklistItemsToChecklistItemDTOs(auditableArea.getChecklistItems()));
        }
        resultWrapper.setResult(checklistItemDTOS);
        resultWrapper.setStatus(true);
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AuditableAreaDTO>> getAuditableAreasByAuditObjectId(Long auditObjectId) {

        ResultWrapper<List<AuditableAreaDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditableArea> auditableAreas = auditableAreaRepository.findAuditableAreasByAuditObjectId(auditObjectId);
        if (!auditableAreas.isEmpty()) {
            List<AuditableAreaDTO> auditableAreaDTOS = AuditableAreaMapper.INSTANCE.auditableAreasToAuditableAreaDTOs(auditableAreas);
            resultWrapper.setResult(auditableAreaDTOS);
            resultWrapper.setStatus(true);
        }else {
            resultWrapper.setResult(new ArrayList<>());
            resultWrapper.setStatus(true);
            resultWrapper.setMessage("There is no auditable area with the provided id");
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
        AuditableArea auditableArea = auditableAreaRepository.findById(id).orElse(null);
        if (auditableArea != null) {
            AuditableAreaDTO auditableAreaDTO = AuditableAreaMapper.INSTANCE.toDTO(auditableArea);
            resultWrapper.setResult(auditableAreaDTO);
            resultWrapper.setStatus(true);
        } else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Auditable Area with the provided id not found.");
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<AuditableAreaDTO> updateAuditableArea(AuditableAreaDTO auditableAreaDTO) {
        ResultWrapper<AuditableAreaDTO> resultWrapper = new ResultWrapper<>(auditableAreaDTO);

        AuditableArea oldAuditableArea = auditableAreaRepository.findById(auditableAreaDTO.getId()).orElse(null);

        if (oldAuditableArea != null) {
            if (auditableAreaDTO.getName() == null) {
                resultWrapper.setStatus(false);
                resultWrapper.setMessage("AuditableArea name cannot be null.");
            } else {

                AuditableArea auditableArea = AuditableAreaMapper.INSTANCE.toEntity(auditableAreaDTO);
                auditableArea.setCreatedTimestamp(oldAuditableArea.getCreatedTimestamp());
                auditableArea.setCreatedUser(oldAuditableArea.getCreatedUser());
                auditableArea.setAuditObject(oldAuditableArea.getAuditObject());

                AuditableArea savedAuditableArea = auditableAreaRepository.save(auditableArea);
                resultWrapper.setResult(AuditableAreaMapper.INSTANCE.toDTO(savedAuditableArea));
                resultWrapper.setStatus(true);
                resultWrapper.setMessage("Auditable Area updated successfully.");
            }
        } else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Auditable Area with the provided id is not available.");
        }

        return resultWrapper;
    }

    @Override
    public ResultWrapper<AuditableAreaDTO> deleteAuditableArea(AuditableAreaDTO auditableAreaDTO) {
        ResultWrapper<AuditableAreaDTO> resultWrapper = new ResultWrapper<>(auditableAreaDTO);

        AuditableArea oldAuditableArea = auditableAreaRepository.findById(auditableAreaDTO.getId()).orElse(null);

        if (oldAuditableArea != null) {
            auditableAreaRepository.delete(oldAuditableArea);
            resultWrapper.setStatus(true);
            resultWrapper.setMessage("Auditable Area deleted successfully.");
        } else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Auditable Area with the provided id is not found.");
        }

        return resultWrapper;
    }

    public ResultWrapper<List<ChecklistItemDTO>> getCheckListsByUniverseId(Long auditUniverseId) {
        ResultWrapper<List<ChecklistItemDTO>> resultWrapper = new ResultWrapper<>();
        List<ChecklistItemDTO> checklistItemDTOS = new ArrayList<>();
        List<AuditableArea> auditableAreas = auditableAreaRepository.findAuditableAreasByAUniverseId(auditUniverseId);
        if(auditableAreas.isEmpty()){
            resultWrapper.setResult(null);
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("No checklist found.");

            return resultWrapper;
        }
        for (AuditableArea auditableArea : auditableAreas) {
            checklistItemDTOS.addAll(ChecklistItemMapper.INSTANCE.checklistItemsToChecklistItemDTOs(auditableArea.getChecklistItems()));
        }
        resultWrapper.setResult(checklistItemDTOS);
        resultWrapper.setStatus(true);
        return resultWrapper;
    }

    private AuditableArea saveAuditableArea(AuditableAreaDTO auditableAreaDTO, AuditObject auditObject){
        AuditableArea auditableArea = AuditableAreaMapper.INSTANCE.toEntity(auditableAreaDTO);
        auditableArea.setCreatedTimestamp(LocalDateTime.now());
        auditableArea.setAuditObject(auditObject);

        return auditableAreaRepository.save(auditableArea);
    }
}
