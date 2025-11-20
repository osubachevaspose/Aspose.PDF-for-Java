package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class ConcatenatePDFFiles {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Pages/ConcatenatePDFFiles/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example concatenatePDFFiles start");
        concatenatePDFFiles(dataDir, outputDir);
        System.out.println("Example concatenatePDFFiles end");
    }

    public static void concatenatePDFFiles(String dataDir, String outputDir) {
        // Open the target document
        Document doc1 = new Document(dataDir + "input1.pdf");
        try {
            // Open the source document
            Document doc2 = new Document(dataDir + "input2.pdf");
            try {
                // Add the pages of the source document to the target document
                doc1.getPages().add(doc2.getPages());
            } finally {
                if (doc2 != null)
                    doc2.close();
            }
            // Save the concatenated output file (the target document)
            doc1.save(outputDir + "Concatenate_output.pdf");
        } finally {
            if (doc1 != null)
                doc1.close();
        }
    }
}
