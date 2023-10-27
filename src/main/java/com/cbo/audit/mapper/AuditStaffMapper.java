package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditStaffDTO;
import com.cbo.audit.persistence.model.AuditStaff;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AuditStaffMapper {

    AuditStaffMapper INSTANCE = Mappers.getMapper(AuditStaffMapper.class);

    AuditStaffDTO toDTO(AuditStaff auditStaff);

    void copyToDTO(AuditStaff auditStaff, @MappingTarget AuditStaffDTO auditStaffDTO);

    AuditStaff toEntity(AuditStaffDTO auditStaffDTO);

    default List<AuditStaffDTO> auditStaffsToAuditStaffDTOs(List<AuditStaff> auditStaffs) {
        if (auditStaffs == null) {
            return null;
        }

        List<AuditStaffDTO> list = new ArrayList<AuditStaffDTO>(auditStaffs.size());
        for (AuditStaff auditStaff : auditStaffs) {
            list.add(toDTO(auditStaff));
        }

        return list;
    }
}
