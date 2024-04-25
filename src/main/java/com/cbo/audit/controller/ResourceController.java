package com.cbo.audit.controller;

import com.cbo.audit.constants.URIs;
import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.dto.ResourceDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @PostMapping(value = URIs.TEAM_MEMBER_REGISTER, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<ResourceDTO>> resourceRegister(@RequestBody ResourceDTO resourceDTO) {

        ResultWrapper<ResourceDTO> resultWrapper = resourceService.registerResourceToSchedule(resourceDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.TEAM_MEMBER_BY_ID, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<ResourceDTO>> getResourceById(@RequestBody ResourceDTO resourceDTO) {

        ResultWrapper<ResourceDTO> resultWrapper = resourceService.getResourceById(resourceDTO.getId());

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.TEAM_MEMBER_LIST_BY_SCHEDULE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<ResourceDTO>>> getAllResourceOfSchedule(@RequestBody AuditScheduleDTO auditScheduleDTO) {

        ResultWrapper<List<ResourceDTO>> resultWrapper = resourceService.getAllResourceOfSchedule(auditScheduleDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.TEAM_MEMBER_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<ResourceDTO>> updateResource(@RequestBody ResourceDTO resourceDTO) {

        ResultWrapper<ResourceDTO> resultWrapper = resourceService.updateResource(resourceDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }
}
