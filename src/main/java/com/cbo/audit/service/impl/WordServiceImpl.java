package com.cbo.audit.service.impl;
import com.cbo.audit.service.WordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPageOrientation;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

@Service("wordService")
@Slf4j
public class WordServiceImpl implements WordService {

    @Value("${document.save.directory}")
    private String documentSaveDirectory;

    @Override
    public void createWordDocument() throws IOException {
        XWPFDocument document = new XWPFDocument();

        // Define section properties for the first page (portrait orientation)
        CTSectPr sectPr1 = document.getDocument().getBody().addNewSectPr();
        sectPr1.addNewPgSz().setOrient(STPageOrientation.PORTRAIT);
        // Create the first paragraph with the first two lines
        XWPFParagraph firstParagraph = document.createParagraph();
        XWPFRun firstRun = firstParagraph.createRun();
        firstRun.setText("Baankii Hojii Gamtaa Oromiyaa (W.A)");
        firstRun.setColor("00AEEF"); // Blue color (hex code)
        firstRun.setFontSize(18); // Text size 18
        firstParagraph.setAlignment(ParagraphAlignment.CENTER);
        firstParagraph.setSpacingAfter(10); // Add spacing after the paragraph

        // Add a carriage return to simulate vertical alignment
        firstRun.addCarriageReturn();

        // Create a second paragraph for the second line
        XWPFParagraph secondParagraph = document.createParagraph();
        XWPFRun secondRun = secondParagraph.createRun();
        secondRun.setText("Cooperative Bank of Oromia (S.C)");
        secondRun.setColor("00AEEF"); // Blue color (hex code)
        secondRun.setFontSize(18); // Text size 18
        secondParagraph.setAlignment(ParagraphAlignment.CENTER);
        secondParagraph.setSpacingAfter(10); // Add spacing after the paragraph

        // Add multiple carriage returns to simulate vertical alignment
        for (int i = 0; i < 5; i++) {
            secondRun.addCarriageReturn();
        }

        // Create a third paragraph for the third line
        XWPFParagraph thirdParagraph = document.createParagraph();
        XWPFRun thirdRun = thirdParagraph.createRun();
        thirdRun.setText("INTERNAL AUDIT PROCESS");
        thirdRun.setColor("00AEEF"); // Blue color (hex code)
        thirdRun.setFontSize(18); // Text size 18
        thirdParagraph.setAlignment(ParagraphAlignment.CENTER);
        thirdParagraph.setSpacingBefore(10); // Add spacing before the paragraph

        // Create a fourth paragraph for the fourth line
        XWPFParagraph fourthParagraph = document.createParagraph();
        XWPFRun fourthRun = fourthParagraph.createRun();
        fourthRun.setText("IT Audit Report on Core system audit");
        fourthRun.setColor("00AEEF"); // Blue color (hex code)
        fourthRun.setFontSize(18); // Text size 18
        fourthParagraph.setAlignment(ParagraphAlignment.CENTER);
        fourthParagraph.setSpacingAfter(10); // Add spacing after the paragraph

        // Create a new page
        XWPFParagraph pageBreak = document.createParagraph();
        pageBreak.setPageBreak(true);

        // Define section properties for the second page (landscape orientation)
        CTSectPr sectPr2 = document.getDocument().getBody().addNewSectPr();
        sectPr2.addNewPgSz().setOrient(STPageOrientation.LANDSCAPE);
        sectPr2.getPgSz().setW(BigInteger.valueOf(15840)); // 11 inches in twips
        sectPr2.getPgSz().setH(BigInteger.valueOf(12240)); // 8.5 inches in twips

        // Create a new paragraph for the table
        XWPFParagraph tableParagraph = document.createParagraph();
        XWPFTable table = document.createTable(1, 5); // Create a 1 row, 5 column table

        // Set column width for all columns
        table.setWidth("100%");
        for (int col = 0; col < 5; col++) {
            CTTblWidth colWidth = table.getRow(0).getCell(col).getCTTc().addNewTcPr().addNewTcW();
            colWidth.setType(STTblWidth.DXA);
            colWidth.setW(BigInteger.valueOf(4000)); // Set width in twips (1/1440 inch)
        }

        // Set cell background color and add white title
        for (int col = 0; col < 5; col++) {
            XWPFTableCell cell = table.getRow(0).getCell(col);
            cell.setColor("00AEEF"); // Blue color (hex code)
            XWPFParagraph titleParagraph = cell.addParagraph();
            XWPFRun titleRun = titleParagraph.createRun();
            titleRun.setColor("FFFFFF"); // White color (hex code)
            titleRun.setText("Title " + (col + 1));
        }

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
