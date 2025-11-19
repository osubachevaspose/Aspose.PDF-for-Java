package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.ExcelSaveOptions;
import com.aspose.pdf.examples.Utils;

public class ConvertPDFToExcelWorkbook {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/ConvertPDFToExcelWorkbook/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example convertPDFToExcelWorkbook start");
        convertPDFToExcelWorkbook(dataDir, outputDir);
        System.out.println("Example convertPDFToExcelWorkbook end");
    }

    private static void convertPDFToExcelWorkbook(String dataDir, String outputDir) {
        // Load PDF document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Instantiate ExcelSaveOptions object
            ExcelSaveOptions options = new ExcelSaveOptions();
            // Save the output to XLSX format
            doc.save(outputDir + "ConvertedFile.xlsx", options);
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
