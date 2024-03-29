package com.cbo.audit.service.impl;

import com.cbo.audit.dto.*;
import com.cbo.audit.mapper.*;
import com.cbo.audit.persistence.model.*;
import com.cbo.audit.persistence.repository.*;
import com.cbo.audit.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;
@Service
public class ReportServiceImpl implements ReportService
{
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private EngagementInfoRepository engagementInfoRepository;
    @Autowired
    private AuditProgramRepository auditProgramRepository;
    @Autowired
    private FindingRepository auditProgramFindingRepository;
    @Autowired
    private AuditProgramObjectiveRepository auditProgramObjectiveRepository;
    ReportDTO reportResultWrapper= new ReportDTO() ;
    public ResultWrapper<ReportDTO> generateDefaultReport(AuditScheduleDTO auditScheduleDTO) {
        ResultWrapper<ReportDTO> resultWrapper=new ResultWrapper<>();



        EngagementInfo engagementInfo = engagementInfoRepository.findAuditEngagementBySchedule(auditScheduleDTO.getId());
        if(engagementInfo == null){
 resultWrapper.setResult(null);
 resultWrapper.setMessage("Engagement with the provided information does not exist");
 resultWrapper.setStatus(false);
 return  resultWrapper;

        }
        if(engagementInfo.getAuditSchedule() == null){
            resultWrapper.setResult(null);
            resultWrapper.setMessage("Audit schedule with the provided information does not exist");
            resultWrapper.setStatus(false);
            return  resultWrapper;

        }

        System.out.println("engagement present");
        AuditProgram auditProgram=auditProgramRepository.getAuditProgramByEngagementId(engagementInfo.getId());
        if(auditProgram == null){
            resultWrapper.setResult(null);
            resultWrapper.setMessage("Audit Program with the provided information does not exist");
            resultWrapper.setStatus(false);
            return  resultWrapper;

        }

        List<Finding> findings=auditProgramFindingRepository.findFindingByAuditProgramId(auditProgram.getId());
        if(findings == null){
            resultWrapper.setResult(null);
            resultWrapper.setMessage("Finding with the provided information does not exist");
            resultWrapper.setStatus(false);
            return  resultWrapper;

        }




        reportResultWrapper.setFindings(FindingMapper.INSTANCE.FindingToFindingDTOs(findings));
        reportResultWrapper.setAuditSchedule(AuditScheduleMapper.INSTANCE.toDTO(engagementInfo.getAuditSchedule()));
        reportResultWrapper.setAuditProgram(AuditProgramMapper.INSTANCE.toDTO(auditProgram));
        reportResultWrapper.setScope(auditProgram.getScopeDescription());
        reportResultWrapper.setMethodology(auditProgram.getMethodology());
        reportResultWrapper.setEngagementInfo(EngagementMapper.INSTANCE.toDTO(engagementInfo));
        resultWrapper.setMessage("success");
        resultWrapper.setStatus(true);
        resultWrapper.setResult(reportResultWrapper);

return resultWrapper;
    }

    public ResultWrapper<ReportDTO> registerReport(ReportDTO reportDTO ){
        Report report = ReportMapper.INSTANCE.toEntity(reportDTO);
        ResultWrapper<ReportDTO> resultWrapper=new ResultWrapper<>();
        System.out.println(reportDTO.getAuditProgram().getEngagementInfo().getAuditSchedule().getId());
        if(reportDTO.getAuditProgram().getEngagementInfo().getAuditSchedule() == null){
            resultWrapper.setResult(null);
            resultWrapper.setMessage("there is no report with the provided information");
            resultWrapper.setStatus(false);
            return resultWrapper;
        }
        System.out.println(reportDTO);
    Report savedReport=reportRepository.findReportByAuditScheduleId(reportDTO.getAuditSchedule().getId());


        System.out.println(report.getObjectives());
        System.out.println("======================");
        System.out.println(reportDTO);


        if(report == null){
            resultWrapper.setResult(null);
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("no report found");
            return  resultWrapper;

        }
        // check detail of the report , ex finding not null,schedule not null , engagement not null ... etc
if(savedReport != null){
    reportRepository.delete(savedReport);
    Report savedResult=reportRepository.save(report);
    resultWrapper.setMessage("success");
    resultWrapper.setStatus(true);
    resultWrapper.setResult(ReportMapper.INSTANCE.toDTO(savedResult));
    return resultWrapper;

}else{
       Report savedResult=reportRepository.save(report);
        resultWrapper.setMessage("success");
        resultWrapper.setStatus(true);
        resultWrapper.setResult(ReportMapper.INSTANCE.toDTO(savedResult));
        return resultWrapper;}

    }
    public ResultWrapper<ReportDTO> getReportById(Long id){
        Report report = reportRepository.findById(id).orElse(null);
        ResultWrapper<ReportDTO> resultWrapper=new ResultWrapper<>();

        if(report == null){
            resultWrapper.setResult(null);
            resultWrapper.setMessage("there is no report with the provided information");
            resultWrapper.setStatus(false);
            return resultWrapper;
        }

        resultWrapper.setStatus(true);
        resultWrapper.setResult(ReportMapper.INSTANCE.toDTO(report));
        resultWrapper.setMessage("success");
        return resultWrapper;


    }

    public ResultWrapper<ReportDTO> getReportByScheduleId(Long id){
        ResultWrapper<ReportDTO> resultWrapper=new ResultWrapper<>();
        Report report = reportRepository.findReportByAuditScheduleId(id);
        if(report == null){
            resultWrapper.setMessage("report with the provide Audit schedule record does not exist ");
            resultWrapper.setStatus(false);
            resultWrapper.setResult(null);
            return resultWrapper;
        }
        resultWrapper.setResult(ReportMapper.INSTANCE.toDTO(report));
        resultWrapper.setStatus(true);
        resultWrapper.setMessage("success");
        return resultWrapper;


    }

    public ResultWrapper<List<ReportDTO>> listAllReports(){
        List<Report> reports= reportRepository.findAll();
        List<ReportDTO> reportDTOS = ReportMapper.INSTANCE.ReportsToReportDTOs(reports);

        ResultWrapper<List<ReportDTO>> resultWrapper=new ResultWrapper<>();
        resultWrapper.setResult(reportDTOS);

        return resultWrapper;


    }

}

// check if the api is working fine
// check if the customized Report has the correct information about the findings , objectives so that they are related or from the same process
// fill with the rest of information needed to complete the report generation and storing process

