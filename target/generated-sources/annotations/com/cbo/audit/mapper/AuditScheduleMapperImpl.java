package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.persistence.model.AuditSchedule;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T13:54:46+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class AuditScheduleMapperImpl implements AuditScheduleMapper {

    @Override
    public AuditScheduleDTO toDTO(AuditSchedule auditSchedule) {
        if ( auditSchedule == null ) {
            return null;
        }

        AuditScheduleDTO auditScheduleDTO = new AuditScheduleDTO();

        return auditScheduleDTO;
    }

    @Override
    public void copyToDTO(AuditSchedule auditSchedule, AuditScheduleDTO auditScheduleDTO) {
        if ( auditSchedule == null ) {
            return;
        }
    }

    @Override
    public AuditSchedule toEntity(AuditScheduleDTO auditScheduleDTO) {
        if ( auditScheduleDTO == null ) {
            return null;
        }

        AuditSchedule auditSchedule = new AuditSchedule();

        return auditSchedule;
    }
}
