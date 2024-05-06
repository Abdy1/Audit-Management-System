package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditTypeDTO;
import com.cbo.audit.persistence.model.AuditType;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T13:54:46+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class AuditTypeMapperImpl implements AuditTypeMapper {

    @Override
    public AuditTypeDTO toDTO(AuditType auditType) {
        if ( auditType == null ) {
            return null;
        }

        AuditTypeDTO auditTypeDTO = new AuditTypeDTO();

        return auditTypeDTO;
    }

    @Override
    public void copyToDTO(AuditType auditType, AuditTypeDTO auditTypeDTO) {
        if ( auditType == null ) {
            return;
        }
    }

    @Override
    public AuditType toEntity(AuditTypeDTO auditTypeDTO) {
        if ( auditTypeDTO == null ) {
            return null;
        }

        AuditType auditType = new AuditType();

        return auditType;
    }
}
