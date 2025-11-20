package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class DeleteParticularPageFromThePDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Pages/DeleteParticularPageFromThePDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example deleteParticularPageFromThePDFFile start");
        deleteParticularPageFromThePDFFile(dataDir, outputDir);
        System.out.println("Example deleteParticularPageFromThePDFFile end");
    }

    public static void deleteParticularPageFromThePDFFile(String dataDir, String outputDir) {
        // Open a document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Delete a page
            doc.getPages().delete(2);
            // Save the new PDF file
            doc.save(outputDir + "Updated_document.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
