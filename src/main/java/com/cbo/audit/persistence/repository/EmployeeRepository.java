package com.cbo.audit.persistence.repository;

import com.cbo.audit.persistence.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
