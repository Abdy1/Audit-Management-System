package com.cbo.audit.mapper;

import com.cbo.audit.dto.EngagementDTO;
import com.cbo.audit.persistence.model.EngagementInfo;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T13:54:46+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class EngagementMapperImpl implements EngagementMapper {

    @Override
    public EngagementDTO toDTO(EngagementInfo user) {
        if ( user == null ) {
            return null;
        }

        EngagementDTO engagementDTO = new EngagementDTO();

        return engagementDTO;
    }

    @Override
    public void copyToDTO(EngagementInfo user, EngagementDTO userDTO) {
        if ( user == null ) {
            return;
        }
    }

    @Override
    public EngagementInfo toEntity(EngagementDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        EngagementInfo engagementInfo = new EngagementInfo();

        return engagementInfo;
    }
}
