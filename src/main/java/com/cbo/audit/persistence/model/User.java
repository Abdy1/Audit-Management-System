package com.cbo.audit.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ams_user")
public class User extends BaseEntity{
    @Column(name = "username", unique = true, nullable = false, length = 20)
    private String username;
    @Column(nullable = false, length = 64)
    private String password;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "createdAt")
    private String createdAt;
    @Column(name = "updatedAt")
    private String updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

}
