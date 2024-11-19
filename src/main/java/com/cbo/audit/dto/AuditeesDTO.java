package com.cbo.audit.dto;

import com.cbo.audit.persistence.model.EngagementInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditeesDTO extends BaseDTO {

    private String fullName;


    private String userId;


    private EngagementInfo engagementInfo;


}
