package com.cbo.audit.service.impl;

import com.cbo.audit.dto.ChecklistItemDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.mapper.ChecklistItemMapper;
import com.cbo.audit.persistence.model.AuditableArea;
import com.cbo.audit.persistence.model.ChecklistItem;
import com.cbo.audit.persistence.repository.ChecklistItemRepository;
import com.cbo.audit.service.AuditableAreaService;
import com.cbo.audit.service.ChecklistItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service("checklistItemService")
@Transactional
public class ChecklistItemServiceImpl implements ChecklistItemService {


    @Autowired
    private ChecklistItemRepository checklistItemRepository;

    @Autowired
    private AuditableAreaService auditableAreaService;

    @Override
    public ResultWrapper registerChecklistItem(ChecklistItemDTO checklistItemDTO) {

        if (checklistItemDTO.getName() == null) {
            return new ResultWrapper<>(null, false, "Checklist Item name cannot be null.");
        }

        Optional<AuditableArea> auditableAreaOpt = auditableAreaService.findAuditableAreaById(checklistItemDTO.getAuditableArea().getId());
        if (!auditableAreaOpt.isPresent()) {
            return new ResultWrapper<>(null, false, "Auditable area with the provided information is not available.");
        }

        AuditableArea auditableArea = auditableAreaOpt.get();
        ChecklistItem checklistItem = new ChecklistItem();
        checklistItem.setName(checklistItemDTO.getName());
        checklistItem.setCreatedTimestamp(LocalDateTime.now());
        checklistItem.setAuditableArea(auditableArea);
        checklistItem.setDescription(checklistItemDTO.getDescription());
        checklistItem.setCreatedUser(checklistItemDTO.getCreatedUser());

        ChecklistItem savedChecklistItem = checklistItemRepository.save(checklistItem);
        checklistItemDTO.setId(savedChecklistItem.getId());

        return new ResultWrapper<>(checklistItemDTO, true, "Checklist Item created successfully.");
    }

    @Override
    public ResultWrapper<List<ChecklistItemDTO>> getAllChecklistItem() {
        ResultWrapper<List<ChecklistItemDTO>> resultWrapper = new ResultWrapper<>();
        List<ChecklistItem> checklistItems = checklistItemRepository.findAll();
        if (!checklistItems.isEmpty()) {
            List<ChecklistItemDTO> checklistItemDTOS = ChecklistItemMapper.INSTANCE.checklistItemsToChecklistItemDTOs(checklistItems);
            resultWrapper.setResult(checklistItemDTOS);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }


    @Override
    public ResultWrapper<ChecklistItemDTO> getChecklistItemById(Long id) {

        ResultWrapper<ChecklistItemDTO> resultWrapper = new ResultWrapper<>();
        ChecklistItem checklistItem = checklistItemRepository.findById(id).orElse(null);
        if (checklistItem != null) {
            ChecklistItemDTO checklistItemDTO = ChecklistItemMapper.INSTANCE.toDTO(checklistItem);
            resultWrapper.setResult(checklistItemDTO);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public ChecklistItem findChecklistItemById(Long id) {
        return checklistItemRepository.findById(id).orElse(null);
    }

    @Override
    public ResultWrapper<List<ChecklistItemDTO>> getChecklistItemByAuditableAreaId(Long id) {

        ResultWrapper<List<ChecklistItemDTO>> resultWrapper = new ResultWrapper<>();
        List<ChecklistItem> checklistItems = checklistItemRepository.findChecklistItemByAuditableAreaId(id);
        if (checklistItems != null) {
            List<ChecklistItemDTO> checklistItemDTOS = ChecklistItemMapper.INSTANCE.checklistItemsToChecklistItemDTOs(checklistItems);
            resultWrapper.setResult(checklistItemDTOS);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<ChecklistItemDTO> deleteChecklistItem(ChecklistItemDTO checklistItemDTO) {
        ResultWrapper<ChecklistItemDTO> resultWrapper = new ResultWrapper<>(checklistItemDTO);

        ChecklistItem oldChecklist = checklistItemRepository.findById(checklistItemDTO.getId()).orElse(null);

        if (oldChecklist != null) {

            checklistItemRepository.delete(oldChecklist);
            resultWrapper.setStatus(true);
            resultWrapper.setMessage("Checklist Item deleted successfully.");
        } else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("CheckList with the provided id is not available.");
        }

        return resultWrapper;
    }

    @Override
    public ResultWrapper<ChecklistItemDTO> updateChecklistItem(ChecklistItemDTO checklistItemDTO) {
        ResultWrapper<ChecklistItemDTO> resultWrapper = new ResultWrapper<>(checklistItemDTO);

        ChecklistItem oldChecklist = checklistItemRepository.findById(checklistItemDTO.getId()).orElse(null);

        if (oldChecklist != null) {
            if (checklistItemDTO.getName() == null) {
                resultWrapper.setStatus(false);
                resultWrapper.setMessage("Audit Object name cannot be null.");
            }
            {

                ChecklistItem checklistItem = ChecklistItemMapper.INSTANCE.toEntity(checklistItemDTO);

                checklistItem.setCreatedTimestamp(oldChecklist.getCreatedTimestamp());
                checklistItem.setModifiedUser(oldChecklist.getModifiedUser());
                checklistItem.setAuditableArea(oldChecklist.getAuditableArea());


                ChecklistItem savedUniverse = checklistItemRepository.save(checklistItem);
                resultWrapper.setResult(ChecklistItemMapper.INSTANCE.toDTO(savedUniverse));
                resultWrapper.setStatus(true);
                resultWrapper.setMessage("Checklist Item updated successfully.");
            }
        } else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("CheckList with the provided id is not available.");
        }

        return resultWrapper;
    }
}
