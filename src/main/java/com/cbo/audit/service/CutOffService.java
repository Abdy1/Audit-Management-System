package com.cbo.audit.service;

import com.cbo.audit.dto.CutOffDTO;
import com.cbo.audit.dto.ResultWrapper;

import java.util.List;

public interface CutOffService {
    ResultWrapper<CutOffDTO> registerCutOff(CutOffDTO cutOffDTO);
    ResultWrapper<CutOffDTO> getCutOffById(Long id);
    ResultWrapper<CutOffDTO> updateCutOff(CutOffDTO cutOffDTO);
    ResultWrapper<List<CutOffDTO>> getAllCutOffs();
}

