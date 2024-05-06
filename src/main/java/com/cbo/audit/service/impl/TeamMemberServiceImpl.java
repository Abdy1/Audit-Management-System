package com.cbo.audit.service.impl;

import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.TeamMemberDTO;
import com.cbo.audit.enums.TeamMemberStatus;
import com.cbo.audit.enums.TeamType;
import com.cbo.audit.mapper.AuditScheduleMapper;
import com.cbo.audit.mapper.TeamMemberMapper;
import com.cbo.audit.persistence.model.AuditSchedule;
import com.cbo.audit.persistence.model.AuditStaff;
import com.cbo.audit.persistence.model.TeamMember;
import com.cbo.audit.persistence.repository.AuditStaffRepository;
import com.cbo.audit.persistence.repository.EmployeeRepository;
import com.cbo.audit.persistence.repository.TeamMemberRepository;
import com.cbo.audit.service.AuditScheduleService;
import com.cbo.audit.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;


@Service("teamMemberService")
@Transactional
public class TeamMemberServiceImpl implements TeamMemberService {

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @Autowired
    private AuditScheduleService auditScheduleService;

    @Autowired
    private AuditStaffRepository auditStaffRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public ResultWrapper<TeamMemberDTO> registerTeamMemberToSchedule(TeamMemberDTO teamMemberDTO) {
        ResultWrapper<TeamMemberDTO> resultWrapper = new ResultWrapper<>();

        AuditSchedule auditSchedule = auditScheduleService.findAuditScheduleById(teamMemberDTO.getAuditScheduleId());

        Optional<AuditStaff> auditStaff = auditStaffRepository.findById(teamMemberDTO.getAuditStaffDTO().getId());
        if (auditSchedule == null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Schedule with the provided information is not available.");
            return resultWrapper;
        }

        if (!auditStaff.isPresent()) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("AuditStaff with the provided information is not present.");
            return resultWrapper;
        }
        TeamMember existAlready = teamMemberRepository.findTeamMemberByAuditStaffIdAndSchedule(auditStaff.get().getId(), auditSchedule.getId());
        if (existAlready != null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Assigned already.");
            return resultWrapper;
        }

