package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditStaffDTO;
import com.cbo.audit.persistence.model.AuditStaff;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T13:54:46+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class AuditStaffMapperImpl implements AuditStaffMapper {

    @Override
    public AuditStaffDTO toDTO(AuditStaff auditStaff) {
        if ( auditStaff == null ) {
            return null;
        }

        AuditStaffDTO auditStaffDTO = new AuditStaffDTO();

        return auditStaffDTO;
    }

    @Override
    public void copyToDTO(AuditStaff auditStaff, AuditStaffDTO auditStaffDTO) {
        if ( auditStaff == null ) {
            return;
        }
    }

    @Override
    public AuditStaff toEntity(AuditStaffDTO auditStaffDTO) {
        if ( auditStaffDTO == null ) {
            return null;
        }

        AuditStaff auditStaff = new AuditStaff();

        return auditStaff;
    }
}
