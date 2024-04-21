package com.cbo.audit.mapper;

import com.cbo.audit.dto.EngagementDTO;
import com.cbo.audit.persistence.model.EngagementInfo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
@Mapper(componentModel = "spring")
public interface EngagementMapper {

        EngagementMapper INSTANCE = Mappers.getMapper(EngagementMapper.class);

        EngagementDTO toDTO(EngagementInfo user);

        void copyToDTO(EngagementInfo user, @MappingTarget EngagementDTO userDTO);

        EngagementInfo toEntity(EngagementDTO userDTO);

        default List<EngagementDTO> engagementInfosToEngagementDTOs(List<EngagementInfo> engagementInfos) {
            if (engagementInfos == null) {
                return null;
            }

            List<EngagementDTO> list = new ArrayList<EngagementDTO>(engagementInfos.size());
            for (EngagementInfo engagementInfo : engagementInfos) {
                list.add(toDTO(engagementInfo));
            }

            return list;
        }
}
