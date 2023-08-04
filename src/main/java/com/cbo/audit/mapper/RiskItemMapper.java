package com.cbo.audit.mapper;

import com.cbo.audit.dto.RiskItemDTO;
import com.cbo.audit.persistence.model.RiskItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring")
public interface RiskItemMapper {

    RiskItemMapper INSTANCE = Mappers.getMapper(RiskItemMapper.class);

    RiskItemDTO toDTO(RiskItem riskItem);

    void copyToDTO(RiskItem riskItem, @MappingTarget RiskItemDTO riskItemDTO);

    RiskItem toEntity(RiskItemDTO riskItemDTO);

    default List<RiskItemDTO> riskItemsToRiskItemDTOs(List<RiskItem> riskItems) {
        if (riskItems == null) {
            return null;
        }

        List<RiskItemDTO> list = new ArrayList<RiskItemDTO>(riskItems.size());
        for (RiskItem riskItem : riskItems) {
            list.add(toDTO(riskItem));
        }

        return list;
    }
}
