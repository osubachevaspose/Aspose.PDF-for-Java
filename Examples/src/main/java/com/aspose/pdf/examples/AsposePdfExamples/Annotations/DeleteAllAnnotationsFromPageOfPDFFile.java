package com.aspose.pdf.examples.AsposePdfExamples.Annotations;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class DeleteAllAnnotationsFromPageOfPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Annotations/DeleteAllAnnotationsFromPageOfPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example deleteAllAnnotationsFromPageOfPDFFile start");
        deleteAllAnnotationsFromPageOfPDFFile(dataDir, outputDir);
        System.out.println("Example deleteAllAnnotationsFromPageOfPDFFile end");
    }

    private static void deleteAllAnnotationsFromPageOfPDFFile(String dataDir, String outputDir) {
        // Open source PDF document
        Document doc = new Document(dataDir + "PdfWithAnnotation.pdf");
        try {
            // Delete all annotation
            doc.getPages().get_Item(1).getAnnotations().delete();
            // Save the update document
            doc.save(outputDir + "output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
