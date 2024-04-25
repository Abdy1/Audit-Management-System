package com.cbo.audit.service;

import com.cbo.audit.dto.ChecklistItemDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.persistence.model.ChecklistItem;

import java.util.List;

public interface ChecklistItemService {

    ResultWrapper<ChecklistItemDTO> registerChecklistItem(ChecklistItemDTO checklistItemDTO);

    ResultWrapper<List<ChecklistItemDTO>> getAllChecklistItem();

    ResultWrapper<ChecklistItemDTO> getChecklistItemById(Long id);

    ChecklistItem findChecklistItemById(Long id);

    ResultWrapper<ChecklistItemDTO> updateChecklistItem(ChecklistItemDTO checklistItemDTO);

    ResultWrapper<List<ChecklistItemDTO>> getChecklistItemByAuditableAreaId(Long id);

    ResultWrapper<ChecklistItemDTO> deleteChecklistItem(ChecklistItemDTO checklistItemDTO);


    /*    ResultWrapper<List<ChecklistItemDTO>> getChecklistItemByAuditObjectId(Long id);*/
}
