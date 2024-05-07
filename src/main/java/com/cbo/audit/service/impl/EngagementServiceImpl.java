package com.cbo.audit.service.impl;

import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.dto.EngagementDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.TeamMemberDTO;
import com.cbo.audit.mapper.EngagementMapper;
import com.cbo.audit.mapper.TeamMemberMapper;
import com.cbo.audit.persistence.model.EngagementInfo;
import com.cbo.audit.persistence.model.TeamMember;
import com.cbo.audit.persistence.repository.BudgetYearRepository;
import com.cbo.audit.persistence.repository.EngagementInfoRepository;
import com.cbo.audit.persistence.repository.TeamMemberRepository;
import com.cbo.audit.service.EngagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("engagementService")
public class EngagementServiceImpl implements EngagementService {

    @Autowired
    private EngagementInfoRepository engagementInfoRepository;

    @Autowired
    private BudgetYearRepository budgetYearRepository;

    private String notFound = "Engagement not found.";

    @Autowired
    private TeamMemberRepository teamMemberRepository;


    @Override
    public ResultWrapper<EngagementDTO> getAuditEngagementBySchedule(AuditScheduleDTO auditScheduleDTO) {
        ResultWrapper<EngagementDTO> resultWrapper = new ResultWrapper<>();

        EngagementInfo engagementInfo = engagementInfoRepository.findAuditEngagementBySchedule(auditScheduleDTO.getId());
        if (engagementInfo != null) {
            engagementInfo.setAuditSchedule(null);

            EngagementDTO engagementDTO = EngagementMapper.INSTANCE.toDTO(engagementInfo);
            engagementDTO.setAuditSchedule(auditScheduleDTO);

            resultWrapper.setResult(engagementDTO);

            resultWrapper.setStatus(true);
        } else {
            resultWrapper.setStatus(true);
            resultWrapper.setMessage(notFound);
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<EngagementDTO>> getAuditEngagements() {
        String year = budgetYearRepository.findAll(Sort.by(Sort.Direction.DESC, "year")).stream().findFirst().get().getYear();
        System.out.println("year " + year);
        ResultWrapper<List<EngagementDTO>> resultWrapper = new ResultWrapper<>();
        List<EngagementInfo> engagementInfos = engagementInfoRepository.findEngagementByYear(year);

        if (!engagementInfos.isEmpty()) {
            List<EngagementDTO> engagementDTOS = EngagementMapper.INSTANCE.engagementInfosToEngagementDTOs(engagementInfos);
            resultWrapper.setResult(doMapping(engagementDTOS));
            resultWrapper.setStatus(true);
        } else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage(notFound);
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<EngagementDTO>> getAllAuditEngagementByYear(String year) {

        ResultWrapper<List<EngagementDTO>> resultWrapper = new ResultWrapper<>();
        List<EngagementInfo> engagementInfos = engagementInfoRepository.findEngagementByYear(year);
        if (!engagementInfos.isEmpty()) {
            List<EngagementDTO> engagementDTOS = EngagementMapper.INSTANCE.engagementInfosToEngagementDTOs(engagementInfos);
            resultWrapper.setResult(engagementDTOS);
            resultWrapper.setStatus(true);
        }
        {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage(notFound);
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<EngagementDTO>> getAllAuditEngagementByQuarter(int quarter) {
        String year = budgetYearRepository.findAll(Sort.by(Sort.Direction.DESC, "year")).stream().findFirst().get().getYear();
        ResultWrapper<List<EngagementDTO>> resultWrapper = new ResultWrapper<>();
        List<EngagementInfo> engagementInfos = engagementInfoRepository.findEngagementByYearAndQuarter(year, quarter);
        if (!engagementInfos.isEmpty()) {
            List<EngagementDTO> engagementDTOS = EngagementMapper.INSTANCE.engagementInfosToEngagementDTOs(engagementInfos);
            resultWrapper.setResult(engagementDTOS);
            resultWrapper.setStatus(true);
        }
        {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage(notFound);
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<EngagementDTO>> getAllAuditEngagementByStatus(String status) {
        String year = budgetYearRepository.findAll(Sort.by(Sort.Direction.DESC, "year")).stream().findFirst().get().getYear();
        ResultWrapper<List<EngagementDTO>> resultWrapper = new ResultWrapper<>();
        List<EngagementInfo> engagementInfos = engagementInfoRepository.findEngagementByYearAndStatus(year, status);
        if (!engagementInfos.isEmpty()) {
            List<EngagementDTO> engagementDTOS = EngagementMapper.INSTANCE.engagementInfosToEngagementDTOs(engagementInfos);
            resultWrapper.setResult(engagementDTOS);
            resultWrapper.setStatus(true);
        }
        {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage(notFound);
        }
        return resultWrapper;
    }

    private List<EngagementDTO> doMapping(List<EngagementDTO> engagementDTOS){
        engagementDTOS = engagementDTOS.stream().peek(engagementDTO -> {
            AuditScheduleDTO auditScheduleDTO = engagementDTO.getAuditSchedule();
            List<TeamMember> teamMembers = teamMemberRepository.findAllTeamsOfSchedule(auditScheduleDTO.getId());
            List<TeamMemberDTO> teamMemberDTOS = TeamMemberMapper.INSTANCE.teamMembersToTeamMemberDTOs(teamMembers);
            auditScheduleDTO.setTeamMembers(teamMemberDTOS);
            engagementDTO.setAuditSchedule(auditScheduleDTO);
        }).collect(Collectors.toList());

        return engagementDTOS;
    }
}
