package com.aspose.pdf.examples.AsposePdfFacades.Attachments;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfExtractor;

import java.io.File;

public class ExtractAllAttachments {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/Attachments/ExtractAllAttachments/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        // Create output directory if not exists
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example extractAllAttachments start");
        extractAllAttachments(dataDir, outputDir);
        System.out.println("Example extractAllAttachments end");
    }

    public static void extractAllAttachments(String dataDir, String outputDir) {
        PdfExtractor pdfExtractor = new PdfExtractor();
        try {
            pdfExtractor.bindPdf(dataDir + "ExtractAllAttachments.pdf");
            // extract attachments
            pdfExtractor.extractAttachment();
            // get extracted attachments
            pdfExtractor.getAttachment(outputDir);
        } finally {
            if (pdfExtractor != null)
                pdfExtractor.close();
        }
    }
}
