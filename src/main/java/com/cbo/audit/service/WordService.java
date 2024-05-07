package com.cbo.audit.service;

import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.persistence.model.AnnualPlan;

import java.io.IOException;
import java.util.List;

public interface WordService {

    void createWordDocument() throws IOException;
}
