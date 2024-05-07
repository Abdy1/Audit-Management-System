package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditableAreaDTO;
import com.cbo.audit.persistence.model.AuditableArea;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T13:54:46+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class AuditableAreaMapperImpl implements AuditableAreaMapper {

    @Override
    public AuditableAreaDTO toDTO(AuditableArea auditableArea) {
        if ( auditableArea == null ) {
            return null;
        }

        AuditableAreaDTO auditableAreaDTO = new AuditableAreaDTO();

        return auditableAreaDTO;
    }

    @Override
    public void copyToDTO(AuditableArea auditableArea, AuditableAreaDTO auditableAreaDTO) {
        if ( auditableArea == null ) {
            return;
        }
    }

    @Override
    public AuditableArea toEntity(AuditableAreaDTO auditableAreaDTO) {
        if ( auditableAreaDTO == null ) {
            return null;
        }

        AuditableArea auditableArea = new AuditableArea();

        return auditableArea;
    }
}
