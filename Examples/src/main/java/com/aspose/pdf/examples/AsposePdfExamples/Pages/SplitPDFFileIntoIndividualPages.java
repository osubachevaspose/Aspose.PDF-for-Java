package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

public class SplitPDFFileIntoIndividualPages {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Pages/SplitPDFFileIntoIndividualPages/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example splitPDFFileIntoIndividualPages start");
        splitPDFFileIntoIndividualPages(dataDir, outputDir);
        System.out.println("Example splitPDFFileIntoIndividualPages end");
    }

    public static void splitPDFFileIntoIndividualPages(String dataDir, String outputDir) {
        // Open a document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Loop through the pages
            for (int i = 1; i <= doc.getPages().size(); i++) {
                // Create a new Document object
                Document newDoc = new Document();
                try {
                    // Get the page at a given index of the Page Collection
                    newDoc.getPages().add(doc.getPages().get_Item(i));
                    // Save the new PDF file
                    newDoc.save(outputDir + "page_" + i + ".pdf");
                } finally {
                    if (newDoc != null)
                        newDoc.close();
                }
            }
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
