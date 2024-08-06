package com.cbo.audit.service.impl;

import com.cbo.audit.persistence.model.Report;
import com.cbo.audit.service.ReportService;
import com.cbo.audit.service.WordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
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

        createParagraph(document, "Baankii Hojii Gamtaa Oromiyaa (W.A)", "00AEEF", 18, ParagraphAlignment.CENTER, 10, 1);
        createParagraph(document, "Cooperative Bank of Oromia (S.C)", "00AEEF", 18, ParagraphAlignment.CENTER, 10, 5);

        createParagraph(document, "INTERNAL AUDIT PROCESS", "00AEEF", 18, ParagraphAlignment.CENTER, 10);
        createParagraph(document, report.getAuditSchedule().getAnnualPlan().getAuditObject().getAuditType() + " Report On " + report.getAuditSchedule().getAnnualPlan().getAuditObject().getName(), "00AEEF", 18, ParagraphAlignment.CENTER, 10, 16);

        XWPFParagraph dateParagraph = document.createParagraph();
        dateParagraph.setAlignment(ParagraphAlignment.RIGHT);
        XWPFRun dateRun = dateParagraph.createRun();
        dateRun.setText(getCurrentMonthYear());
        dateRun.setFontSize(10);

        XWPFParagraph pageBreak = document.createParagraph();
        pageBreak.setPageBreak(true);

        // Introduction
        createSection(document, "Introduction", report.getIntroduction());

        // Summary
        createSection(document, "Summary", report.getSummary());

        // Methodology
        createSection(document, "Methodology", report.getMethodology());

        // Change to Landscape mode
        changeOrientation(document, "landscape");

        XWPFParagraph tableTitleParagraph = document.createParagraph();
        XWPFRun tableTitleRun = tableTitleParagraph.createRun();
        tableTitleRun.setText("Audit Findings, Recommendations, and Response Summary");
        tableTitleRun.setFontSize(16);
        tableTitleRun.setBold(true);
        tableTitleParagraph.setAlignment(ParagraphAlignment.CENTER);

        XWPFTable table = document.createTable(1, 5); // 1 row, 5 columns
        table.setWidth("100%");

        for (int col = 0; col < 5; col++) {
            CTTblWidth colWidth = table.getRow(0).getCell(col).getCTTc().addNewTcPr().addNewTcW();
            colWidth.setType(STTblWidth.DXA);
            colWidth.setW(BigInteger.valueOf(3168)); // 1/1440 inch
        }

        for (int col = 0; col < 5; col++) {
            XWPFTableCell cell = table.getRow(0).getCell(col);
            cell.setColor("00AEEF");
            XWPFParagraph titleParagraph = cell.addParagraph();
            XWPFRun titleRun = titleParagraph.createRun();
            titleRun.setColor("FFFFFF");
            titleRun.setBold(true);
            titleRun.setText(getColumnTitle(col));
        }

        // Construct the file path
        String filePath = documentSaveDirectory + "/example.docx";

        // Save the document
        try (FileOutputStream out = new FileOutputStream(filePath)) {
            document.write(out);
            log.info("Word document created successfully at: {}", filePath);
        } catch (IOException e) {
            log.error("Error generating Word document", e);
            throw e;
        }
    }

    private void createParagraph(XWPFDocument document, String text, String color, int fontSize, ParagraphAlignment alignment, int spacingAfter) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(text);
        run.setColor(color);
        run.setFontSize(fontSize);
        paragraph.setAlignment(alignment);
        paragraph.setSpacingAfter(spacingAfter);
    }

    private void createParagraph(XWPFDocument document, String text, String color, int fontSize, ParagraphAlignment alignment, int spacingAfter, int carriageReturns) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(text);
        run.setColor(color);
        run.setFontSize(fontSize);
        paragraph.setAlignment(alignment);
        paragraph.setSpacingAfter(spacingAfter);

        // Add carriage returns
        for (int i = 0; i < carriageReturns; i++) {
            run.addCarriageReturn();
        }
    }


    private void createSection(XWPFDocument document, String title, String content) {
        createParagraph(document, title, "00AEEF", 18, ParagraphAlignment.CENTER, 10);

        XWPFParagraph contentParagraph = document.createParagraph();
        contentParagraph.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun contentRun = contentParagraph.createRun();
        contentRun.setText(parseHtml(content));
        contentRun.setFontSize(10);
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
                    result.append(currentTagContent.toString());
                    currentTagContent.setLength(0);
                }
            } else if (c == '>') {
                insideTag = false;
            } else if (!insideTag) {
                currentTagContent.append(c);
            }
        }

        if (currentTagContent.length() > 0) {
            result.append(currentTagContent.toString());
        }

        return result.toString();
    }

    private String getColumnTitle(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "ID";
            case 1:
                return "Finding";
            case 2:
                return "Criteria";
            case 3:
                return "Impact";
            case 4:
                return "Recommendation";
            default:
                return "";
        }
    }

    private void changeOrientation(XWPFDocument document, String orientation) {
        CTDocument1 doc = document.getDocument();
        CTBody body = doc.getBody();
        CTSectPr section = body.addNewSectPr();
        XWPFParagraph para = document.createParagraph();
        CTP ctp = para.getCTP();
        CTPPr br = ctp.addNewPPr();
        br.setSectPr(section);

        CTPageSz pageSize = section.isSetPgSz() ? section.getPgSz() : section.addNewPgSz();
        if (pageSize == null) {
            pageSize = section.addNewPgSz();
        }

        if (orientation.equals("landscape")) {
            pageSize.setOrient(STPageOrientation.LANDSCAPE);
            pageSize.setW(BigInteger.valueOf(15840));
            pageSize.setH(BigInteger.valueOf(12240));
        } else {
            pageSize.setOrient(STPageOrientation.PORTRAIT);
            pageSize.setW(BigInteger.valueOf(12240));
            pageSize.setH(BigInteger.valueOf(15840));
        }
    }


}
