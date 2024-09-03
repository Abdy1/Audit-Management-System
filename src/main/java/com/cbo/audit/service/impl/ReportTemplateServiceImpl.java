package com.cbo.audit.service.impl;

import com.cbo.audit.dto.ReportTemplateDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.RiskLevelDTO;
import com.cbo.audit.mapper.ReportTemplateMapper;
import com.cbo.audit.mapper.RiskLevelMapper;
import com.cbo.audit.persistence.model.ReportTemplate;
import com.cbo.audit.persistence.model.RiskLevel;
import com.cbo.audit.persistence.repository.ReportTemplateRepository;
import com.cbo.audit.service.ReportTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service("reportTemplateService")
@Transactional
public class ReportTemplateServiceImpl implements ReportTemplateService {
    private static final Logger loger = LoggerFactory.getLogger(ReportTemplateServiceImpl.class);

    @Autowired
    private ReportTemplateRepository reportTemplateRepository;


    @Override
    public ResultWrapper<List<ReportTemplateDTO>> getReportTemplate() {
         ResultWrapper<List<ReportTemplateDTO>> result = new ResultWrapper<>();
         List<ReportTemplate> reportTemplates = reportTemplateRepository.findAll();


       if(reportTemplates.isEmpty()) {
           result.setResult(new ArrayList<>());
           result.setStatus(false);
           result.setMessage("No Template");
       }else {
           result.setResult(ReportTemplateMapper.INSTANCE.ReportTemplateToReportTemplateDTOs(reportTemplates));
       }
         return result;

    }


}
