package com.cbo.audit.mapper;

import com.cbo.audit.dto.ChecklistItemDTO;
import com.cbo.audit.persistence.model.ChecklistItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring")
public interface ChecklistItemMapper {

    ChecklistItemMapper INSTANCE = Mappers.getMapper(ChecklistItemMapper.class);

    ChecklistItemDTO toDTO(ChecklistItem checklistItem);

    void copyToDTO(ChecklistItem checklistItem, @MappingTarget ChecklistItemDTO checklistItemDTO);

    ChecklistItem toEntity(ChecklistItemDTO checklistItemDTO);

    default List<ChecklistItemDTO> checklistItemsToChecklistItemDTOs(List<ChecklistItem> checklistItems) {
        if (checklistItems == null) {
            return null;
        }

        List<ChecklistItemDTO> list = new ArrayList<ChecklistItemDTO>(checklistItems.size());
        for (ChecklistItem checklistItem : checklistItems) {
            list.add(toDTO(checklistItem));
        }

        return list;
    }
}