package com.aspose.pdf.examples.AsposePdfExamples.Attachments;

import com.aspose.pdf.Document;
import com.aspose.pdf.FileSpecification;
import com.aspose.pdf.examples.Utils;

public class AddAttachmentToPDF {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/Attachments/AddAttachmentToPDF/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example addAttachmentToPDF start");
        addAttachmentToPDF(dataDir, outputDir);
        System.out.println("Example addAttachmentToPDF end");
    }

    private static void addAttachmentToPDF(String dataDir, String outputDir) {
        // Open a document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Set up a new file to be added as attachment
            FileSpecification fileSpecification = new FileSpecification(dataDir + "test.txt", "Sample text file");
            // Add an attachment to document's attachment collection
            doc.getEmbeddedFiles().add(fileSpecification);
            // Save the updated document
            doc.save(outputDir + "output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
