package com.cbo.audit.controller;

import com.cbo.audit.dto.CutOffDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.service.CutOffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CutOffController {

    @Autowired
    private CutOffService cutOffService;

    // Create a new CutOff
    @PostMapping("value = URIs.CUT_OFF_REGISTER, consumes = MediaType.APPLICATION_JSON_VALUE")
    public ResponseEntity<ResultWrapper<CutOffDTO>> createCutOff(@RequestBody CutOffDTO cutOffDTO) {
        ResultWrapper<CutOffDTO> result = cutOffService.registerCutOff(cutOffDTO);
        if (result.isStatus()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping("value = CUT_OFF_GET_ID, produces = MediaType.APPLICATION_JSON_VALUE")
    public ResponseEntity<ResultWrapper<CutOffDTO>> getCutOffById(@PathVariable Long id) {
        ResultWrapper<CutOffDTO> result = cutOffService.getCutOffById(id);
        if (result.isStatus()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("value = CUT_OFF_GET_ALL, produces = MediaType.APPLICATION_JSON_VALUE")
    public ResponseEntity<ResultWrapper<List<CutOffDTO>>> getAllCutOffs() {
        ResultWrapper<List<CutOffDTO>> result = cutOffService.getAllCutOffs();
        return ResponseEntity.ok(result);
    }

    @PutMapping("value = CUT_OFF_UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE")
    public ResponseEntity<ResultWrapper<CutOffDTO>> updateCutOff(@RequestBody CutOffDTO cutOffDTO) {
        ResultWrapper<CutOffDTO> result = cutOffService.updateCutOff(cutOffDTO);
        if (result.isStatus()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}
