package com.cbo.audit.service.impl;
import com.cbo.audit.dto.ReportDTO;
import com.cbo.audit.dto.ResultWrapper;
import com.cbo.audit.persistence.model.Report;
import com.cbo.audit.service.ReportService;
import com.cbo.audit.service.WordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPageOrientation;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service("wordService")
@Slf4j
public class WordServiceImpl implements WordService {

    @Value("${document.save.directory}")
    private String documentSaveDirectory;

    @Autowired
    private ReportService reportService;

    @Override
    public void createWordDocument(Long reportId) throws IOException {
        Report report = reportService.getReportById1(reportId).getResult();
        XWPFDocument document = new XWPFDocument();

        // Define section properties for the first page (portrait orientation)
        CTSectPr sectPr1 = document.getDocument().getBody().addNewSectPr();

        // Create the first paragraph with the first two lines
        XWPFParagraph firstParagraph = document.createParagraph();
        XWPFRun firstRun = firstParagraph.createRun();
        firstRun.setText("Baankii Hojii Gamtaa Oromiyaa (W.A)");
        firstRun.setColor("00AEEF"); // Blue color (hex code)
        firstRun.setFontSize(18); // Text size 18
        firstParagraph.setAlignment(ParagraphAlignment.CENTER);
        firstParagraph.setSpacingAfter(10); // Add spacing after the paragraph

        firstRun.addCarriageReturn();

        // Create a second paragraph for the second line
        XWPFParagraph secondParagraph = document.createParagraph();
        XWPFRun secondRun = secondParagraph.createRun();
        secondRun.setText("Cooperative Bank of Oromia (S.C)");
        secondRun.setColor("00AEEF"); // Blue color (hex code)
        secondRun.setFontSize(18); // Text size 18
        secondParagraph.setAlignment(ParagraphAlignment.CENTER);
        secondParagraph.setSpacingAfter(10); // Add spacing after the paragraph


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
        //you get this data from  auditobject.audittype + Report On + Annual Plan Name
        XWPFParagraph fourthParagraph = document.createParagraph();
        XWPFRun fourthRun = fourthParagraph.createRun();
        fourthRun.setText(report.getAuditSchedule().getAnnualPlan().getAuditObject().getAuditType() + " Report On " + report.getAuditSchedule().getAnnualPlan().getName());
        fourthRun.setColor("00AEEF"); // Blue color (hex code)
        fourthRun.setFontSize(18); // Text size 18
        fourthParagraph.setAlignment(ParagraphAlignment.CENTER);
        fourthParagraph.setSpacingAfter(10); // Add spacing after the paragraph



        // Add date at the bottom right corner
        XWPFParagraph dateParagraph = document.createParagraph();
        dateParagraph.setAlignment(ParagraphAlignment.RIGHT);
        XWPFRun dateRun = dateParagraph.createRun();
        dateRun.setText(getCurrentMonthYear());
        dateRun.setFontSize(10); // Font size 10

        XWPFParagraph pageBreak = document.createParagraph();
        pageBreak.setPageBreak(true);

        //add introduction from report.introduction
        //executive summary from report.summary
        //methodology from report.methodology


        //introduction title
        XWPFParagraph introduction = document.createParagraph();
        introduction.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun introductionRun = introduction.createRun();
        introductionRun.setText("Introduction");
        introductionRun.setFontSize(18);


        //introduction content
        XWPFParagraph introductionContent = document.createParagraph();
        introductionContent.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun introductionContentRun = introductionContent.createRun();
        introductionContentRun.setText(parseHtml(report.getIntroduction()));
        introductionContentRun.setFontSize(10);

        //summary title
        XWPFParagraph summary = document.createParagraph();
        summary.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun summaryRun = summary.createRun();
        summaryRun.setText("Summary");
        summaryRun.setFontSize(18);

        //summary content
        XWPFParagraph summaryCo = document.createParagraph();
        summaryCo.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun summaryCoRun = summaryCo.createRun();
        summaryCoRun.setText(parseHtml(report.getSummary()));
        summaryCoRun.setFontSize(10);

        //methodology title
        XWPFParagraph methodology = document.createParagraph();
        methodology.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun methodologyRun = methodology.createRun();
        methodologyRun.setText("Methodology");
        methodologyRun.setFontSize(18);

        //methodology content
        XWPFParagraph methodologyCo = document.createParagraph();
        methodologyCo.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun methodologyCoRun = methodologyCo.createRun();
        methodologyCoRun.setText(report.getMethodology());
        methodologyCoRun.setFontSize(10);


        // Create a new page
        XWPFParagraph pageBreak2 = document.createParagraph();
        pageBreak2.setPageBreak(true);


        // Define section properties for the second page (landscape orientation)
        CTSectPr sectPr2 = document.getDocument().getBody().addNewSectPr();
        sectPr2.addNewPgSz().setOrient(STPageOrientation.LANDSCAPE);
        sectPr2.getPgSz().setW(BigInteger.valueOf(15840)); // 11 inches in twips
        sectPr2.getPgSz().setH(BigInteger.valueOf(12240)); // 8.5 inches in twips


        //title of table Audit findings, Recomendations and response summary
        //name of each column   id, finding, criteria , impact and recomendation


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
    private String getCurrentMonthYear() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return currentDate.format(formatter);
    }

    public static String parseHtml(String html) {
        StringBuilder result = new StringBuilder();

        StringBuilder currentTagContent = new StringBuilder();
        boolean insideTag = false;

        for (char c : html.toCharArray()) {
            if (c == '<') {
                insideTag = true;
                if (currentTagContent.length() > 0) {
                    result.append(currentTagContent.toString().trim()).append(" ");
                    currentTagContent.setLength(0);
                }
            } else if (c == '>') {
                insideTag = false;
            } else {
                if (!insideTag) {
                    currentTagContent.append(c);
                }
            }
        }

        // Add any remaining content
        if (currentTagContent.length() > 0) {
            result.append(currentTagContent.toString().trim()).append(" ");
        }

        return result.toString();
    }
}
