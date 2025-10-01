package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.PageCollection;
import com.aspose.pdf.examples.Utils;

public class UpdatePageDimensions {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Pages/UpdatePageDimensions/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example updatePageDimensions start");
        updatePageDimensions(dataDir, outputDir);
        System.out.println("Example updatePageDimensions end");
    }

    public static void updatePageDimensions(String dataDir, String outputDir) {
        // Open a document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Get the page collection
            PageCollection pageCollection = doc.getPages();
            // Get a particular page
            Page pdfPage = pageCollection.get_Item(1);
            // Set the page size as A4 (11.7 x 8.3 in). In Aspose.Pdf, 1 inch = 72 points
            // so A4 dimensions in points is (842.4, 597.6).
            pdfPage.setPageSize(597.6, 842.4);
            // Save the new PDF
            doc.save(outputDir + "Updated_document.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
