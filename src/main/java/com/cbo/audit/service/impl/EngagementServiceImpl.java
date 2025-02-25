package com.cbo.audit.service.impl;

import com.cbo.audit.dto.*;
import com.cbo.audit.mapper.AuditeesMapper;
import com.cbo.audit.mapper.EngagementMapper;
import com.cbo.audit.mapper.TeamMemberMapper;
import com.cbo.audit.persistence.model.Auditees;
import com.cbo.audit.persistence.model.EngagementInfo;
import com.cbo.audit.persistence.model.TeamMember;
import com.cbo.audit.persistence.repository.AuditeeRepository;
import com.cbo.audit.persistence.repository.BudgetYearRepository;
import com.cbo.audit.persistence.repository.EngagementInfoRepository;
import com.cbo.audit.persistence.repository.TeamMemberRepository;
import com.cbo.audit.service.EngagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("engagementService")
public class EngagementServiceImpl implements EngagementService {
    Logger logger = LoggerFactory.getLogger(EngagementServiceImpl.class);

    @Autowired
    private EngagementInfoRepository engagementInfoRepository;

    @Autowired
    private AuditeeRepository auditeeRepository;

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
    public ResultWrapper<List<EngagementDTO>> getAuditEngagementsWithAuditees() {
        // Fetch the latest year from the budget year repository
        String year = budgetYearRepository.findAll(Sort.by(Sort.Direction.DESC, "year"))
                .stream()
                .findFirst()
                .get()
                .getYear();

        // Log the year being fetched
        logger.info("Fetching engagements for year: {}", year);

        // Initialize the result wrapper
        ResultWrapper<List<EngagementDTO>> resultWrapper = new ResultWrapper<>();

        // Step 1: Fetch the EngagementInfo list for the specified year
        List<EngagementInfo> engagementInfos = engagementInfoRepository.findEngagementByYear(year);
        logger.info("Found {} engagements for year: {}", engagementInfos.size(), year);

        // Step 2: Check if engagements were found
        if (!engagementInfos.isEmpty()) {
            // Step 3: Initialize a list to hold EngagementDTOs
            List<EngagementDTO> engagementDTOS = EngagementMapper.INSTANCE.engagementInfosToEngagementDTOs(engagementInfos);

            // Step 4: For each EngagementDTO, find its associated auditees
            for (EngagementDTO engagementDTO : engagementDTOS) {
                // Fetch auditees for the current engagement
                List<Auditees> auditeesList = auditeeRepository.findAuditeesByEngagementId(engagementDTO.getId());

                // Initialize the list of AuditeesDTOs
                List<AuditeesDTO> auditeesDTOList = auditeesList.stream()
                        .map(auditee -> {
                            // Map Auditees entity to AuditeesDTO
                            AuditeesDTO auditeesDTO = new AuditeesDTO();
                            auditeesDTO.setFullName(auditee.getFullName());
                            auditeesDTO.setUserId(auditee.getUserId());
                            return auditeesDTO;
                        })
                        .collect(Collectors.toList());

                // Set the list of AuditeesDTOs for the current EngagementDTO
                engagementDTO.setAuditeesDTOList(auditeesDTOList);

                // Log the engagement ID and the list of associated auditees
                logger.info("Engagement ID: {}, Auditees count: {}", engagementDTO.getId(), auditeesDTOList.size());
                if (!auditeesDTOList.isEmpty()) {
                    logger.info("Auditees for Engagement ID {}: {}", engagementDTO.getId(),
                            auditeesDTOList.stream().map(AuditeesDTO::getFullName).collect(Collectors.joining(", ")));
                }
            }

            // Step 5: Wrap the results and set status to true
            resultWrapper.setResult(doMapping(engagementDTOS));
            resultWrapper.setStatus(true);
        } else {
            // No engagements found, set status to false and provide a message
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

    @Override
    public ResultWrapper<EngagementDTO> addAuditee(List<AuditeesDTO> auditees, Long engagementId) {
        ResultWrapper<EngagementDTO> resultWrapper = new ResultWrapper<>();
        logger.info("initiated new :{}", resultWrapper);

        // Fetch the EngagementInfo object
        EngagementInfo engagementToBeModified = engagementInfoRepository.findById(engagementId)
                .orElseThrow(() -> new EntityNotFoundException("Engagement not found"));
        logger.info("identify the updatee:{}", engagementToBeModified);

        // Map the AuditeesDTO list to Auditees entities
        List<Auditees> auditeesList = AuditeesMapper.INSTANCE.toEntities(auditees);
        logger.info("prepare updateor : {}", auditeesList);

        // Set the Auditees to the EngagementInfo
        engagementToBeModified.setAuditees(auditeesList);

        // Save the EngagementInfo (this will cascade to Auditees)
        engagementInfoRepository.save(engagementToBeModified);
        logger.info("after saved :{}", engagementToBeModified);

        // Map the EngagementInfo to DTO for the response
        EngagementDTO engagementDTO = EngagementMapper.INSTANCE.toDTO(engagementToBeModified);
        logger.info("make it DTO before returning :{}", engagementDTO);
        resultWrapper.setResult(engagementDTO);
        resultWrapper.setStatus(true);

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
