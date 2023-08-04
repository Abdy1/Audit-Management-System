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

    protected Long id;
    protected String encryptedId;
    protected String encryptedAssociationId;

    private String createdUser;

    private String modifiedUser;

    @JsonIgnore
    private LocalDateTime createdTimestamp;

    private LocalDateTime modifiedTimestamp;


}