package com.cbo.audit.mapper;

import com.cbo.audit.dto.AuditProgramWBSDTO;
import com.cbo.audit.persistence.model.WBS;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T13:54:46+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class WBSMapperImpl implements WBSMapper {

    @Override
    public AuditProgramWBSDTO toDTO(WBS wbs) {
        if ( wbs == null ) {
            return null;
        }

        AuditProgramWBSDTO auditProgramWBSDTO = new AuditProgramWBSDTO();

        return auditProgramWBSDTO;
    }

    @Override
    public void copyToDTO(WBS wbs, AuditProgramWBSDTO auditProgramWBSDTO) {
        if ( wbs == null ) {
            return;
        }
    }

    @Override
    public WBS toEntity(AuditProgramWBSDTO auditProgramWBSDTO) {
        if ( auditProgramWBSDTO == null ) {
            return null;
        }

        WBS wBS = new WBS();

        return wBS;
    }
}
