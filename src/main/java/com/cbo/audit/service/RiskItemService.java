package com.cbo.audit.service;

import com.cbo.audit.dto.RiskItemDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.persistence.model.RiskItem;

import java.util.List;

public interface RiskItemService {

    ResultWrapper<RiskItemDTO> registerRiskItem(RiskItemDTO riskItemDTO);

    ResultWrapper<List<RiskItemDTO>> getAllRiskItem();

    ResultWrapper<RiskItemDTO> getRiskItemById(Long id);

    RiskItem findRiskItemById(Long id);

    ResultWrapper<RiskItemDTO> updateRiskItem(RiskItemDTO riskItemDTO);

    ResultWrapper<RiskItemDTO> deleteRiskItem(RiskItemDTO riskItemDTO);
}
