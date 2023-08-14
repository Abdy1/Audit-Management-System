package com.cbo.audit.service.impl;

import com.cbo.audit.persistence.model.AuditEngagement;
import com.cbo.audit.persistence.repository.AuditEngagementRepository;
import com.cbo.audit.service.AuditEngagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("auditEngagementService")
public class AuditEngagementServiceImpl implements AuditEngagementService {
    @Autowired
    private AuditEngagementRepository auditEngagementRepository;


    @Override
    public Optional<AuditEngagement> getAuditEngagementById(Long id) {

        return auditEngagementRepository.findById(id);
    }


}
