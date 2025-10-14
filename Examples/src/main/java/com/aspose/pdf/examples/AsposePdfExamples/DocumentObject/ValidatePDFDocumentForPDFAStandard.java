package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.PdfFormat;
import com.aspose.pdf.examples.Utils;

public class ValidatePDFDocumentForPDFAStandard {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/DocumentObject/ValidatePDFDocumentForPDFAStandard/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example validatePDFDocumentForPDFAStandard start");
        validatePDFDocumentForPDFAStandard(dataDir, outputDir);
        System.out.println("Example validatePDFDocumentForPDFAStandard end");
    }

    public static void validatePDFDocumentForPDFAStandard(String dataDir, String outputDir) {
        Document doc1 = new Document(dataDir + "input.pdf");
        try {
            // validate PDF for PDF/A-1a
            doc1.validate(outputDir + "validation-result-A1A.1.xml", PdfFormat.PDF_A_1A);
        } finally {
            if (doc1 != null)
                doc1.close();
        }

        Document doc2 = new Document(dataDir + "4pagesPdfA.pdf");
        try {
            // validate PDF for PDF/A-1a
            doc2.validate(outputDir + "validation-result-A1A.2.xml", PdfFormat.PDF_A_1A);
        } finally {
            if (doc2 != null)
                doc2.close();
        }
    }
}
