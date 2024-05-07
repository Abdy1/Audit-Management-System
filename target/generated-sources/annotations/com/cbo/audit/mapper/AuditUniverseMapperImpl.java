package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditUniverseDTO;
import com.cbo.audit.persistence.model.AuditUniverse;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T13:54:46+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class AuditUniverseMapperImpl implements AuditUniverseMapper {

    @Override
    public AuditUniverseDTO toDTO(AuditUniverse auditUniverse) {
        if ( auditUniverse == null ) {
            return null;
        }

        AuditUniverseDTO auditUniverseDTO = new AuditUniverseDTO();

        return auditUniverseDTO;
    }

    @Override
    public void copyToDTO(AuditUniverse auditUniverse, AuditUniverseDTO auditUniverseDTO) {
        if ( auditUniverse == null ) {
            return;
        }
    }

    @Override
    public AuditUniverse toEntity(AuditUniverseDTO auditUniverseDTO) {
        if ( auditUniverseDTO == null ) {
            return null;
        }

        AuditUniverse auditUniverse = new AuditUniverse();

        return auditUniverse;
    }
}
