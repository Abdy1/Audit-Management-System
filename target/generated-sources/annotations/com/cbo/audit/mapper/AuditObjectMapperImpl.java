package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditObjectDTO;
import com.cbo.audit.persistence.model.AuditObject;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T13:54:46+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class AuditObjectMapperImpl implements AuditObjectMapper {

    @Override
    public AuditObjectDTO toDTO(AuditObject auditObject) {
        if ( auditObject == null ) {
            return null;
        }

        AuditObjectDTO auditObjectDTO = new AuditObjectDTO();

        return auditObjectDTO;
    }

    @Override
    public void copyToDTO(AuditObject auditObject, AuditObjectDTO auditObjectDTO) {
        if ( auditObject == null ) {
            return;
        }
    }

    @Override
    public AuditObject toEntity(AuditObjectDTO auditObjectDTO) {
        if ( auditObjectDTO == null ) {
            return null;
        }

        AuditObject auditObject = new AuditObject();

        return auditObject;
    }
}
