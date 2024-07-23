package com.cbo.audit.service.impl;

import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.dto.EngagementDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.TeamMemberDTO;
import com.cbo.audit.enums.AnnualPlanStatus;
import com.cbo.audit.enums.AuditScheduleStatus;
import com.cbo.audit.enums.TeamMemberStatus;
import com.cbo.audit.mapper.AuditScheduleMapper;
import com.cbo.audit.mapper.AuditStaffMapper;
import com.cbo.audit.mapper.EngagementMapper;
import com.cbo.audit.mapper.TeamMemberMapper;
import com.cbo.audit.persistence.model.AnnualPlan;
import com.cbo.audit.persistence.model.AuditSchedule;
import com.cbo.audit.persistence.model.EngagementInfo;
import com.cbo.audit.persistence.model.TeamMember;
import com.cbo.audit.persistence.repository.*;
import com.cbo.audit.service.AnnualPlanService;
import com.cbo.audit.service.AuditScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("auditScheduleService")
@Transactional
public class AuditScheduleServiceImpl implements AuditScheduleService {

    @Autowired
    private AuditScheduleRepository auditScheduleRepository;
    @Autowired
    private AnnualPlanService annualPlanService;

    @Autowired
    private AnnualPlanRepository annualPlanRepository;
    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @Autowired
    private EngagementInfoRepository engagementInfoRepository;

    @Autowired
    private BudgetYearRepository budgetYearRepository;

    private String notFound = "Engagement not found.";


