package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditProgramDTO;
import com.cbo.audit.persistence.model.AuditProgram;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T13:54:46+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class AuditProgramMapperImpl implements AuditProgramMapper {

    @Override
    public AuditProgramDTO toDTO(AuditProgram auditProgram) {
        if ( auditProgram == null ) {
            return null;
        }

        AuditProgramDTO auditProgramDTO = new AuditProgramDTO();

        return auditProgramDTO;
    }

    @Override
    public void copyToDTO(AuditProgram auditProgram, AuditProgramDTO auditProgramDTO) {
        if ( auditProgram == null ) {
            return;
        }
    }

    @Override
    public AuditProgram toEntity(AuditProgramDTO auditProgramDTO) {
        if ( auditProgramDTO == null ) {
            return null;
        }

        AuditProgram auditProgram = new AuditProgram();

        return auditProgram;
    }
}
