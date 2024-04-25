package com.cbo.audit.service.impl;

import com.cbo.audit.dto.AuditScheduleDTO;
import com.cbo.audit.dto.ResourceDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.mapper.ResourceMapper;
import com.cbo.audit.persistence.model.AuditSchedule;
import com.cbo.audit.persistence.model.Resource;
import com.cbo.audit.persistence.repository.ResourceRepository;
import com.cbo.audit.service.AuditScheduleService;
import com.cbo.audit.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private AuditScheduleService auditScheduleService;


    @Override
    public ResultWrapper<ResourceDTO> registerResourceToSchedule(ResourceDTO resourceDTO) {
        ResultWrapper<ResourceDTO> resultWrapper = new ResultWrapper<>();

        AuditSchedule auditSchedule = auditScheduleService.findAuditScheduleById(resourceDTO.getAuditSchedule().getId());

        if (auditSchedule == null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Schedule with the provided information is not available.");
            return resultWrapper;
        }


        Resource resource = ResourceMapper.INSTANCE.toEntity(resourceDTO);
        resource.setCreatedTimestamp(LocalDateTime.now());
        resource.setAuditSchedule(auditSchedule);

        Resource savedMember = resourceRepository.save(resource);

        resultWrapper.setStatus(true);
        resultWrapper.setResult(ResourceMapper.INSTANCE.toDTO(savedMember));
        resultWrapper.setMessage("Resource successfully added to schedule.");
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<ResourceDTO>> getAllResourceOfSchedule(AuditScheduleDTO auditScheduleDTO) {
        ResultWrapper<List<ResourceDTO>> resultWrapper = new ResultWrapper<>();

        List<Resource> resources = resourceRepository.findAllResourcesOfSchedule(auditScheduleDTO.getId());

        if (!resources.isEmpty()) {
            List<ResourceDTO> resourceDTOS = ResourceMapper.INSTANCE.resourcesToResourceDTOs(resources);
            resultWrapper.setStatus(true);
            resultWrapper.setResult(resourceDTOS);
        } else {
            resultWrapper.setStatus(true);
            resultWrapper.setMessage("No resources assigned yet.");
        }

        return resultWrapper;
    }

    @Override
    public ResultWrapper<ResourceDTO> getResourceById(Long id) {
        ResultWrapper<ResourceDTO> resultWrapper = new ResultWrapper<>();
        Optional<Resource> resource = resourceRepository.findById(id);
        if (resource.isPresent()) {
            ResourceDTO resourceDTO = ResourceMapper.INSTANCE.toDTO(resource.get());
            resultWrapper.setResult(resourceDTO);
            resultWrapper.setStatus(true);
        } else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("No record found with the provided id.");
        }
        return resultWrapper;
    }

    @Override
    public Optional<Resource> findResourceById(Long id) {
        return resourceRepository.findById(id);
    }

    @Override
    public ResultWrapper<ResourceDTO> updateResource(ResourceDTO resourceDTO) {
        ResultWrapper<ResourceDTO> resultWrapper = new ResultWrapper<>();

        Optional<Resource> oldResource = resourceRepository.findById(resourceDTO.getId());

        if (!oldResource.isPresent()) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Invalid resource member id");
        }
        Resource updatedTeam = oldResource.get();
        updatedTeam.setResourceStatus(resourceDTO.getResourceStatus());
        updatedTeam.setModifiedTimestamp(LocalDateTime.now());
        Resource saveMember = resourceRepository.save(updatedTeam);
        resultWrapper.setResult(ResourceMapper.INSTANCE.toDTO(saveMember));
        resultWrapper.setStatus(true);
        return resultWrapper;
    }

}
