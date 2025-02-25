package com.cbo.audit.service.impl;

import com.cbo.audit.dto.AnnualPlanDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.dto.RiskScoreDTO;
import com.cbo.audit.enums.AnnualPlanStatus;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


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
    public ResponseEntity<ResultWrapper<AnnualPlanDTO>> registerAnnualPlan(AnnualPlanDTO annualPlanDTO) {
        ResultWrapper<AnnualPlanDTO> resultWrapper = new ResultWrapper<>();
        Optional<AuditObject> auditObjectOpt = auditObjectRepository.findById(annualPlanDTO.getAuditObject().getId());


        if (!auditObjectOpt.isPresent()) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Object with the provided information is not available.");
            return new ResponseEntity<>(resultWrapper, HttpStatus.BAD_REQUEST);
        }

        List<BudgetYear> budgetYears = budgetYearRepository.findAll(Sort.by(Sort.Direction.DESC, "year"));

        if(budgetYears.isEmpty()){
            resultWrapper.setMessage("No Budget year found!");
            return new ResponseEntity<>(resultWrapper,HttpStatus.BAD_REQUEST);
        }

            Optional<BudgetYear> budgetYear = budgetYears.stream().findFirst();
            String year = "";
            year = budgetYear.get().getYear();


        AnnualPlan annualPlan = AnnualPlanMapper.INSTANCE.toEntity(annualPlanDTO);
        annualPlan.setCreatedTimestamp(LocalDateTime.now());
        annualPlan.setStatus(AnnualPlanStatus.Pending.getType());
        annualPlan.setAuditObject(auditObjectOpt.get());
        annualPlan.setYear(year);
        annualPlan.setRiskScore(0);
        annualPlan.setRiskLevel(null);
        AnnualPlan savedPlan = annualPlanRepository.save(annualPlan);



