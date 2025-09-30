package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.BackgroundArtifact;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.examples.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AddImageAsPageBackground {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Pages/AddImageAsPageBackground/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example addImageAsPageBackground start");
        addImageAsPageBackground(dataDir, outputDir);
        System.out.println("Example addImageAsPageBackground end");
    }

    public static void addImageAsPageBackground(String dataDir, String outputDir) {
        // Create a new Document object
        Document doc = new Document();
        try {
            // Add a new page to document object
            Page page = doc.getPages().add();
            // Create BackgroundArtifact object
            BackgroundArtifact background = new BackgroundArtifact();
            // Specify the image for backgroundartifact object
            background.setBackgroundImage(new FileInputStream(dataDir + "google-icon-512.png"));
            // Add backgroundartifact to artifacts collection of page
            page.getArtifacts().add(background);
            // Save the document
            doc.save(outputDir + "BackGround.pdf");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
