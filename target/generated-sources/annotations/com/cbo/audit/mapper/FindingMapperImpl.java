package com.cbo.audit.mapper;

import com.cbo.audit.dto.FindingDTO;
import com.cbo.audit.persistence.model.Finding;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T13:54:46+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class FindingMapperImpl implements FindingMapper {

    @Override
    public FindingDTO toDTO(Finding finding) {
        if ( finding == null ) {
            return null;
        }

        FindingDTO findingDTO = new FindingDTO();

        return findingDTO;
    }

    @Override
    public void copyToDTO(Finding finding, FindingDTO findingDTO) {
        if ( finding == null ) {
            return;
        }
    }

    @Override
    public Finding toEntity(FindingDTO findingDTO) {
        if ( findingDTO == null ) {
            return null;
        }

        Finding finding = new Finding();

        return finding;
    }
}