    @Override
    public ResultWrapper<AuditScheduleDTO> registerAuditSchedule(AuditScheduleDTO auditScheduleDTO) {

        ResultWrapper<AuditScheduleDTO> resultWrapper = new ResultWrapper<>();

        AnnualPlan annualPlan = annualPlanService.findAnnualPlanById(auditScheduleDTO.getAnnualPlan().getId());

        if (annualPlan == null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Annual Plan with the provided information is not available.");
            return resultWrapper;
        } else if (annualPlan.getStatus().equals(AnnualPlanStatus.Pending.name())) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Annual Plan must be in Approved status before scheduled.");
            return resultWrapper;
        } else if (auditScheduleDTO.getStartOn() == null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit schedule start time cannot be null.");
            return resultWrapper;
        } else {
            AuditSchedule auditSchedule = AuditScheduleMapper.INSTANCE.toEntity(auditScheduleDTO);
            auditSchedule.setCreatedTimestamp(LocalDateTime.now());
            auditSchedule.setAnnualPlan(annualPlan);
            auditSchedule.setStatus(AuditScheduleStatus.Scheduled.name());
            auditSchedule.setAuditeesOrganID(auditScheduleDTO.getAuditeesOrganID());

            auditSchedule.setYear(annualPlan.getYear());
            annualPlan.setStatus(AnnualPlanStatus.Scheduled.name());
            annualPlanRepository.save(annualPlan);
            AuditSchedule savedSchedule = auditScheduleRepository.save(auditSchedule);

            resultWrapper.setStatus(true);
            resultWrapper.setResult(AuditScheduleMapper.INSTANCE.toDTO(savedSchedule));
            resultWrapper.setMessage("Audit Schedule created successfully.");

            return resultWrapper;
        }
    }

    @Override
    public ResultWrapper<List<AuditScheduleDTO>> getAllAuditSchedule() {
        String year = budgetYearRepository.findAll(Sort.by(Sort.Direction.DESC, "year")).stream().findFirst().get().getYear();

        ResultWrapper<List<AuditScheduleDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditSchedule> auditSchedules = auditScheduleRepository.findScheduleByYear(year);
        if (!auditSchedules.isEmpty()) {
            List<AuditScheduleDTO> auditScheduleDTOS = AuditScheduleMapper.INSTANCE.auditSchedulesToAuditScheduleDTOs(auditSchedules);
            List<AuditScheduleDTO> modifiedSchedules = new ArrayList<>();
            for (AuditScheduleDTO auditScheduleDTO : auditScheduleDTOS) {
                List<TeamMember> teamMembers = teamMemberRepository.findAllTeamsOfSchedule(auditScheduleDTO.getId());
                List<TeamMemberDTO> teamMemberDTOS = TeamMemberMapper.INSTANCE.teamMembersToTeamMemberDTOs(teamMembers);
//                if (!teamMembers.isEmpty()){
//                    teamMembers.get(0).getAuditStaff();
//                }
                auditScheduleDTO.setTeamMembers(teamMemberDTOS);
                modifiedSchedules.add(auditScheduleDTO);
            }
            resultWrapper.setResult(modifiedSchedules);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }


    @Override
    public ResultWrapper<List<AuditScheduleDTO>> getAllAuditScheduleByYear(String year) {

        ResultWrapper<List<AuditScheduleDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditSchedule> auditSchedules = auditScheduleRepository.findScheduleByYear(year);
        if (!auditSchedules.isEmpty()) {
            List<AuditScheduleDTO> auditScheduleDTOS = AuditScheduleMapper.INSTANCE.auditSchedulesToAuditScheduleDTOs(auditSchedules);
/*            auditScheduleDTOS.stream().map(auditScheduleDTO -> {
                auditScheduleDTO.setTeamMembers(TeamMemberMapper.INSTANCE.teamMembersToTeamMemberDTOs(teamMemberRepository.findAllTeamsOfSchedule(auditScheduleDTO.getId())));
                return auditScheduleDTO;
            });*/
            List<AuditScheduleDTO> modifiedSchedules = new ArrayList<>();
            for (AuditScheduleDTO auditScheduleDTO : auditScheduleDTOS) {
                List<TeamMember> teamMembers = teamMemberRepository.findAllTeamsOfSchedule(auditScheduleDTO.getId());
                List<TeamMemberDTO> teamMemberDTOS = TeamMemberMapper.INSTANCE.teamMembersToTeamMemberDTOs(teamMembers);
                auditScheduleDTO.setTeamMembers(teamMemberDTOS);
                modifiedSchedules.add(auditScheduleDTO);
            }
            resultWrapper.setResult(auditScheduleDTOS);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AuditScheduleDTO>> getAllAuditScheduleByQuarter(int quarter) {
        String year = budgetYearRepository.findAll(Sort.by(Sort.Direction.DESC, "year")).stream().findFirst().get().getYear();

        ResultWrapper<List<AuditScheduleDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditSchedule> auditSchedules = auditScheduleRepository.findScheduleByYearAndQuarter(year, quarter);
        if (!auditSchedules.isEmpty()) {
            List<AuditScheduleDTO> auditScheduleDTOS = AuditScheduleMapper.INSTANCE.auditSchedulesToAuditScheduleDTOs(auditSchedules);
/*            auditScheduleDTOS.stream().map(auditScheduleDTO -> {
                auditScheduleDTO.setTeamMembers(TeamMemberMapper.INSTANCE.teamMembersToTeamMemberDTOs(teamMemberRepository.findAllTeamsOfSchedule(auditScheduleDTO.getId())));
                return auditScheduleDTO;
            });*/
            List<AuditScheduleDTO> modifiedSchedules = new ArrayList<>();
            for (AuditScheduleDTO auditScheduleDTO : auditScheduleDTOS) {
                List<TeamMember> teamMembers = teamMemberRepository.findAllTeamsOfSchedule(auditScheduleDTO.getId());
                List<TeamMemberDTO> teamMemberDTOS = TeamMemberMapper.INSTANCE.teamMembersToTeamMemberDTOs(teamMembers);
                auditScheduleDTO.setTeamMembers(teamMemberDTOS);
                modifiedSchedules.add(auditScheduleDTO);
            }
            resultWrapper.setResult(modifiedSchedules);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<AuditScheduleDTO> getAuditScheduleById(Long id) {

        ResultWrapper<AuditScheduleDTO> resultWrapper = new ResultWrapper<>();
        AuditSchedule auditSchedule = auditScheduleRepository.findById(id).orElse(null);
        if (auditSchedule != null) {
            AuditScheduleDTO auditScheduleDTO = AuditScheduleMapper.INSTANCE.toDTO(auditSchedule);
            List<TeamMember> teamMembers = teamMemberRepository.findAllTeamsOfSchedule(auditScheduleDTO.getId());
            List<TeamMemberDTO> teamMemberDTOS = TeamMemberMapper.INSTANCE.teamMembersToTeamMemberDTOs(teamMembers);
            auditScheduleDTO.setTeamMembers(teamMemberDTOS);
            resultWrapper.setResult(auditScheduleDTO);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public AuditSchedule findAuditScheduleById(Long id) {
        return auditScheduleRepository.findById(id).orElse(null);
    }

    @Override
    public ResultWrapper<List<AuditScheduleDTO>> getAuditScheduleByAnnualPlanId(Long id) {

        ResultWrapper<List<AuditScheduleDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditSchedule> auditSchedules = auditScheduleRepository.findAuditScheduleByAnnualPlanId(id);
        if (auditSchedules != null) {
            List<AuditScheduleDTO> auditScheduleDTOS = AuditScheduleMapper.INSTANCE.auditSchedulesToAuditScheduleDTOs(auditSchedules);
            resultWrapper.setResult(auditScheduleDTOS);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<AuditScheduleDTO> updateAuditSchedule(AuditScheduleDTO auditScheduleDTO) {
        ResultWrapper<AuditScheduleDTO> resultWrapper = new ResultWrapper<>();

        Optional<AuditSchedule> oldAuditSchedule = auditScheduleRepository.findById(auditScheduleDTO.getId());


        if (!oldAuditSchedule.isPresent()) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit schedule must not be null.");
            return resultWrapper;
        } else if (auditScheduleDTO.getStartOn() == null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit schedule start time cannot be null.");
            return resultWrapper;
        }

        List<TeamMember> savedTeams = new ArrayList<>();
        // remove team
        List<TeamMember> teams = teamMemberRepository.findAllTeamsOfSchedule(oldAuditSchedule.get().getId());

        for (TeamMember team : teams) {
            teamMemberRepository.delete(team);
        }
        //add team
        for (TeamMemberDTO teamMemberDTO : auditScheduleDTO.getTeamMembers()) {
            TeamMember teamMember = TeamMemberMapper.INSTANCE.toEntity(teamMemberDTO);
            teamMember.setCreatedTimestamp(LocalDateTime.now());
            teamMember.setStatus(TeamMemberStatus.Waiting);
            teamMember.setAuditStatus(oldAuditSchedule.get().getStatus());
            teamMember.setAuditSchedule(oldAuditSchedule.get());
            teamMember.setAuditStaff(AuditStaffMapper.INSTANCE.toEntity(teamMemberDTO.getAuditStaffDTO()));

            TeamMember savedMember = teamMemberRepository.save(teamMember);
            savedTeams.add(savedMember);
        }
        AuditSchedule auditSchedule = AuditScheduleMapper.INSTANCE.toEntity(auditScheduleDTO);
        auditSchedule.setCreatedUser(oldAuditSchedule.get().getCreatedUser());
        auditSchedule.setCreatedTimestamp(oldAuditSchedule.get().getCreatedTimestamp());
        auditSchedule.setAnnualPlan(oldAuditSchedule.get().getAnnualPlan());
        auditSchedule.setYear(oldAuditSchedule.get().getAnnualPlan().getYear());
        auditSchedule.setTeamMembers(savedTeams);
        AuditSchedule savedSchedule = auditScheduleRepository.save(auditSchedule);

        resultWrapper.setStatus(true);
        resultWrapper.setResult(AuditScheduleMapper.INSTANCE.toDTO(savedSchedule));
        resultWrapper.setMessage("Audit Schedule updated successfully.");
        return resultWrapper;
    }

    @Override
    public ResultWrapper<EngagementDTO> addAuditScheduleToEngagement(EngagementDTO engagementDTO) {

        ResultWrapper<EngagementDTO> resultWrapper = new ResultWrapper<>();

        Optional<AuditSchedule> oldAuditSchedule = auditScheduleRepository.findById(engagementDTO.getAuditSchedule().getId());


        if (!oldAuditSchedule.isPresent()) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit schedule must not be null.");
            return resultWrapper;
        }
        AuditSchedule auditSchedule = oldAuditSchedule.get();
        auditSchedule.setStatus(AuditScheduleStatus.Engagement.name());
        auditScheduleRepository.save(auditSchedule);
        AnnualPlan annualPlan = auditSchedule.getAnnualPlan();
        annualPlan.setStatus(AnnualPlanStatus.Engagement.name());
        annualPlanRepository.save(annualPlan);
        EngagementInfo saved = engagementInfoRepository.save(EngagementMapper.INSTANCE.toEntity(engagementDTO));
        saved.setRefNum("EL-" + saved.getId());
        saved.setDate(String.valueOf(LocalDateTime.now()));
        engagementInfoRepository.save(saved);

        resultWrapper.setStatus(true);
        resultWrapper.setMessage("Audit Schedule added to engagement successfully.");
        return resultWrapper;
    }
}
