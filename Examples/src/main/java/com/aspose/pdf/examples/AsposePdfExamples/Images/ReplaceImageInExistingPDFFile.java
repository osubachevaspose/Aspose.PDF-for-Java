package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReplaceImageInExistingPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Images/ReplaceImageInExistingPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example replaceImageInExistingPDFFile start");
        replaceImageInExistingPDFFile(dataDir, outputDir);
        System.out.println("Example replaceImageInExistingPDFFile end");
    }

    public static void replaceImageInExistingPDFFile(String dataDir, String outputDir) {
        // Open a document
        Document doc = new Document(dataDir + "PdfWith2Images.pdf");
        try {
            // Replace a particular image
            doc.getPages().get_Item(1).getResources().getImages()
                    .replace(1, new FileInputStream(new java.io.File(dataDir + "google-icon-512.png")));
            // Save the updated PDF file
            doc.save(outputDir + "output.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
