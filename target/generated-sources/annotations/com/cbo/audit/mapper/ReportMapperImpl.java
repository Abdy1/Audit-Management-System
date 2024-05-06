package com.cbo.audit.mapper;

import com.cbo.audit.dto.ReportDTO;
import com.cbo.audit.persistence.model.Report;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T13:54:46+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class ReportMapperImpl implements ReportMapper {

    @Override
    public ReportDTO toDTO(Report report) {
        if ( report == null ) {
            return null;
        }

        ReportDTO reportDTO = new ReportDTO();

        return reportDTO;
    }

    @Override
    public void copyToDTO(Report report, ReportDTO reportDTO) {
        if ( report == null ) {
            return;
        }
    }

    @Override
    public Report toEntity(ReportDTO reportDTO) {
        if ( reportDTO == null ) {
            return null;
        }

        Report report = new Report();

        return report;
    }
}
