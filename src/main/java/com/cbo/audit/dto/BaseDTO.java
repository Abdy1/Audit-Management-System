package com.cbo.audit.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseDTO implements Serializable {
    private static final long serialVersionUID = 1922960209727830410L;

    private Long id;

    private String createdUser;

    private String modifiedUser;

    @JsonIgnore
    private LocalDateTime createdTimestamp;

    private LocalDateTime modifiedTimestamp;
}