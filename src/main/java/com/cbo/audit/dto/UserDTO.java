package com.cbo.audit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO extends BaseDTO{

    private String username;
    private String password;
    private Boolean active;

    private EmployeeDTO employee;
}
