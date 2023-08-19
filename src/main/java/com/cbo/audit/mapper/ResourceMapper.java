package com.cbo.audit.mapper;

import com.cbo.audit.dto.ResourceDTO;
import com.cbo.audit.persistence.model.Resource;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ResourceMapper {

    ResourceMapper INSTANCE = Mappers.getMapper(ResourceMapper.class);

    ResourceDTO toDTO(Resource resource);

    void copyToDTO(Resource resource, @MappingTarget ResourceDTO resourceDTO);

    Resource toEntity(ResourceDTO resourceDTO);

    default List<ResourceDTO> resourcesToResourceDTOs(List<Resource> resources) {
        if (resources == null) {
            return null;
        }

        List<ResourceDTO> list = new ArrayList<ResourceDTO>(resources.size());
        for (Resource resource : resources) {
            list.add(toDTO(resource));
        }

        return list;
    }
}