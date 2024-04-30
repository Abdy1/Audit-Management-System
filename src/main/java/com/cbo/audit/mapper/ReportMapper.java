package com.cbo.audit.mapper;

import com.cbo.audit.dto.ReportDTO;
import com.cbo.audit.persistence.model.Report;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;


@Mapper
public interface ReportMapper {

    ReportMapper INSTANCE = Mappers.getMapper(ReportMapper.class);

    ReportDTO toDTO(Report report);

    void copyToDTO(Report report, @MappingTarget ReportDTO reportDTO);


    Report toEntity(ReportDTO reportDTO);

    default List<ReportDTO> ReportsToReportDTOs(List<Report> reports) {
        if (reports == null) {
            return null;
        }

        List<ReportDTO> list = new ArrayList<ReportDTO>(reports.size());
        for (Report report : reports) {

            list.add(toDTO(report));

        }

        return list;
    }
}
