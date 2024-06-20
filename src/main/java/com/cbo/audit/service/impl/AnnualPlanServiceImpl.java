package com.cbo.audit.service.impl;

import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.RiskScoreDTO;
import com.cbo.audit.enums.AnnualPlanStatus;
import com.cbo.audit.enums.AuditObjectStatus;
import com.cbo.audit.mapper.AnnualPlanMapper;
import com.cbo.audit.mapper.RiskItemMapper;
import com.cbo.audit.mapper.RiskScoreMapper;
import com.cbo.audit.persistence.model.*;
import com.cbo.audit.persistence.repository.*;
import com.cbo.audit.service.AnnualPlanService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service("annualPlanService")
@Transactional
public class AnnualPlanServiceImpl implements AnnualPlanService {
    private static final Logger loger = LoggerFactory.getLogger(AnnualPlanServiceImpl.class);

    @Autowired
    private AnnualPlanRepository annualPlanRepository;

    @Autowired
    private AuditObjectRepository auditObjectRepository;


    @Autowired
    private RiskScoreRepository riskScoreRepository;

    @Autowired
    private RiskLevelRepository riskLevelRepository;

    @Autowired
    private BudgetYearRepository budgetYearRepository;

    @Autowired
    private RiskItemRepository riskItemRepository;

    @Override
    public ResultWrapper<AnnualPlanDTO> registerAnnualPlan(AnnualPlanDTO annualPlanDTO) {
        ResultWrapper<AnnualPlanDTO> resultWrapper = new ResultWrapper<>();
        Optional<AuditObject> auditObjectOpt = auditObjectRepository.findById(annualPlanDTO.getAuditObject().getId());


        if (!auditObjectOpt.isPresent()) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Object with the provided information is not available.");
            return resultWrapper;
        }

        List<BudgetYear> budgetYears = budgetYearRepository.findAll(Sort.by(Sort.Direction.DESC, "year"));

        if(budgetYears.isEmpty()){
            resultWrapper.setMessage("No Budget year found!");
            return resultWrapper;
        }

            Optional<BudgetYear> budgetYear = budgetYears.stream().findFirst();
            String year = "";
            year = budgetYear.get().getYear();


        AnnualPlan annualPlan = AnnualPlanMapper.INSTANCE.toEntity(annualPlanDTO);
        annualPlan.setCreatedTimestamp(LocalDateTime.now());
        annualPlan.setStatus(AnnualPlanStatus.Pending.getType());
        annualPlan.setAuditObject(auditObjectOpt.get());
        annualPlan.setYear(year);
        AnnualPlan savedPlan = annualPlanRepository.save(annualPlan);



        int score = saveRiskScore(getRiskScoresOfAuditType(savedPlan.getAuditObject().getAuditType()), savedPlan);
        savedPlan.setRiskScore(score);
        savedPlan.setRiskLevel(getRiskLevel(savedPlan.getAuditObject().getAuditType().getId(),score));
        annualPlanRepository.save(savedPlan);
        resultWrapper.setStatus(true);
        resultWrapper.setResult(AnnualPlanMapper.INSTANCE.toDTO(savedPlan));
        resultWrapper.setMessage("Annual Plan created successfully.");
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AnnualPlanDTO>> getAllAnnualPlan() {
        ResultWrapper<List<AnnualPlanDTO>> resultWrapper = new ResultWrapper<>();

        List<BudgetYear> budgetYears = budgetYearRepository.findAll(Sort.by(Sort.Direction.DESC, "year"));

        if(budgetYears.isEmpty()){
            resultWrapper.setMessage("No Budget year found!");
            resultWrapper.setStatus(false);
        }else {
            Optional<BudgetYear> budgetYear = budgetYears.stream().findFirst();
            String year = "";
            year = budgetYear.get().getYear();
            List<AnnualPlan> annualPlans = annualPlanRepository.findAnnualPlanByYear(year);
            List<AnnualPlanDTO> annualPlansWithScore = new ArrayList<>();
            if (!annualPlans.isEmpty()) {
                List<AnnualPlanDTO> annualPlanDTOS = AnnualPlanMapper.INSTANCE.annualPlansToAnnualPlanDTOs(annualPlans);
                annualPlanDTOS.stream().forEach(annualPlanDTO -> {

                    annualPlanDTO.setRiskScores(RiskScoreMapper.INSTANCE.riskScoresToRiskScoreDTOs(riskScoreRepository.findRiskScoreByAnnualPlanId(annualPlanDTO.getId())));
                    annualPlansWithScore.add(annualPlanDTO);
                });
                resultWrapper.setResult(annualPlansWithScore);
                resultWrapper.setStatus(true);
            }
        }
        return resultWrapper;
    }


