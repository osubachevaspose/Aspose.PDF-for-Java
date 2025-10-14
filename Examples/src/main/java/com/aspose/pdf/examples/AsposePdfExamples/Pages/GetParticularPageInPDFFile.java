package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.examples.Utils;

public class GetParticularPageInPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Pages/GetParticularPageInPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example getParticularPageInPDFFile start");
        getParticularPageInPDFFile(dataDir, outputDir);
        System.out.println("Example getParticularPageInPDFFile end");
    }

    public static void getParticularPageInPDFFile(String dataDir, String outputDir) {
        // Open the first document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Get the page at a particular index of the Page Collection
            Page page = doc.getPages().get_Item(2);
            // Create a new Document object
            Document newDoc = new Document();
            try {
                // Add the page to the Pages collection of new document object
                newDoc.getPages().add(page);
                // Save the new file
                newDoc.save(outputDir + "page_" + page.getNumber() + ".pdf");
            } finally {
                if (newDoc != null)
                    newDoc.close();
            }
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
