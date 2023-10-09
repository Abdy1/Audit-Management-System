package com.cbo.audit.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "employee_sequence")
    private Long id;

    private Long employeeId;
    private String fullName;
    private String jobTitle;
    private String phoneNumber;
    private String personalEmail;
    private String companyEmail;
    private String gender;
    private String birthDate;
    private String employeeImage;
    private String signatureImage;
    private Boolean active;

    @OneToOne(mappedBy = "employee")
    private User user;
}

