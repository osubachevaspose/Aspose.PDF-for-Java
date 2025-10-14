package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.PdfSaveOptions;
import com.aspose.pdf.examples.Utils;

public class SetDefaultFont {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/DocumentObject/SetDefaultFont/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example setDefaultFont start");
        setDefaultFont(dataDir, outputDir);
        System.out.println("Example setDefaultFont end");
    }

    public static void setDefaultFont(String dataDir, String outputDir) {
        // Load an exisiting PDF document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Initialize save options for PDF format
            PdfSaveOptions options = new PdfSaveOptions();
            // Set default font name
            options.setDefaultFontName("Arial");
            // Save PDF file
            doc.save(outputDir + "output_out.pdf", options);
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
