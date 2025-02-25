package com.cbo.audit.service.impl;

import com.cbo.audit.dto.BudgetYearDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.mapper.AnnualPlanMapper;
import com.cbo.audit.persistence.model.*;
import com.cbo.audit.persistence.repository.*;
import com.cbo.audit.service.BudgetYearService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("budgetYearService")
@Transactional
public class BudgetYearServiceImpl implements BudgetYearService {
    private static final Logger loger = LoggerFactory.getLogger(BudgetYearServiceImpl.class);




    @Autowired
    private BudgetYearRepository budgetYearRepository;




    @Override
    public ResultWrapper<BudgetYear> newBudgetYear(String year) {



        ResultWrapper<BudgetYear> resultWrapper = new ResultWrapper<>();

        BudgetYear budgetYear = new BudgetYear();
        budgetYear.setYear(year);
        Optional<BudgetYear> budgetYear1 = budgetYearRepository.findByYear(year);
        if (budgetYear1.isPresent()) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage(String.format("Budget year %s already applied.", year));
            return resultWrapper;
        } else  {
            budgetYearRepository.save(budgetYear);
            resultWrapper.setStatus(true);
            resultWrapper.setMessage(String.format("Budget Year Added Successfully"));
            resultWrapper.setResult(budgetYear);
        }

        return resultWrapper;
    }

    @Override
    public ResultWrapper<BudgetYear> getBudgetYear() {



        ResultWrapper<BudgetYear> resultWrapper = new ResultWrapper<>();


        List<BudgetYear> budgetYears = budgetYearRepository.findAll(Sort.by(Sort.Direction.DESC, "year"));

        if(budgetYears.isEmpty()){
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("No Budget year found!");
            return resultWrapper;
        }

        Optional<BudgetYear> budgetYear = budgetYears.stream().findFirst();
        resultWrapper.setStatus(true);
        resultWrapper.setResult(budgetYear.get());
        return resultWrapper;
    }


}
