package com.cbo.audit.service.impl;

import com.cbo.audit.dto.CutOffDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.mapper.CutOffMapper;
import com.cbo.audit.persistence.model.CutOff;
import com.cbo.audit.persistence.repository.CutOffRepository;
import com.cbo.audit.service.CutOffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("cutOffService")
@Transactional
public class CutOffServiceImpl implements CutOffService {

    @Autowired
    private CutOffRepository cutOffRepository;

    private String noRecord = "No record found";

    @Override
    public ResultWrapper<CutOffDTO> registerCutOff(CutOffDTO cutOffDTO) {
        ResultWrapper<CutOffDTO> resultWrapper = new ResultWrapper<>();

        // Attempt to retrieve the existing CutOff record
        Optional<CutOff> existingCutOff = cutOffRepository.findAll().stream().findFirst();
        System.out.println("Existing CutOff = " + existingCutOff.isPresent());
        CutOff cutOff;
        if (existingCutOff.isPresent()) {
            // Update the existing record
            cutOff = existingCutOff.get();
            CutOffMapper.INSTANCE.updateEntityFromDTO(cutOffDTO, cutOff);
            cutOff.setModifiedTimestamp(LocalDateTime.now());
        } else {
            // Create a new record
            cutOff = CutOffMapper.INSTANCE.toEntity(cutOffDTO);
            cutOff.setCreatedTimestamp(LocalDateTime.now());
        }

        CutOff savedCutOff = cutOffRepository.save(cutOff);

        resultWrapper.setStatus(true);
        resultWrapper.setResult(CutOffMapper.INSTANCE.toDTO(savedCutOff));
        resultWrapper.setMessage(existingCutOff.isPresent() ? "CutOff successfully updated." : "CutOff successfully registered.");

        return resultWrapper;
    }



    @Override
    public ResultWrapper<CutOffDTO> getCutOffById(Long id) {
        ResultWrapper<CutOffDTO> resultWrapper = new ResultWrapper<>();
        Optional<CutOff> cutOff = cutOffRepository.findById(id);
        if (cutOff.isPresent()) {
            CutOffDTO cutOffDTO = CutOffMapper.INSTANCE.toDTO(cutOff.get());
            resultWrapper.setResult(cutOffDTO);
            resultWrapper.setStatus(true);
        } else {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("No record found with the provided id.");
        }
        return resultWrapper;
    }

    @Override
    public ResultWrapper<CutOffDTO> updateCutOff(CutOffDTO cutOffDTO) {
        ResultWrapper<CutOffDTO> resultWrapper = new ResultWrapper<>();

        Optional<CutOff> oldCutOff = cutOffRepository.findById(cutOffDTO.getId());

        if (!oldCutOff.isPresent()) {
            resultWrapper.setStatus(false);
            resultWrapper.setMessage("Invalid CutOff id");
        } else {
            CutOff updatedCutOff = oldCutOff.get();
            updatedCutOff.setCutOff(cutOffDTO.getCutOff());
            updatedCutOff.setModifiedTimestamp(LocalDateTime.now());
            CutOff savedCutOff = cutOffRepository.save(updatedCutOff);
            resultWrapper.setResult(CutOffMapper.INSTANCE.toDTO(savedCutOff));
            resultWrapper.setStatus(true);
        }

        return resultWrapper;
    }

    @Override
    public ResultWrapper<List<CutOffDTO>> getAllCutOffs() {
        ResultWrapper<List<CutOffDTO>> resultWrapper = new ResultWrapper<>();
        List<CutOff> cutOffs = cutOffRepository.findAll();
        if (cutOffs.isEmpty()) {
            resultWrapper.setStatus(true);
            resultWrapper.setMessage(noRecord);
            resultWrapper.setResult(new ArrayList<>());
        } else {
            resultWrapper.setResult(CutOffMapper.INSTANCE.cutOffsToCutOffDTOs(cutOffs));
            resultWrapper.setStatus(true);
        }
        return resultWrapper;
    }
}

