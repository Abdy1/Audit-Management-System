package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

    @Query("SELECT TM FROM TeamMember TM WHERE TM.user.id = :userId AND TM.status = :status")
    List<TeamMember> findTeamMemberByUserIdAndState(@Param("userId") Long userId, @Param("status") String status);

    @Query("SELECT TM FROM TeamMember TM WHERE TM.auditSchedule.id = :scheduleId")
    List<TeamMember> findAllTeamsOfSchedule(@Param("scheduleId") Long scheduleId);
}
