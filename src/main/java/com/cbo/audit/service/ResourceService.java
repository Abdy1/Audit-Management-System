package com.cbo.audit.service;

import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.dto.ResourceDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.persistence.model.Resource;

import java.util.List;
import java.util.Optional;

public interface ResourceService {


    ResultWrapper<ResourceDTO> registerResourceToSchedule(ResourceDTO resourceDTO);

    ResultWrapper<List<ResourceDTO>> getAllResourceOfSchedule(AuditScheduleDTO resourceDTO);

    ResultWrapper<ResourceDTO> getResourceById(Long id);


    Optional<Resource> findResourceById(Long id);

    ResultWrapper<ResourceDTO> updateResource(ResourceDTO resourceDTO);

    ResultWrapper<List<ResourceDTO>> getResourceByStatus(String status);

}
