package com.cbo.audit.mapper;

import com.cbo.audit.dto.ReportDTO;
import com.cbo.audit.persistence.model.Report;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-27T10:50:06+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
public class ReportMapperImpl implements ReportMapper {

    @Override
    public ReportDTO toDTO(Report report) {
        if ( report == null ) {
            return null;
        }

        ReportDTO reportDTO = new ReportDTO();

        reportDTO.setId( report.getId() );
        reportDTO.setCreatedUser( report.getCreatedUser() );
        reportDTO.setModifiedUser( report.getModifiedUser() );
        reportDTO.setCreatedTimestamp( report.getCreatedTimestamp() );
        reportDTO.setModifiedTimestamp( report.getModifiedTimestamp() );

        return reportDTO;
    }

    @Override
    public void copyToDTO(Report report, ReportDTO reportDTO) {
        if ( report == null ) {
            return;
        }

        reportDTO.setId( report.getId() );
        reportDTO.setCreatedUser( report.getCreatedUser() );
        reportDTO.setModifiedUser( report.getModifiedUser() );
        reportDTO.setCreatedTimestamp( report.getCreatedTimestamp() );
        reportDTO.setModifiedTimestamp( report.getModifiedTimestamp() );
    }

    @Override
    public Report toEntity(ReportDTO reportDTO) {
        if ( reportDTO == null ) {
            return null;
        }

        Report report = new Report();

        report.setId( reportDTO.getId() );
        report.setCreatedUser( reportDTO.getCreatedUser() );
        report.setModifiedUser( reportDTO.getModifiedUser() );
        report.setCreatedTimestamp( reportDTO.getCreatedTimestamp() );
        report.setModifiedTimestamp( reportDTO.getModifiedTimestamp() );

        return report;
    }
}
