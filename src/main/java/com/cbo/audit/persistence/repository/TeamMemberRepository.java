package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
}
