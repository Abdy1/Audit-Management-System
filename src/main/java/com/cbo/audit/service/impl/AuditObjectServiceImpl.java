package com.cbo.audit.service.impl;

import com.cbo.audit.dto.AuditObjectDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.enums.AnnualPlanStatus;
import com.cbo.audit.enums.AuditObjectStatus;
import com.cbo.audit.mapper.AuditObjectMapper;
import com.cbo.audit.persistence.model.*;
import com.cbo.audit.persistence.repository.*;
import com.cbo.audit.service.AnnualPlanService;
import com.cbo.audit.service.AuditObjectService;
import com.cbo.audit.service.BudgetYearService;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.poi.ss.usermodel.*;
@Service("auditObjectService")
@Transactional
public class AuditObjectServiceImpl implements AuditObjectService {
    private static final Logger logger = LoggerFactory.getLogger(AuditObjectServiceImpl.class);


    @Autowired
    private AuditObjectRepository auditObjectRepository;

    @Autowired
    private RiskScoreRepository riskScoreRepository ;
    @Autowired
    private AnnualPlanService annualPlanService;

    @Autowired
    private AuditTypeRepository auditTypeRepository;

    @Autowired
    private AuditUniverseRepository auditUniverseRepository;

    @Autowired
    private RiskItemRepository riskItemRepository;

    @Autowired
    private AnnualPlanRepository annualPlanRepository;

    @Autowired
    private BudgetYearService budgetYearService;

    public AuditObjectServiceImpl() {
    }


    @Override
    public ResultWrapper<AuditObjectDTO> registerAuditObject(AuditObjectDTO auditObjectDTO) {
        ResultWrapper<AuditObjectDTO> resultWrapper = new ResultWrapper<>();

        if (auditObjectDTO.getName() == null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Object name cannot be null.");
            return resultWrapper;
        } else if (auditObjectDTO.getAuditType() == null) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit Object type cannot be null.");
        }



        AuditObject auditObject = AuditObjectMapper.INSTANCE.toEntity(auditObjectDTO);
        auditObject.setCreatedTimestamp(LocalDateTime.now());
        auditObject.setStatus(AuditObjectStatus.Approved.name());
        AuditObject savedPlan = auditObjectRepository.save(auditObject);

