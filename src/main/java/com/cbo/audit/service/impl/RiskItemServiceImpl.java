package com.cbo.audit.service.impl;

import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.RiskItemDTO;
import com.cbo.audit.mapper.RiskItemMapper;
import com.cbo.audit.persistence.model.RiskItem;
import com.cbo.audit.persistence.repository.RiskItemRepository;
import com.cbo.audit.service.AnnualPlanService;
import com.cbo.audit.service.RiskItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;


@Service("riskItemService")
@Transactional
public class RiskItemServiceImpl implements RiskItemService {

    @Autowired
    private RiskItemRepository riskItemRepository;

    @Autowired
    private AnnualPlanService annualPlanService;


    private static final String noRiskItem = "Risk Item with the provided id does not exist.";
    private static final Logger loger = LoggerFactory.getLogger(RiskItemServiceImpl.class);


    @Override
    public ResultWrapper<RiskItemDTO> registerRiskItem(RiskItemDTO riskItemDTO) {
        ResultWrapper<RiskItemDTO> resultWrapper = new ResultWrapper<>();

        RiskItem riskItem = RiskItemMapper.INSTANCE.toEntity(riskItemDTO);
        riskItem.setCreatedTimestamp(LocalDateTime.now());

        RiskItem savedPlan = riskItemRepository.save(riskItem);

        annualPlanService.recalculateRisks(riskItem);
        resultWrapper.setStatus(true);
        resultWrapper.setResult(RiskItemMapper.INSTANCE.toDTO(savedPlan));
        resultWrapper.setMessage("Risk Item created successfully.");
        loger.info("created new risk item : {}",riskItem);
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<RiskItemDTO>> getAllRiskItem() {
        ResultWrapper<List<RiskItemDTO>> resultWrapper = new ResultWrapper<>();
        List<RiskItem> riskItems = riskItemRepository.findAll();
        if (!riskItems.isEmpty()) {
            List<RiskItemDTO> riskItemDTOS = RiskItemMapper.INSTANCE.riskItemsToRiskItemDTOs(riskItems);
            resultWrapper.setResult(riskItemDTOS);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }


    @Override
    public ResultWrapper<RiskItemDTO> getRiskItemById(Long id) {

        ResultWrapper<RiskItemDTO> resultWrapper = new ResultWrapper<>();
        RiskItem riskItem = riskItemRepository.findById(id).orElse(null);
        if (riskItem != null) {
            RiskItemDTO riskItemDTO = RiskItemMapper.INSTANCE.toDTO(riskItem);
            resultWrapper.setResult(riskItemDTO);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public RiskItem findRiskItemById(Long id) {
        return riskItemRepository.findById(id).orElse(null);
    }

    @Override
    public ResultWrapper<RiskItemDTO> updateRiskItem(RiskItemDTO riskItemDTO) {
        ResultWrapper<RiskItemDTO> resultWrapper = new ResultWrapper<>(riskItemDTO);

        RiskItem oldRiskItem = riskItemRepository.findById(riskItemDTO.getId()).orElse(null);

        if (oldRiskItem != null) {
            if (riskItemDTO.getName() == null) {
                resultWrapper.setStatus(false);
                resultWrapper.setMessage("Please provide name.");
            }


                RiskItem riskItem = RiskItemMapper.INSTANCE.toEntity(riskItemDTO);

                if(weightOfRest(riskItem.getId(),riskItem.getAuditType().getId()) + riskItem.getWeight() > 100){
                    resultWrapper.setStatus(false);
                    resultWrapper.setMessage("Weights of risk item should not pass 100%");
                }else {
                    riskItem.setModifiedTimestamp(LocalDateTime.now());

                    RiskItem savedRepository = riskItemRepository.save(riskItem);
                    resultWrapper.setResult(RiskItemMapper.INSTANCE.toDTO(savedRepository));
                    resultWrapper.setStatus(true);
                    resultWrapper.setMessage("Risk Item updated successfully.");

                }




        } else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage(noRiskItem);
        }

        return resultWrapper;
    }

    @Override
    public ResultWrapper<RiskItemDTO> deleteRiskItem(RiskItemDTO riskItemDTO) {
        ResultWrapper<RiskItemDTO> resultWrapper = new ResultWrapper<>(riskItemDTO);

        RiskItem oldChecklist = riskItemRepository.findById(riskItemDTO.getId()).orElse(null);

        if (oldChecklist != null) {
            riskItemRepository.delete(oldChecklist);
            resultWrapper.setStatus(true);
            resultWrapper.setMessage("Risk Item deleted successfully.");
        } else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage(noRiskItem);
        }

        return resultWrapper;
    }
    @Override
    public Integer weightOfRest(Long riskItemId, Long auditTypeId) {
        Long weight = riskItemRepository.weightOfRest(riskItemId,auditTypeId);
        System.out.println("rest value is"+ weight);
        if (weight != null) {
            return weight.intValue(); // Converts Long to int (which is the primitive type)
        } else {
            return 0; // Or whatever default value you want to return when there's no result
        }
    }


}
