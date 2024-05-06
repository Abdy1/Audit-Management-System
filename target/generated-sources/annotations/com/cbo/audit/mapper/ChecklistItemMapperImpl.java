package com.cbo.audit.mapper;

import com.cbo.audit.dto.ChecklistItemDTO;
import com.cbo.audit.persistence.model.ChecklistItem;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T13:54:46+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ChecklistItemMapperImpl implements ChecklistItemMapper {

    @Override
    public ChecklistItemDTO toDTO(ChecklistItem checklistItem) {
        if ( checklistItem == null ) {
            return null;
        }

        ChecklistItemDTO checklistItemDTO = new ChecklistItemDTO();

        return checklistItemDTO;
    }

    @Override
    public void copyToDTO(ChecklistItem checklistItem, ChecklistItemDTO checklistItemDTO) {
        if ( checklistItem == null ) {
            return;
        }
    }

    @Override
    public ChecklistItem toEntity(ChecklistItemDTO checklistItemDTO) {
        if ( checklistItemDTO == null ) {
            return null;
        }

        ChecklistItem checklistItem = new ChecklistItem();

        return checklistItem;
    }
}
