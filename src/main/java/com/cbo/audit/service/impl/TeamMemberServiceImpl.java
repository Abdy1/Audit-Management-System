package com.cbo.audit.service.impl;

import com.cbo.audit.dto.*;
import com.cbo.audit.enums.TeamMemberStatus;
import com.cbo.audit.mapper.AuditScheduleMapper;
import com.cbo.audit.mapper.EmployeeMapper;
import com.cbo.audit.mapper.TeamMemberMapper;
import com.cbo.audit.mapper.UserMapper;
import com.cbo.audit.persistence.model.*;
import com.cbo.audit.persistence.repository.EmployeeRepository;
import com.cbo.audit.persistence.repository.TeamMemberRepository;
import com.cbo.audit.persistence.repository.UserRepository;
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
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public ResultWrapper<TeamMemberDTO> registerTeamMemberToSchedule(TeamMemberDTO teamMemberDTO) {
        ResultWrapper<TeamMemberDTO> resultWrapper = new ResultWrapper<>();

        AuditSchedule auditSchedule = auditScheduleService.findAuditScheduleById(teamMemberDTO.getAuditSchedule().getId());

        Optional<User> user = userRepository.findById(teamMemberDTO.getUser().getId());
        if (auditSchedule == null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Schedule with the provided information is not available.");
            return resultWrapper;
        }

        if (!user.isPresent()) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("User with the provided information is not available.");
            return resultWrapper;
        } else if (!isTeamMemberFree(user.get().getId())) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("User have an active schedule or task.");
        }

        TeamMember teamMember = TeamMemberMapper.INSTANCE.toEntity(teamMemberDTO);
        teamMember.setCreatedTimestamp(LocalDateTime.now());
        teamMember.setCreatedUser("TODO");
        teamMember.setAuditSchedule(auditSchedule);
        teamMember.setUser(user.get());

        TeamMember savedMember = teamMemberRepository.save(teamMember);

        resultWrapper.setStatus(true);
        resultWrapper.setResult(TeamMemberMapper.INSTANCE.toDTO(savedMember));
        resultWrapper.setMessage("Team member successfully added to schedule.");
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<TeamMemberDTO>> getAllTeamMemberOfSchedule(AuditScheduleDTO auditScheduleDTO) {
        ResultWrapper<List<TeamMemberDTO>> resultWrapper = new ResultWrapper<>();

        List<TeamMember> teamMembers = teamMemberRepository.findAllTeamsOfSchedule(auditScheduleDTO.getId());

        if(!teamMembers.isEmpty()){
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
    public ResultWrapper<TeamMemberDTO> getTeamMemberById(Long id) {
        ResultWrapper<TeamMemberDTO> resultWrapper = new ResultWrapper<>();
        Optional<TeamMember> teamMember = teamMemberRepository.findById(id);
        if (teamMember.isPresent()){
            TeamMemberDTO teamMemberDTO =  TeamMemberMapper.INSTANCE.toDTO(teamMember.get());
            resultWrapper.setResult(teamMemberDTO);
            resultWrapper.setStatus(true);
        }else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("No record found with the provided id.");
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<TeamMemberDTO> getTeamMemberByUserIdAndSchedule(Long id) {
        return null;
    }

    @Override
    public Optional<TeamMember> findTeamMemberById(Long id) {
        return teamMemberRepository.findById(id);
    }

    @Override
    public ResultWrapper<TeamMemberDTO> updateTeamMember(TeamMemberDTO teamMemberDTO) {
        ResultWrapper<TeamMemberDTO> resultWrapper = new ResultWrapper<>();

        Optional<TeamMember> oldTeamMember = teamMemberRepository.findById(teamMemberDTO.getId());

        if (!oldTeamMember.isPresent()){
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Invalid team member id");
        }
        TeamMember updatedTeam = oldTeamMember.get();
        updatedTeam.setStatus(teamMemberDTO.getTeamMemberStatus());
        updatedTeam.setModifiedTimestamp(LocalDateTime.now());
        updatedTeam.setModifiedUser("TODO");
        TeamMember saveMember = teamMemberRepository.save(updatedTeam);
        resultWrapper.setResult(TeamMemberMapper.INSTANCE.toDTO(saveMember));
        resultWrapper.setStatus(true);
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<TeamMemberDTO>> getTeamMemberByUserIdAndStatus(Long id) {
        /*List<TeamMember> activeSchedule = teamMemberRepository.findTeamMemberByUserIdAndState(id, TeamMemberStatus.Active.name());

        if (!activeSchedule.isEmpty()){
            return
        }*/
        return null;
    }

    @Override
    public ResultWrapper<List<AuditScheduleDTO>> getAllScheduleByUserId(Long userId) {
        ResultWrapper<List<AuditScheduleDTO>> resultWrapper = new ResultWrapper<>();

        List<TeamMember> teamList = teamMemberRepository.findTeamMemberByUserId(userId);
        Set<Long> scheduleIds = new HashSet<>();

        if (!teamList.isEmpty()){
            for (TeamMember teamMember: teamList) {
                if (!teamMember.getStatus().equals(TeamMemberStatus.Completed)){
                    scheduleIds.add(teamMember.getAuditSchedule().getId());
                }
            }
        }
        List<AuditSchedule> auditSchedules = new ArrayList<>();
        for (Long scheduleId: scheduleIds) {
            auditSchedules.add(auditScheduleService.findAuditScheduleById(scheduleId));
        }
        resultWrapper.setResult(AuditScheduleMapper.INSTANCE.auditSchedulesToAuditScheduleDTOs(auditSchedules));

        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<UserDTO>> getAllUsers() {
        ResultWrapper<List<UserDTO>> resultWrapper= new ResultWrapper<>();
        resultWrapper.setResult(UserMapper.INSTANCE.usersToUserDTOs(userRepository.findAll()));
        resultWrapper.setStatus(true);
        return resultWrapper;
    }

    @Override
    public List<TeamMember> updateAllTeamsStatus(Long scheduleId) {
        List<TeamMember> teams = teamMemberRepository.findAllTeamsOfSchedule(scheduleId);

        for (TeamMember teamMember: teams) {
            teamMember.setStatus(TeamMemberStatus.Completed);
            teamMemberRepository.save(teamMember);
        }
        return teams;
    }

    public boolean isTeamMemberFree(Long userId){
        List<TeamMember> activeSchedule = teamMemberRepository.findTeamMemberByUserIdAndState(userId, TeamMemberStatus.InProgress.name());

        if (!activeSchedule.isEmpty()){
            return false;
        }
        return true;
    }
}
