package com.aspose.pdf.examples.AsposePdfExamples.Annotations;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

public class DeleteParticularAnnotationFromThePDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Annotations/DeleteParticularAnnotationFromThePDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example deleteParticularAnnotationFromThePDFFile start");
        deleteParticularAnnotationFromThePDFFile(dataDir, outputDir);
        System.out.println("Example deleteParticularAnnotationFromThePDFFile end");
    }

    private static void deleteParticularAnnotationFromThePDFFile(String dataDir, String outputDir) {
        // Open source PDF document
        Document doc = new Document(dataDir + "PdfWithAnnotation.pdf");
        try {
            // Delete particular annotation
            doc.getPages().get_Item(1).getAnnotations().delete(1);
            // Save the update document
            doc.save(outputDir + "output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