    @Override
    public ResultWrapper<AnnualPlanDTO> getAnnualPlanById(Long id) {

        ResultWrapper<AnnualPlanDTO> resultWrapper = new ResultWrapper<>();
        AnnualPlan annualPlan = annualPlanRepository.findById(id).orElse(null);
        if (annualPlan != null) {
            AnnualPlanDTO annualPlanDTO = AnnualPlanMapper.INSTANCE.toDTO(annualPlan);
            resultWrapper.setResult(annualPlanDTO);

            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public AnnualPlan findAnnualPlanById(Long id) {
        return annualPlanRepository.findById(id).orElse(null);
    }

    @Override
    public ResultWrapper<List<AnnualPlanDTO>> getAnnualPlanByAuditObjectId(Long id) {

        ResultWrapper<List<AnnualPlanDTO>> resultWrapper = new ResultWrapper<>();
        List<AnnualPlan> annualPlans = annualPlanRepository.findAnnualPlanByAuditObjectId(id);
        if (annualPlans != null) {
            List<AnnualPlanDTO> annualPlanDTOS = AnnualPlanMapper.INSTANCE.annualPlansToAnnualPlanDTOs(annualPlans);
            resultWrapper.setResult(annualPlanDTOS);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<AnnualPlanDTO> addAnnualPlanToSchedule(AnnualPlanDTO annualPlanDTO) {
        ResultWrapper<AnnualPlanDTO> resultWrapper = new ResultWrapper<>();
        if (annualPlanDTO.getId() != null) {
            AnnualPlan annualPlan = findAnnualPlanById(annualPlanDTO.getId());
            if (annualPlan != null) {

                annualPlan.setStatus(AnnualPlanStatus.Scheduled.name());
                annualPlanRepository.save(annualPlan);
                resultWrapper.setMessage("Successfully added to planned annual plan");
                resultWrapper.setStatus(true);
            } else {
                resultWrapper.setMessage(String.format("Annual Plan with id %s is not found", annualPlanDTO.getId()));
                resultWrapper.setStatus(true);
            }
        } else {
            resultWrapper.setMessage("Bad request");
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AnnualPlanDTO>> getPlannedAnnualPlans() {

        ResultWrapper<List<AnnualPlanDTO>> resultWrapper = new ResultWrapper<>();

        List<AnnualPlan> annualPlans = annualPlanRepository.findAnnualPlanByStatus(AnnualPlanStatus.Scheduled.name(), LocalDateTime.now().getYear());

        if (!annualPlans.isEmpty()) {
            List<AnnualPlanDTO> annualPlanDTOS = AnnualPlanMapper.INSTANCE.annualPlansToAnnualPlanDTOs(annualPlans);
            resultWrapper.setResult(annualPlanDTOS);
            resultWrapper.setStatus(true);
        } else {
            resultWrapper.setMessage(String.format("No annual plans found for this year, %s", LocalDateTime.now().getYear()));
            resultWrapper.setStatus(false);
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AnnualPlanDTO>> getPlannedAnnualPlansByYear(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MMM-dd");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        ResultWrapper<List<AnnualPlanDTO>> resultWrapper = new ResultWrapper<>();

        List<AnnualPlan> annualPlans = annualPlanRepository.findAnnualPlanByYearAndStatus(AnnualPlanStatus.Scheduled.name(), dateTime.getYear());

        if (!annualPlans.isEmpty()) {
            List<AnnualPlanDTO> annualPlanDTOS = AnnualPlanMapper.INSTANCE.annualPlansToAnnualPlanDTOs(annualPlans);
            resultWrapper.setResult(annualPlanDTOS);
            resultWrapper.setStatus(true);
        } else {
            resultWrapper.setMessage(String.format("No annual plans found for this year, %s", LocalDateTime.now().getYear()));
            resultWrapper.setStatus(false);
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AnnualPlanDTO>> getAnnualPlanByYear(String year) {
        ResultWrapper<List<AnnualPlanDTO>> resultWrapper = new ResultWrapper<>();
        List<AnnualPlan> annualPlans = annualPlanRepository.findAnnualPlanByYear(year);
        if (!annualPlans.isEmpty()) {
            List<AnnualPlanDTO> annualPlanDTOS = AnnualPlanMapper.INSTANCE.annualPlansToAnnualPlanDTOs(annualPlans);
            resultWrapper.setResult(annualPlanDTOS);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<AnnualPlanDTO> updateAnnualPlan(AnnualPlanDTO annualPlanDTO) {
        ResultWrapper<AnnualPlanDTO> resultWrapper = new ResultWrapper<>();
        loger.info(annualPlanDTO.getId() + "this annual plan");

        AnnualPlan oldAnnualPlan = annualPlanRepository.findById(annualPlanDTO.getId()).orElse(null);
        if (oldAnnualPlan != null) {
        if (annualPlanDTO.getYear() == null) {
                resultWrapper.setStatus(false);
                resultWrapper.setMessage("Annual Plan year cannot be null.");
            } else {

                AnnualPlan annualPlan = AnnualPlanMapper.INSTANCE.toEntity(annualPlanDTO);
                annualPlan.setModifiedTimestamp(LocalDateTime.now());
                annualPlan.setCreatedTimestamp(oldAnnualPlan.getCreatedTimestamp());
                annualPlan.setCreatedUser(oldAnnualPlan.getCreatedUser());
                annualPlan.setAuditObject(oldAnnualPlan.getAuditObject());
                AnnualPlan savedPlan = annualPlanRepository.save(annualPlan);

                List<RiskScoreDTO> riskScores = annualPlanDTO.getRiskScores();
                if (!riskScores.isEmpty()) {
                    int riskScoreVal = saveRiskScore(riskScores, savedPlan);
                    savedPlan.setRiskScore(riskScoreVal);
                    savedPlan.setRiskLevel(getRiskLevel(savedPlan.getAuditObject().getAuditType().getId(),riskScoreVal));
                    annualPlanRepository.save(savedPlan);
                }
                resultWrapper.setResult(AnnualPlanMapper.INSTANCE.toDTO(savedPlan));
                resultWrapper.setStatus(true);
                resultWrapper.setMessage("Annual Plan updated successfully.");
            }
        } else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Plan with the provided id is not available.");
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<AnnualPlanDTO> approveAnnualPlan(Long id){
        ResultWrapper<AnnualPlanDTO> resultWrapper = new ResultWrapper<>();

        AnnualPlan annualPlan = annualPlanRepository.findById(id).orElse(null);

        if(annualPlan == null){
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("No annual plan found with the provided Id.");
        }else{
            annualPlan.setStatus(AnnualPlanStatus.Approved.name());
            AnnualPlan saved = annualPlanRepository.save(annualPlan);
            resultWrapper.setStatus(true);
            resultWrapper.setResult(AnnualPlanMapper.INSTANCE.toDTO(saved));
            resultWrapper.setMessage("Annual Plan Approved successfully.");
        }

        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AnnualPlanDTO>> autoGenerateAnnualPlans(String year) {


        ResultWrapper<List<AnnualPlanDTO>> resultWrapper = new ResultWrapper<>();
        List<AnnualPlanDTO> annualPlanDTOS = new ArrayList<>();
        BudgetYear budgetYear = new BudgetYear();
        budgetYear.setYear(year);
        Optional<BudgetYear> budgetYear1 = budgetYearRepository.findByYear(year);
        if (budgetYear1.isPresent()) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage(String.format("Budget year %s already applied.", year));
            return resultWrapper;
        } else {
            budgetYearRepository.save(budgetYear);
        }

        List<AuditObject> auditObjects = auditObjectRepository.findAll();



        if (year == null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Year must be provided");
            return resultWrapper;
        }
        for (AuditObject auditObject : auditObjects) {
            if (auditObject.getStatus().equals(AuditObjectStatus.Approved.name())) {
                AnnualPlan annualPlan = new AnnualPlan();
                annualPlan.setYear(year);
                annualPlan.setStatus(AnnualPlanStatus.Pending.name());
                annualPlan.setCreatedTimestamp(LocalDateTime.now());
                annualPlan.setAuditObject(auditObject);
                AnnualPlan savedAnnualPlan = annualPlanRepository.save(annualPlan);
                int score = saveRiskScore(getRiskScoresOfAuditType(auditObject.getAuditType()), savedAnnualPlan);
                savedAnnualPlan.setRiskScore(score);
                savedAnnualPlan.setRiskLevel(getRiskLevel(auditObject.getAuditType().getId(),score));
                annualPlanRepository.save(savedAnnualPlan);
                annualPlanDTOS.add(AnnualPlanMapper.INSTANCE.toDTO(savedAnnualPlan));
            }
        }
        resultWrapper.setStatus(true);
        resultWrapper.setMessage("Annual Plan generated successfully.");
        resultWrapper.setResult(annualPlanDTOS);

        return resultWrapper;
    }

    @Override
    public void recalculateRisks(){

    }

    private List<RiskScoreDTO> getRiskScoresOfAuditType(AuditType auditType) {

        List<RiskItem> riskItems = riskItemRepository.findByRiskType(auditType.getId());
        List<RiskScoreDTO> riskScores = new ArrayList<>();
        riskItems.forEach(riskItem -> {
            RiskScoreDTO riskScoreDTO = new RiskScoreDTO();
            riskScoreDTO.setRiskItem(RiskItemMapper.INSTANCE.toDTO(riskItem));
            riskScoreDTO.setLikelihood(2);
            riskScoreDTO.setImpact(2);
            riskScores.add(riskScoreDTO);
        });

        return riskScores;
    }

    public int  saveRiskScore(List<RiskScoreDTO> riskScoreDTOS, AnnualPlan annualPlan) {
        int totalScore = 0;
        if (!riskScoreDTOS.isEmpty()) {

            for (RiskScoreDTO riskScoreDTO : riskScoreDTOS) {
                int score = riskScoreDTO.getImpact() * riskScoreDTO.getLikelihood();
                totalScore += score;
                riskScoreDTO.setTotal(score);
                RiskScore riskScore = RiskScoreMapper.INSTANCE.toEntity(riskScoreDTO);
                riskScore.setAnnualPlan(annualPlan);
                riskScoreRepository.save(riskScore);
            }
        }

        return totalScore;
    }

    public String getRiskLevel(Long auditType, int riskScore) {
        RiskLevel riskLevels = riskLevelRepository.findByAuditTypeId(auditType);
        if (riskScore >= riskLevels.getHigh()) {
            return "H";
        } else if (riskScore >= riskLevels.getMedium()) {
            return "M";
        } else {
            return "L";
        }
    }
}