        TeamMember teamMemberLeader = teamMemberRepository.findTeamLeaderOfSchedule(auditSchedule.getId(), TeamType.Leader);
        if ((teamMemberLeader != null) && teamMemberDTO.getTeamRole().equals(TeamType.Leader)) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Leader duplication is not allowed.");
            return resultWrapper;
        }

        TeamMember teamMember = TeamMemberMapper.INSTANCE.toEntity(teamMemberDTO);

        // save team
        TeamMember savedMember = saveTeam(teamMember, auditSchedule, auditStaff.get());

        resultWrapper.setStatus(true);
        resultWrapper.setResult(TeamMemberMapper.INSTANCE.toDTO(savedMember));
        resultWrapper.setMessage("Team member successfully added to schedule.");
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<TeamMemberDTO>> getAllTeamMemberOfSchedule(AuditScheduleDTO auditScheduleDTO) {
        ResultWrapper<List<TeamMemberDTO>> resultWrapper = new ResultWrapper<>();

        List<TeamMember> teamMembers = teamMemberRepository.findAllTeamsOfSchedule(auditScheduleDTO.getId());

        if (!teamMembers.isEmpty()) {
            List<TeamMemberDTO> teamMemberDTOS = TeamMemberMapper.INSTANCE.teamMembersToTeamMemberDTOs(teamMembers);
            resultWrapper.setStatus(true);
            resultWrapper.setResult(teamMemberDTOS);
        } else {
            resultWrapper.setStatus(true);
            resultWrapper.setMessage("No teams found yet.");
        }

        return resultWrapper;
    }

    @Override
    public List<TeamMemberDTO> getAllTeamMemberOfScheduleSys(AuditScheduleDTO auditScheduleDTO) {
        List<TeamMember> teamMembers = teamMemberRepository.findAllTeamsOfSchedule(auditScheduleDTO.getId());

        return TeamMemberMapper.INSTANCE.teamMembersToTeamMemberDTOs(teamMembers);
    }

    @Override
    public ResultWrapper<TeamMemberDTO> getTeamMemberById(Long id) {
        ResultWrapper<TeamMemberDTO> resultWrapper = new ResultWrapper<>();
        Optional<TeamMember> teamMember = teamMemberRepository.findById(id);
        if (teamMember.isPresent()) {
            TeamMemberDTO teamMemberDTO = TeamMemberMapper.INSTANCE.toDTO(teamMember.get());
            resultWrapper.setResult(teamMemberDTO);
            resultWrapper.setStatus(true);
        } else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("No record found with the provided id.");
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<TeamMemberDTO> getTeamMemberByAuditStaffIdAndSchedule(Long id) {
        return null;
    }

    @Override
    public Optional<TeamMember> findTeamMemberById(Long id) {
        return teamMemberRepository.findById(id);
    }

    @Override
    public ResultWrapper<TeamMemberDTO> removeTeamMember(TeamMemberDTO teamMemberDTO) {
        ResultWrapper<TeamMemberDTO> resultWrapper = new ResultWrapper<>();
        Optional<TeamMember> teamMember = teamMemberRepository.findById(teamMemberDTO.getId());
        if (teamMember.isPresent()) {
            teamMemberRepository.delete(teamMember.get());
            resultWrapper.setStatus(true);
            resultWrapper.setMessage("Deleted successfully");
        } else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Incorrect team Id");
        }

        return resultWrapper;
    }

    @Override
    public ResultWrapper<TeamMemberDTO> updateTeamMember(TeamMemberDTO teamMemberDTO) {
        ResultWrapper<TeamMemberDTO> resultWrapper = new ResultWrapper<>();

        Optional<TeamMember> oldTeamMember = teamMemberRepository.findById(teamMemberDTO.getId());

        if (!oldTeamMember.isPresent()) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Invalid team member id");
        }
        resultWrapper.setResult(TeamMemberMapper.INSTANCE.toDTO(updateRecord(oldTeamMember.get(), teamMemberDTO.getStatus())));
        resultWrapper.setStatus(true);
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<TeamMemberDTO>> getTeamMemberByAuditStaffIdAndStatus(Long id, String status) {
        ResultWrapper<List<TeamMemberDTO>> resultWrapper = new ResultWrapper<>();
        List<TeamMember> teamMembers = teamMemberRepository.findTeamMemberByAuditStaffIdAndState(id, status);

        if (!teamMembers.isEmpty()) {
            List<TeamMemberDTO> teamMemberDTOS = TeamMemberMapper.INSTANCE.teamMembersToTeamMemberDTOs(teamMembers);
            resultWrapper.setStatus(true);
            resultWrapper.setResult(teamMemberDTOS);
        } else {
            resultWrapper.setStatus(true);
            resultWrapper.setMessage("No teams found yet.");
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AuditScheduleDTO>> getAllScheduleByAuditStaffId(Long auditStaffId) {
        ResultWrapper<List<AuditScheduleDTO>> resultWrapper = new ResultWrapper<>();

        List<TeamMember> teamList = teamMemberRepository.findTeamMemberByAuditStaffId(auditStaffId);
        Set<Long> scheduleIds = new HashSet<>();

        if (!teamList.isEmpty()) {
            for (TeamMember teamMember : teamList) {
                if (!teamMember.getStatus().equals(TeamMemberStatus.Completed)) {
                    scheduleIds.add(teamMember.getAuditSchedule().getId());
                }
            }
        }
        List<AuditSchedule> auditSchedules = new ArrayList<>();
        for (Long scheduleId : scheduleIds) {
            auditSchedules.add(auditScheduleService.findAuditScheduleById(scheduleId));
        }
        resultWrapper.setResult(AuditScheduleMapper.INSTANCE.auditSchedulesToAuditScheduleDTOs(auditSchedules));

        return resultWrapper;
    }


    @Override
    public List<TeamMember> updateAllTeamsStatus(Long scheduleId) {
        List<TeamMember> teams = teamMemberRepository.findAllTeamsOfSchedule(scheduleId);

        for (TeamMember teamMember : teams) {
            teamMember.setStatus(TeamMemberStatus.Completed);
            teamMemberRepository.save(teamMember);
        }
        return teams;
    }

    private TeamMember saveTeam(TeamMember teamMember, AuditSchedule auditSchedule, AuditStaff auditStaff){
        teamMember.setCreatedTimestamp(LocalDateTime.now());
        teamMember.setStatus(TeamMemberStatus.Waiting);
        teamMember.setAuditStatus(auditSchedule.getStatus());
        teamMember.setAuditSchedule(auditSchedule);
        teamMember.setAuditStaff(auditStaff);

        return teamMemberRepository.save(teamMember);
    }

    private TeamMember updateRecord(TeamMember oldTeam, TeamMemberStatus status){
        oldTeam.setStatus(status);
        oldTeam.setModifiedTimestamp(LocalDateTime.now());
        return teamMemberRepository.save(oldTeam);
    }
}
