package com.cbo.audit.controller;

import com.cbo.audit.constants.URIs;
import com.cbo.audit.persistence.model.Report;
import com.cbo.audit.service.WordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@Slf4j
public class WordDocumentController {

    private final WordService wordService;

    @PostMapping(URIs.CREATE_DOCUMENT)
    public ResponseEntity<String> generateWordDocument(@RequestBody Long reportId) {
        try {
            wordService.createWordDocument(reportId);
            return ResponseEntity.ok("Word document generated successfully!");
        } catch (IOException e) {
            log.error("Error generating Word document", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating Word document");
        }
    }
}
