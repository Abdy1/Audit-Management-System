package com.cbo.audit.controller;

import com.cbo.audit.constants.URIs;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.RiskItemDTO;
import com.cbo.audit.service.RiskItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RiskItemController {

    @Autowired
    RiskItemService riskItemService;

    @PostMapping(value = URIs.RISK_ITEM_REGISTER, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<RiskItemDTO>> riskItemRegister(@RequestBody RiskItemDTO riskItemDTO) {

        ResultWrapper<RiskItemDTO> resultWrapper = riskItemService.registerRiskItem(riskItemDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = URIs.RISK_ITEM_LIST_ALL, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<List<RiskItemDTO>>> listAllRiskItem() {

        ResultWrapper<List<RiskItemDTO>> resultWrapper = riskItemService.getAllRiskItem();

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = URIs.RISK_ITEM_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<RiskItemDTO>> getRiskItemById(@PathVariable(name = "id") Long id) {

        ResultWrapper<RiskItemDTO> resultWrapper = riskItemService.getRiskItemById(id);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.RISK_ITEM_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<RiskItemDTO>> updateRiskItem(@RequestBody RiskItemDTO riskItemDTO) {

        ResultWrapper<RiskItemDTO> resultWrapper = riskItemService.updateRiskItem(riskItemDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @PostMapping(value = URIs.RISK_ITEM_DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<RiskItemDTO>> deleteRiskItem(@RequestBody RiskItemDTO riskItemDTO) {

        ResultWrapper<RiskItemDTO> resultWrapper = riskItemService.deleteRiskItem(riskItemDTO);

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

}
