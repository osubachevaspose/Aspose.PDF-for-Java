package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.PdfFormat;
import com.aspose.pdf.examples.Utils;

public class ValidatePDF {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/TaggedPDFs/ValidatePDF/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example validatePDF start");
        validatePDF(dataDir, outputDir);
        System.out.println("Example validatePDF end");
    }

    public static void validatePDF(String dataDir, String outputDir) {
        Document doc = new Document(dataDir + "StructureElements.pdf");
        try {
            Boolean isValid = doc.validate(outputDir + "ua-20.xml", PdfFormat.PDF_UA_1);
            System.out.println(isValid);
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
