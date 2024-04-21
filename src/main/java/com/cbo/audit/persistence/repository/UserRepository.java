package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