        resultWrapper.setStatus(true);
        resultWrapper.setResult(AuditObjectMapper.INSTANCE.toDTO(savedPlan));
        resultWrapper.setMessage("Audit Object created successfully.");
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AuditObjectDTO>> getAllAuditObject() {
        ResultWrapper<List<AuditObjectDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditObject> auditObjects = auditObjectRepository.findAll();
        if (!auditObjects.isEmpty()) {
            List<AuditObjectDTO> auditObjectDTOS = AuditObjectMapper.INSTANCE.auditObjectsToAuditObjectDTOs(auditObjects);
            resultWrapper.setResult(auditObjectDTOS);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }


    @Override
    public ResultWrapper<AuditObjectDTO> getAuditObjectById(Long id) {

        ResultWrapper<AuditObjectDTO> resultWrapper = new ResultWrapper<>();
        AuditObject auditObject = auditObjectRepository.findById(id).orElse(null);
        if (auditObject != null) {
            AuditObjectDTO auditObjectDTO = AuditObjectMapper.INSTANCE.toDTO(auditObject);
            resultWrapper.setResult(auditObjectDTO);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public Optional<AuditObject> findAuditObjectById(Long id) {
        return auditObjectRepository.findById(id);
    }


    @Override
    public ResultWrapper<List<AuditType>> getAllAuditType() {

        ResultWrapper<List<AuditType>> resultWrapper = new ResultWrapper<>();
        List<AuditType> auditObjects = auditTypeRepository.findAll();
        if (!auditObjects.isEmpty()) {
            resultWrapper.setResult(auditObjects);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<AuditObjectDTO>> getAuditObjectByAuditType(String auditType) {

        ResultWrapper<List<AuditObjectDTO>> resultWrapper = new ResultWrapper<>();
        List<AuditObject> auditObjects = auditObjectRepository.findAuditObjectsByAuditType(auditType);
        if (!auditObjects.isEmpty()) {
            List<AuditObjectDTO> auditObjectDTOS = AuditObjectMapper.INSTANCE.auditObjectsToAuditObjectDTOs(auditObjects);
            resultWrapper.setResult(auditObjectDTOS);
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }


    @Override
    public ResultWrapper<AuditObjectDTO> updateAuditObject(AuditObjectDTO auditObjectDTO) {

        ResultWrapper<AuditObjectDTO> resultWrapper = new ResultWrapper<>(auditObjectDTO);

        AuditObject oldUniverse = auditObjectRepository.findById(auditObjectDTO.getId()).orElse(null);

        if (oldUniverse != null) {
            if (auditObjectDTO.getName() == null) {
                resultWrapper.setStatus(false);
                resultWrapper.setMessage("Audit Object name cannot be null.");
            } else if (auditObjectDTO.getAuditType() == null) {
                resultWrapper.setStatus(false);
                resultWrapper.setMessage("Audit Object type cannot be null.");
            } else {

                AuditObject auditObject = AuditObjectMapper.INSTANCE.toEntity(auditObjectDTO);
                logger.info("prev status: {}",oldUniverse.getStatus());


                auditObject.setCreatedTimestamp(oldUniverse.getCreatedTimestamp());
                auditObject.setCreatedUser(oldUniverse.getCreatedUser());
                auditObject.setStatus(oldUniverse.getStatus());

                AuditObject savedUniverse = auditObjectRepository.save(auditObject);
                resultWrapper.setResult(AuditObjectMapper.INSTANCE.toDTO(savedUniverse));
                resultWrapper.setStatus(true);
                resultWrapper.setMessage("Audit Object updated successfully.");
            }
        } else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Audit object with the provided id is not available.");
        }

        return resultWrapper;
    }

    @Override
    public ResultWrapper<AuditObjectDTO> approveAuditObject(Long id){
        ResultWrapper<AuditObjectDTO> resultWrapper = new ResultWrapper<>();

        AuditObject auditObject = auditObjectRepository.findById(id).orElse(null);

        if(auditObject == null){
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("No Audit Object found with the provided Id.");
        }else{
            auditObject.setStatus(AuditObjectStatus.Approved.name());
            AuditObject saved = auditObjectRepository.save(auditObject);
            resultWrapper.setStatus(true);
            resultWrapper.setResult(AuditObjectMapper.INSTANCE.toDTO(saved));
            resultWrapper.setMessage("Annual Plan Approved successfully.");
        }

        return resultWrapper;
    }
    @Transactional
    public void uploadAuditObjectsFromExcel(MultipartFile file, Long auditTypeId) throws IOException {
        // Initialize Workbook and Sheet
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        Row firstRow = sheet.getRow(0);  // First row containing data

        // Get the AuditType
        AuditType auditType = auditTypeRepository.getById(auditTypeId);
        System.out.println("Audit Type fetched: " + auditType.getName());

        String year  = budgetYearService.getBudgetYear().getResult().getYear();

        int sumOfRatingColumn = -1;

        // List to hold the RiskItems
        List<RiskItem> riskItems = new ArrayList<>();

        // Step 1: Extract RiskItems (names and weights)
        for (int i = 2; i < firstRow.getPhysicalNumberOfCells(); i += 2) {
            String name = firstRow.getCell(i).getStringCellValue().trim();
            if (name.equalsIgnoreCase("Sum of Rating")) {
                sumOfRatingColumn = i;
                break; // Stop once we find "Sum of Rating"
            }

            // Ignore weight column (for now, as we don't need to use it for RiskScores)
            Cell weightCell = firstRow.getCell(i + 1);
            Integer weight = (weightCell != null && weightCell.getCellType() == CellType.NUMERIC)
                    ? (int) weightCell.getNumericCellValue()
                    : null;

            // Create and save RiskItem
            RiskItem riskItem = new RiskItem();
            riskItem.setName(name);
            riskItem.setWeight(weight);
            riskItem.setAuditType(auditType);
            riskItemRepository.save(riskItem); // Assuming you have a repository for saving RiskItems

            riskItems.add(riskItem); // Add to list for later processing
            System.out.println("Created RiskItem: " + name + ", Weight: " + weight);
        }

        // Step 2: Process each row and create AuditObject + RiskScores
        for (int rowIndex = 1; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            if (row == null) continue;

            // Step 2.1: Extract AuditObject name
            Cell nameCell = row.getCell(1);
            if (nameCell == null || nameCell.getStringCellValue().trim().isEmpty()) continue;

            String name = nameCell.getStringCellValue().trim();
            Cell riskScoreCell = row.getCell(sumOfRatingColumn + 1); // Next column after "Sum of Rating"
            double riskScoreval = 0;

            riskScoreval = riskScoreCell.getNumericCellValue();

            System.out.println("---extracted risk score" + riskScoreval);

            AuditObject auditObject = new AuditObject();
            auditObject.setName(name);
            auditObject.setAuditType(auditType);
            auditObjectRepository.save(auditObject); // Assuming you have a repository for saving AuditObjects

            // Create and persist AnnualPlan
            AnnualPlan annualPlan = new AnnualPlan();
            annualPlan.setStatus(AnnualPlanStatus.Pending.name());
            annualPlan.setCreatedTimestamp(LocalDateTime.now());
            annualPlan.setAuditObject(auditObject);
            annualPlan.setYear(year);
            annualPlan.setRiskLevel(annualPlanService.getRiskLevel(auditType.getId(), (int) riskScoreval));
            annualPlan.setRiskScore(riskScoreval);


            annualPlanRepository.save(annualPlan);
            System.out.println("Created AnnualPlan for: " + name);

            List<RiskScore> riskScores = new ArrayList<>();

            // Step 2.2: Create RiskScores for each RiskItem
            for (int i = 0; i < riskItems.size(); i++) {
                RiskItem riskItem = riskItems.get(i);
                Cell impactCell = row.getCell(i * 2 + 2); // The column directly under the RiskItem name

                if (impactCell != null && impactCell.getCellType() == CellType.NUMERIC) {
                    double impact = impactCell.getNumericCellValue();

                    RiskScore riskScore = new RiskScore();
                    riskScore.setRiskItem(riskItem);
                    riskScore.setImpact((int) impact); // Assuming impact is an integer
                    riskScore.setAnnualPlan(annualPlan); // Now set the AnnualPlan on the RiskScore

                    riskScores.add(riskScore);
                    riskScoreRepository.save(riskScore); // Save RiskScore to DB

                    System.out.println("Created RiskScore for: " + riskItem.getName() + " with impact: " + impact);
                }
            }
        }

        // Step 3: Close the workbook
        workbook.close();
    }

//    @Transactional
//    public void uploadAuditObjectsFromExcel(MultipartFile file, Long auditTypeId) throws IOException {
//        // Initialize Workbook and Sheet
//        Workbook workbook = new XSSFWorkbook(file.getInputStream());
//        Sheet sheet = workbook.getSheetAt(0);
//        Row firstRow = sheet.getRow(0);  // First row containing data
//
//        // Get the AuditType
//        AuditType auditType = auditTypeRepository.getById(auditTypeId);
//        System.out.println("Audit Type fetched: " + auditType.getName());
//
//        String year  = budgetYearService.getBudgetYear().getResult().getYear();
//
//        int sumOfRatingColumn = -1;
//
//        // List to hold the RiskItems
//        List<RiskItem> riskItems = new ArrayList<>();
//
//        // Step 1: Extract RiskItems (names and weights)
//        for (int i = 2; i < firstRow.getPhysicalNumberOfCells(); i += 2) {
//            String name = firstRow.getCell(i).getStringCellValue().trim();
//            if (name.equalsIgnoreCase("Sum of Rating")) {
//                sumOfRatingColumn = i;
//                break; // Stop once we find "Sum of Rating"
//            }
//
//            // Ignore weight column (for now, as we don't need to use it for RiskScores)
//            Cell weightCell = firstRow.getCell(i + 1);
//            Integer weight = (weightCell != null && weightCell.getCellType() == CellType.NUMERIC)
//                    ? (int) weightCell.getNumericCellValue()
//                    : null;
//
//            // Create and save RiskItem
//            RiskItem riskItem = new RiskItem();
//            riskItem.setName(name);
//            riskItem.setWeight(weight);
//            riskItem.setAuditType(auditType);
//            riskItemRepository.save(riskItem); // Assuming you have a repository for saving RiskItems
//
//            riskItems.add(riskItem); // Add to list for later processing
//            System.out.println("Created RiskItem: " + name + ", Weight: " + weight);
//        }
//
//        // Step 2: Process each row and create AuditObject + RiskScores
//        for (int rowIndex = 1; rowIndex < sheet.getPhysicalNumberOfRows(); rowIndex++) {
//            Row row = sheet.getRow(rowIndex);
//            if (row == null) continue;
//
//            // Step 2.1: Extract AuditObject name
//            Cell nameCell = row.getCell(1);
//            if (nameCell == null || nameCell.getStringCellValue().trim().isEmpty()) continue;
//
//            String name = nameCell.getStringCellValue().trim();
//            Cell riskScoreCell = row.getCell(sumOfRatingColumn + 1); // Next column after "Sum of Rating"
//            double riskScoreval = 0;
//
//            riskScoreval = riskScoreCell.getNumericCellValue();
//
//            System.out.println("---extracted risk score" + riskScoreval);
//
//            AuditObject auditObject = new AuditObject();
//            auditObject.setName(name);
//            auditObject.setAuditType(auditType);
//            auditObjectRepository.save(auditObject); // Assuming you have a repository for saving AuditObjects
//
//            List<RiskScore> riskScores = new ArrayList<>();
//
//            // Step 2.2: Create RiskScores for each RiskItem
//            for (int i = 0; i < riskItems.size(); i++) {
//                RiskItem riskItem = riskItems.get(i);
//                Cell impactCell = row.getCell(i * 2 + 2); // The column directly under the RiskItem name
//
//                if (impactCell != null && impactCell.getCellType() == CellType.NUMERIC) {
//                    double impact = impactCell.getNumericCellValue();
//
//                    RiskScore riskScore = new RiskScore();
//                    riskScore.setRiskItem(riskItem);
//                    riskScore.setImpact((int) impact); // Assuming impact is an integer
//                    riskScore.setAnnualPlan(null); // Do not set the AnnualPlan yet
//
//                    riskScores.add(riskScore);
//                    riskScoreRepository.save(riskScore); // Save RiskScore to DB
//
//                    System.out.println("Created RiskScore for: " + riskItem.getName() + " with impact: " + impact);
//                }
//            }
//
//            // Step 2.3: Create and link AnnualPlan
//            AnnualPlan annualPlan = new AnnualPlan();
//            annualPlan.setStatus(AnnualPlanStatus.Pending.name());
//            annualPlan.setCreatedTimestamp(LocalDateTime.now());
//            annualPlan.setAuditObject(auditObject);
//            annualPlan.setYear(year);
//            annualPlan.setRiskLevel(annualPlanService.getRiskLevel(auditType.getId(), (int) riskScoreval));
//            annualPlan.setRiskScore(riskScoreval);
//
//            // Now, set the AnnualPlan on each RiskScore
//            for (RiskScore riskScore : riskScores) {
//                riskScore.setAnnualPlan(annualPlan); // Set the AnnualPlan on each RiskScore
//                riskScoreRepository.save(riskScore); // Re-save RiskScore with the AnnualPlan link
//            }
//
////            annualPlan.setRiskScores(riskScores); // Link the RiskScores to the AnnualPlan
//
//            annualPlanRepository.save(annualPlan); // Save AnnualPlan to DB
//            System.out.println("Created AnnualPlan for: " + name);
//        }
//
//        // Step 3: Close the workbook
//        workbook.close();
//    }



}

