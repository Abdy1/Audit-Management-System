package com.cbo.audit.mapper;

import com.cbo.audit.dto.AmendedFindingDTO;
import com.cbo.audit.dto.ReportTemplateDTO;
import com.cbo.audit.persistence.model.AmendedFinding;
import com.cbo.audit.persistence.model.Report;
import com.cbo.audit.persistence.model.ReportTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface ReportTemplateMapper {

    ReportTemplateMapper INSTANCE = Mappers.getMapper(ReportTemplateMapper.class);

    ReportTemplateDTO toDTO(ReportTemplate reportTemplate);


    ReportTemplate toEntity(ReportTemplateDTO reportTemplateDTO);

    default List<ReportTemplateDTO> ReportTemplateToReportTemplateDTOs(List<ReportTemplate> reportTemplates) {
        if (reportTemplates == null) {
            return null;
        }

        List<ReportTemplateDTO> list = new ArrayList<ReportTemplateDTO>(reportTemplates.size());
        for (ReportTemplate reportTemplate : reportTemplates) {
            list.add(toDTO(reportTemplate));
        }

        return list;
    }
}
