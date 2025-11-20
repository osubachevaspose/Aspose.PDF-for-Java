package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class InsertAnEmptyPageIntoPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Pages/InsertAnEmptyPageIntoPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example insertAnEmptyPageIntoPDFFile start");
        insertAnEmptyPageIntoPDFFile(dataDir, outputDir);
        System.out.println("Example insertAnEmptyPageIntoPDFFile end");
    }

    public static void insertAnEmptyPageIntoPDFFile(String dataDir, String outputDir) {
        // Open a document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Insert an empty page into a PDF
            doc.getPages().insert(1);
            // Save the output file
            doc.save(outputDir + "output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
