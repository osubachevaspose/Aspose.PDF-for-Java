package com.aspose.pdf.examples.AsposePdfExamples.LinksAndActions;

import com.aspose.pdf.Document;
import com.aspose.pdf.GoToRemoteAction;
import com.aspose.pdf.LinkAnnotation;
import com.aspose.pdf.examples.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreateALinkToAnotherPDFDocument {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/LinksAndActions/CreateALinkToAnotherPDFDocument/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example createALinkToAnotherPDFDocument start");
        createALinkToAnotherPDFDocument(dataDir, outputDir);
        System.out.println("Example createALinkToAnotherPDFDocument end");
    }

    public static void createALinkToAnotherPDFDocument(String dataDir, String outputDir) {
        try {
            Path source = new File(dataDir + "SampleDataTable.pdf").toPath();
            Path target = new File(outputDir + "SampleDataTable.pdf").toPath();
            Files.copy(source, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Open document
        Document doc = new Document();
        try {
            // Add page to PDF file
            doc.getPages().add();
            // Create LinkAnnotation object and specify rectangular region
            LinkAnnotation link = new LinkAnnotation(doc.getPages().get_Item(1),
                    new com.aspose.pdf.Rectangle(100, 100, 110, 110));
            // Set color for Annotation object
            link.setColor(com.aspose.pdf.Color.fromRgb(java.awt.Color.green));
            // Specify the target PDF file and set page number
            link.setAction(new GoToRemoteAction("SampleDataTable.pdf", 1));
            // Add link annotation to first page of PDF file
            doc.getPages().get_Item(1).getAnnotations().add(link);
            // Save the document with link
            doc.save(outputDir + "Hyperlink_to_PDF.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
