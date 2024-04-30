package com.cbo.audit.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeDTO extends BaseDTO {

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
}
