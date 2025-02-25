package com.cbo.audit.controller;

import com.cbo.audit.constants.URIs;
import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.AutoGenerateAnnualPlanDTO;
import com.cbo.audit.dto.BudgetYearDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.persistence.model.BudgetYear;
import com.cbo.audit.service.AnnualPlanService;
import com.cbo.audit.service.BudgetYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BudgetYearController {

    @Autowired
    private BudgetYearService budgetYearService;

    @PostMapping(value = URIs.BUDGET_YEAR, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<BudgetYear>> registerBudgetYear(@RequestBody AutoGenerateAnnualPlanDTO generatePlans) {

        ResultWrapper<BudgetYear> resultWrapper = budgetYearService.newBudgetYear(generatePlans.getBudgetYear());

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

    @GetMapping(value = URIs.BUDGET_YEAR_CURRENT,  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultWrapper<BudgetYear>> currentBudgetYear() {

        ResultWrapper<BudgetYear> resultWrapper = budgetYearService.getBudgetYear();

        return new ResponseEntity<>(resultWrapper, HttpStatus.OK);
    }

}
