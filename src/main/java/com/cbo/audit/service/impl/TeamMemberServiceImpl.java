package com.cbo.audit.service.impl;

import com.cbo.audit.dto.*;
import com.cbo.audit.enums.TeamMemberStatus;
import com.cbo.audit.mapper.TeamMemberMapper;
import com.cbo.audit.persistence.model.*;
import com.cbo.audit.persistence.repository.TeamMemberRepository;
import com.cbo.audit.persistence.repository.UserRepository;
import com.cbo.audit.service.AuditScheduleService;
import com.cbo.audit.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service("teamMemberService")
@Transactional
public class TeamMemberServiceImpl implements TeamMemberService {

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @Autowired
    private AuditScheduleService auditScheduleService;

    @Autowired
    private UserRepository userRepository;

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
            return resultWrapper;
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
        updatedTeam.setStatus(teamMemberDTO.getTeamMemberStatus().name());
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

    public boolean isTeamMemberFree(Long userId){
        List<TeamMember> activeSchedule = teamMemberRepository.findTeamMemberByUserIdAndState(userId, TeamMemberStatus.Active.name());

        if (!activeSchedule.isEmpty()){
            return false;
        }
        return true;
    }
}
