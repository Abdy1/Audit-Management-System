package com.cbo.audit.persistence.repository;

import com.cbo.audit.enums.TeamType;
import com.cbo.audit.persistence.model.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

    @Query("SELECT TM FROM TeamMember TM WHERE TM.auditStaff.id = :userId AND TM.status = :status")
    List<TeamMember> findTeamMemberByAuditStaffIdAndState(@Param("userId") Long userId, @Param("status") String status);

    @Query("SELECT TM FROM TeamMember TM JOIN FETCH TM.auditStaff WHERE TM.auditSchedule.id = :scheduleId")
    List<TeamMember> findAllTeamsOfSchedule(@Param("scheduleId") Long scheduleId);

    @Query("SELECT TM FROM TeamMember TM WHERE TM.auditStaff.id = :userId AND TM.auditSchedule.id = :scheduleId")
    TeamMember findTeamMemberByAuditStaffIdAndSchedule(@Param("userId") Long userId, @Param("scheduleId") Long scheduleId);

    @Query("SELECT TM FROM TeamMember TM WHERE TM.auditSchedule.id = :scheduleId " +
            "AND TM.teamRole = :teamType")
    TeamMember findTeamLeaderOfSchedule(@Param("scheduleId") Long scheduleId, @Param("teamType") TeamType teamType);

    @Query("SELECT TM FROM TeamMember TM WHERE TM.auditStaff.id = :userId")
    List<TeamMember> findTeamMemberByAuditStaffId(@Param("userId") Long userId);
}
