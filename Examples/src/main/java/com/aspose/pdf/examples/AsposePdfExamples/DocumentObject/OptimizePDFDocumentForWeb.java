package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

public class OptimizePDFDocumentForWeb {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/DocumentObject/OptimizePDFDocumentForWeb/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example optimizePDFDocumentForWeb start");
        optimizePDFDocumentForWeb(dataDir, outputDir);
        System.out.println("Example optimizePDFDocumentForWeb end");
    }

    public static void optimizePDFDocumentForWeb(String dataDir, String outputDir) {
        // Open document
        Document doc = new Document(dataDir + "PDFToHTML.pdf");
        try {
            // Optimize for web
            doc.optimize();
            // Save output document
            doc.save(outputDir + "Optimized_output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
