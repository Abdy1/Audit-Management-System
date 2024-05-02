package com.cbo.audit.service.impl;

import com.cbo.audit.service.WordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;

@Service("wordService")
@Slf4j
public class WordServiceImpl implements WordService {

    @Value("${document.save.directory}")
    private String documentSaveDirectory;

    @Override
    public void createWordDocument() throws IOException {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("Hello, World! This is a Word document created using Spring Boot.");

        // Construct the file path
        String filePath = documentSaveDirectory + "/example.docx";

        // Save the document to the configured directory
        try (FileOutputStream out = new FileOutputStream(filePath)) {
            document.write(out);
            log.info("Word document created successfully at: {}", filePath);
        } catch (IOException e) {
            log.error("Error generating Word document", e);
            throw e;
        }
    }
}
