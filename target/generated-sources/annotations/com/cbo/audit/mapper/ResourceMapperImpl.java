package com.cbo.audit.mapper;

import com.cbo.audit.dto.ResourceDTO;
import com.cbo.audit.persistence.model.Resource;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T13:54:46+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ResourceMapperImpl implements ResourceMapper {

    @Override
    public ResourceDTO toDTO(Resource resource) {
        if ( resource == null ) {
            return null;
        }

        ResourceDTO resourceDTO = new ResourceDTO();

        return resourceDTO;
    }

    @Override
    public void copyToDTO(Resource resource, ResourceDTO resourceDTO) {
        if ( resource == null ) {
            return;
        }
    }

    @Override
    public Resource toEntity(ResourceDTO resourceDTO) {
        if ( resourceDTO == null ) {
            return null;
        }

        Resource resource = new Resource();

        return resource;
    }
}
