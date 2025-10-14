package com.aspose.pdf.examples.AsposePdfExamples.Annotations;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

public class GetAllAnnotationsFromPageInPDF {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Annotations/GetAllAnnotationsFromPageInPDF/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example getAllAnnotationsFromPageInPDF start");
        getAllAnnotationsFromPageInPDF(dataDir);
        System.out.println("Example getAllAnnotationsFromPageInPDF end");
    }

    private static void getAllAnnotationsFromPageInPDF(String dataDir) {
        // Open source PDF document
        Document doc = new Document(dataDir + "PdfWithAnnotation.pdf");
        try {
            // Loop through all the annotations
            for (int counter = 1; counter <= doc.getPages().get_Item(1).getAnnotations().size(); counter++) {
                // Get annotation properties
                System.out.println("Full Name: "
                        + doc.getPages().get_Item(counter).getAnnotations().get_Item(counter).getFullName());
                System.out.println("Page Number: "
                        + doc.getPages().get_Item(counter).getAnnotations().get_Item(counter).getPageIndex());
                System.out.println("Contents: "
                        + doc.getPages().get_Item(counter).getAnnotations().get_Item(counter).getContents());
            }
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
