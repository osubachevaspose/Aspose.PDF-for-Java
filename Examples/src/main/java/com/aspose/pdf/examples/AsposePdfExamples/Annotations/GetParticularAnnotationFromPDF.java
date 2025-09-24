package com.aspose.pdf.examples.AsposePdfExamples.Annotations;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextAnnotation;
import com.aspose.pdf.examples.Utils;

public class GetParticularAnnotationFromPDF {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Annotations/GetParticularAnnotationFromPDF/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example getParticularAnnotationFromPDF start");
        getParticularAnnotationFromPDF(dataDir);
        System.out.println("Example getParticularAnnotationFromPDF end");
    }

    private static void getParticularAnnotationFromPDF(String dataDir) {
        // Open source PDF document
        Document doc = new Document(dataDir + "PdfWithAnnotation.pdf");
        try {
            // Get particular annotation
            TextAnnotation textAnnotation = (TextAnnotation) doc.getPages().get_Item(1).getAnnotations().get_Item(1);
            // Get annotation properties
            System.out.println("Title: " + textAnnotation.getTitle());
            System.out.println("Subject:  " + textAnnotation.getSubject());
            System.out.println("Contents: " + textAnnotation.getContents());
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
