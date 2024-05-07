package com.cbo.audit.mapper;

import com.cbo.audit.dto.AmendedFindingDTO;
import com.cbo.audit.persistence.model.AmendedFinding;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T13:54:46+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class AmendedFindingMapperImpl implements AmendedFindingMapper {

    @Override
    public AmendedFindingDTO toDTO(AmendedFinding amendedFinding) {
        if ( amendedFinding == null ) {
            return null;
        }

        AmendedFindingDTO amendedFindingDTO = new AmendedFindingDTO();

        return amendedFindingDTO;
    }

    @Override
    public void copyToDTO(AmendedFinding amendedFinding, AmendedFindingDTO amendedFindingDTO) {
        if ( amendedFinding == null ) {
            return;
        }
    }

    @Override
    public AmendedFinding toEntity(AmendedFindingDTO amendedFindingDTO) {
        if ( amendedFindingDTO == null ) {
            return null;
        }

        AmendedFinding amendedFinding = new AmendedFinding();

        return amendedFinding;
    }
}
