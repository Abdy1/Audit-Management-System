package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditProgramObjectiveDTO;
import com.cbo.audit.persistence.model.AuditProgramObjective;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T13:54:46+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class AuditProgramObjectiveMapperImpl implements AuditProgramObjectiveMapper {

    @Override
    public AuditProgramObjectiveDTO toDTO(AuditProgramObjective auditProgramObjective) {
        if ( auditProgramObjective == null ) {
            return null;
        }

        AuditProgramObjectiveDTO auditProgramObjectiveDTO = new AuditProgramObjectiveDTO();

        return auditProgramObjectiveDTO;
    }

    @Override
    public void copyToDTO(AuditProgramObjective auditProgramObjective, AuditProgramObjectiveDTO auditProgramObjectiveDTO) {
        if ( auditProgramObjective == null ) {
            return;
        }
    }

    @Override
    public AuditProgramObjective toEntity(AuditProgramObjectiveDTO auditProgramObjectiveDTO) {
        if ( auditProgramObjectiveDTO == null ) {
            return null;
        }

        AuditProgramObjective auditProgramObjective = new AuditProgramObjective();

        return auditProgramObjective;
    }
}
