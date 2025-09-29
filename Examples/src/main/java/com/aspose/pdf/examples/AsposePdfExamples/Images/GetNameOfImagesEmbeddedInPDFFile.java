package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

public class GetNameOfImagesEmbeddedInPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Images/GetNameOfImagesEmbeddedInPDFFile/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example getNameOfImagesEmbeddedInPDFFile start");
        getNameOfImagesEmbeddedInPDFFile(dataDir);
        System.out.println("Example getNameOfImagesEmbeddedInPDFFile end");
    }

    public static void getNameOfImagesEmbeddedInPDFFile(String dataDir) {
        // Load source PDF file
        Document doc = new Document(dataDir + "PdfWith2Images.pdf");
        try {
            // Get the all images names from first page of PDF file
            for (int i = 0; i < doc.getPages().get_Item(1).getResources().getImages().size(); i++) {
                // Print the names of image file over console
                System.out.println(doc.getPages().get_Item(1).getResources().getImages().getNames()[i]);
            }
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
