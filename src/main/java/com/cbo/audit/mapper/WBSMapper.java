package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditProgramDTO;
import com.cbo.audit.dto.AuditProgramWBSDTO;
import com.cbo.audit.persistence.model.AuditProgram;
import com.cbo.audit.persistence.model.WBS;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface WBSMapper {



    WBSMapper INSTANCE = Mappers.getMapper(WBSMapper.class);

    AuditProgramWBSDTO toDTO(WBS wbs);

    void copyToDTO(WBS wbs, @MappingTarget AuditProgramWBSDTO auditProgramWBSDTO);

    WBS toEntity(AuditProgramWBSDTO auditProgramWBSDTO);

    default List<AuditProgramWBSDTO> wbsToAuditProgramWBSDTOs(List<WBS> wbss) {
        if (wbss == null) {
            return null;
        }

        List<AuditProgramWBSDTO> list = new ArrayList<AuditProgramWBSDTO>(wbss.size());
        for (WBS wbs : wbss) {
            list.add(toDTO(wbs));
        }

        return list;
    }

}