//        int score = saveRiskScore(getRiskScoresOfAuditType(savedPlan.getAuditObject().getAuditType()), savedPlan);
//        savedPlan.setRiskScore(score);
//        savedPlan.setRiskLevel(getRiskLevel(savedPlan.getAuditObject().getAuditType().getId(),score));
//        annualPlanRepository.save(savedPlan);
        resultWrapper.setStatus(true);
        resultWrapper.setResult(AnnualPlanMapper.INSTANCE.toDTO(savedPlan));
        resultWrapper.setMessage("Annual Plan created successfully.");
        return new ResponseEntity<>(resultWrapper,HttpStatus.CREATED);
    }

    @Override
    public ResultWrapper<List<AnnualPlan>> getAllAnnualPlan() {
        ResultWrapper<List<AnnualPlan>> resultWrapper = new ResultWrapper<>();

        List<BudgetYear> budgetYears = budgetYearRepository.findAll(Sort.by(Sort.Direction.DESC, "year"));

        if (budgetYears.isEmpty()) {
            resultWrapper.setMessage("No Budget year found!");
            resultWrapper.setStatus(false);
        } else {
            Optional<BudgetYear> budgetYear = budgetYears.stream().findFirst();
            String year = budgetYear.get().getYear();
            List<AnnualPlan> annualPlans = annualPlanRepository.findAnnualPlanByYear(year);

            if (!annualPlans.isEmpty()) {
                resultWrapper.setResult(annualPlans);  // Returning entities directly
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
    public ResultWrapper<AnnualPlan> updateAnnualPlan(AnnualPlanDTO annualPlanDTO) {
        ResultWrapper<AnnualPlan> resultWrapper = new ResultWrapper<>();

        AnnualPlan oldAnnualPlan = annualPlanRepository.findById(annualPlanDTO.getId()).orElse(null);
        if (oldAnnualPlan != null) {
        if (annualPlanDTO.getYear() == null) {
                resultWrapper.setStatus(false);
                resultWrapper.setMessage("Annual Plan year cannot be null.");
            } else {

                AnnualPlan annualPlan = AnnualPlanMapper.INSTANCE.toEntity(annualPlanDTO);
            System.out.println("Trying oto update"+annualPlan.getAuditObject().getName());
                annualPlan.setModifiedTimestamp(LocalDateTime.now());
//                annualPlan.setAuditObject(oldAnnualPlan.getAuditObject());
                AnnualPlan savedPlan = annualPlanRepository.save(annualPlan);
            System.out.println("Just modified modified timestamp and saved");

                List<RiskScoreDTO> riskScores = annualPlanDTO.getRiskScores();
            if (!riskScores.isEmpty()) {
                System.out.println("got  risk scores");
                double riskScoreVal = saveRiskScore(riskScores, savedPlan);
                System.out.println("evaluated this score"+riskScoreVal);
                savedPlan.setRiskScore(riskScoreVal);
                System.out.println("give that value to annual plan");
                savedPlan.setRiskLevel(getRiskLevel(savedPlan.getAuditObject().getAuditType().getId(), (int) riskScoreVal));
                System.out.println("sset risk level");
                annualPlanRepository.save(savedPlan);
                System.out.println("saved it");
            }
                resultWrapper.setResult(null);
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

        List<AuditObject> auditObjects = auditObjectRepository.findAll();
        boolean hasApproved = true;

        ResultWrapper<List<AnnualPlanDTO>> resultWrapper = new ResultWrapper<>();
        List<AnnualPlanDTO> annualPlanDTOS = new ArrayList<>();
        BudgetYear budgetYear = new BudgetYear();
        budgetYear.setYear(year);
        Optional<BudgetYear> budgetYear1 = budgetYearRepository.findByYear(year);
        if (budgetYear1.isPresent()) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage(String.format("Budget year %s already applied.", year));
            return resultWrapper;
        } else if (hasApproved) {
            budgetYearRepository.save(budgetYear);
        }





        if (year == null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Year must be provided");
            return resultWrapper;
        }
        for (AuditObject auditObject : auditObjects) {

                AnnualPlan annualPlan = new AnnualPlan();
                annualPlan.setYear(year);
                annualPlan.setStatus(AnnualPlanStatus.Pending.name());
                annualPlan.setCreatedTimestamp(LocalDateTime.now());
                annualPlan.setAuditObject(auditObject);
                annualPlan.setRiskScore(0);
                annualPlan.setRiskLevel(null);
                AnnualPlan savedAnnualPlan = annualPlanRepository.save(annualPlan);
//                int score = saveRiskScore(getRiskScoresOfAuditType(auditObject.getAuditType()), savedAnnualPlan);
//                savedAnnualPlan.setRiskScore(0);
//                savedAnnualPlan.setRiskLevel(null);
//                annualPlanRepository.save(savedAnnualPlan);
                annualPlanDTOS.add(AnnualPlanMapper.INSTANCE.toDTO(savedAnnualPlan));

        }
        resultWrapper.setStatus(true);
        resultWrapper.setMessage("Annual Plan generated successfully.");
        resultWrapper.setResult(annualPlanDTOS);

        return resultWrapper;
    }

    @Override
    public void recalculateRisks(RiskItem riskItem){
        List<AnnualPlan> annualPlans = annualPlanRepository.findAll();
        if(!annualPlans.isEmpty()){
            loger.info("loaded annual plans");
            for (AnnualPlan annualPlan:annualPlans) {
                 if (Objects.equals(annualPlan.getAuditObject().getAuditType().getId(), riskItem.getAuditType().getId())){
                     loger.info("same type");
                     RiskScore riskScore = new RiskScore();
                     riskScore.setRiskItem(riskItem);
                     riskScore.setAnnualPlan(annualPlan);
                     annualPlan.getRiskScores().add(riskScore);
                     riskScoreRepository.save(riskScore);
                List<RiskScoreDTO> riskScores = annualPlan.getRiskScores()
                        .stream()
                        .map(RiskScoreMapper.INSTANCE::toDTO)
                        .collect(Collectors.toList());
//                if (!riskScores.isEmpty()) {
//                    int riskScoreVal = saveRiskScore(riskScores, annualPlan);
//                    annualPlan.setRiskScore(riskScoreVal);
//                    annualPlan.setRiskLevel(getRiskLevel(annualPlan.getAuditObject().getAuditType().getId(),riskScoreVal));
//                    annualPlanRepository.save(annualPlan);
//                }


                 }
            }
        }
    }

    @Override
    public void updateLevel(AuditType auditType){
        List<AnnualPlan> annualPlans = annualPlanRepository.findAll();
        if(!annualPlans.isEmpty()){
            loger.info("loaded annual plans");
            for (AnnualPlan annualPlan:annualPlans) {
                if (Objects.equals(annualPlan.getAuditObject().getAuditType().getId(), auditType.getId())){
                    loger.info("same type");
                    try {
                        annualPlan.setRiskLevel(getRiskLevel(annualPlan.getAuditObject().getAuditType().getId(), (int) annualPlan.getRiskScore()));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    annualPlanRepository.save(annualPlan);


                }
            }
        }
    }

    private List<RiskScoreDTO> getRiskScoresOfAuditType(AuditType auditType) {

        List<RiskItem> riskItems = riskItemRepository.findByRiskType(auditType.getId());
        List<RiskScoreDTO> riskScores = new ArrayList<>();
        riskItems.forEach(riskItem -> {
            RiskScoreDTO riskScoreDTO = new RiskScoreDTO();
            riskScoreDTO.setRiskItem(RiskItemMapper.INSTANCE.toDTO(riskItem));
            riskScores.add(riskScoreDTO);
        });

        return riskScores;
    }

//    public int  saveRiskScore(List<RiskScoreDTO> riskScoreDTOS, AnnualPlan annualPlan) {
//        loger.info("using these dtos :{}",riskScoreDTOS);
//        int totalScore = 0;
//        if (!riskScoreDTOS.isEmpty()) {
//
//            for (RiskScoreDTO riskScoreDTO : riskScoreDTOS) {
//                int score = riskScoreDTO.getImpact();
//                totalScore += score;
//                riskScoreDTO.setTotal(score);
//                RiskScore riskScore = RiskScoreMapper.INSTANCE.toEntity(riskScoreDTO);
//                riskScore.setAnnualPlan(annualPlan);
//                riskScoreRepository.save(riskScore);
//            }
//        }
//
//        return totalScore;
//    }



    // Set the total score in the DTO (store as double to avoid rounding issues)

    // Map RiskScoreDTO to RiskScore entity and save it
//            RiskScore riskScore = RiskScoreMapper.INSTANCE.toEntity(riskScoreDTO);
//            riskScore.setAnnualPlan(annualPlan);
//            System.out.println("save specific risk score");
//            riskScoreRepository.save(riskScore);
//public double saveRiskScore(List<RiskScoreDTO> riskScoreDTOS, AnnualPlan annualPlan) {
//    loger.info("using these dtos :{}", riskScoreDTOS);
//    double totalScore = 0.0;  // Use double for total score to keep precision
//
//    // Make sure the list is not empty
//    if (!riskScoreDTOS.isEmpty()) {
//        for (RiskScoreDTO riskScoreDTO : riskScoreDTOS) {
//            System.out.println("for " + riskScoreDTO.getRiskItem().getName());
//            // Get the weight of the RiskItem (assuming it is stored in the RiskItem object)
//            double weight = riskScoreDTO.getRiskItem().getWeight();  // Assuming 'getWeight' method exists
//            System.out.println("its weight " + weight);
//            int impact = riskScoreDTO.getImpact();
//            System.out.println("its impact " + impact);
//
//            // Multiply impact by weight (weight is a percentage, so divide by 100 to get a multiplier)
//            double weightedImpact = impact * (weight / 100.0);  // Multiply impact by weight as percentage
//            System.out.println("its weighted impact " + weightedImpact);
//
//            // Add the weighted impact to totalScore
//            totalScore += weightedImpact;
//
//
//        }
//    }
//
//    return totalScore;  // Return the total score as a double
//}

    public double saveRiskScore(List<RiskScoreDTO> riskScoreDTOS, AnnualPlan annualPlan) {
        loger.info("Using these DTOs: {}", riskScoreDTOS);
        double totalScore = 0.0;  // Use double for total score to keep precision

        // Make sure the list is not empty
        if (!riskScoreDTOS.isEmpty()) {
            for (RiskScoreDTO riskScoreDTO : riskScoreDTOS) {
                System.out.println("For RiskItem: " + riskScoreDTO.getRiskItem().getName());

                // Get the weight of the RiskItem (assuming it is stored in the RiskItem object)
                double weight = riskScoreDTO.getRiskItem().getWeight();  // Assuming 'getWeight' method exists
                System.out.println("Its weight: " + weight);

                int impact = riskScoreDTO.getImpact();
                System.out.println("Its impact: " + impact);

                // Multiply impact by weight (weight is a percentage, so divide by 100 to get a multiplier)
                double weightedImpact = impact * (weight / 100.0);  // Multiply impact by weight as percentage
                System.out.println("Its weighted impact: " + weightedImpact);

                // Add the weighted impact to the totalScore
                totalScore += weightedImpact;

                // Persist the RiskScore entity
                RiskScore riskScore;

                // If the RiskScore has an ID (it exists in the database), update it; otherwise, create a new one
                if (riskScoreDTO.getId() != null) {
                    // Fetch existing RiskScore from the database
                    riskScore = riskScoreRepository.findById(riskScoreDTO.getId()).orElse(new RiskScore());
                } else {
                    // Create a new RiskScore if no ID is provided
                    riskScore = new RiskScore();
                }

                // Set values for the RiskScore entity
                riskScore.setImpact(impact);

                // Save the RiskScore entity (either update or create)
                riskScoreRepository.save(riskScore);
            }
        }

        return totalScore;  // Return the total score as a double
    }

    @Override
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
