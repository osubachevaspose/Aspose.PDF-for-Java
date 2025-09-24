package com.aspose.pdf.examples.AsposePdfExamples.Attachments;

import com.aspose.pdf.Document;
import com.aspose.pdf.FileEncoding;
import com.aspose.pdf.FileSpecification;
import com.aspose.pdf.examples.Utils;

import java.io.IOException;

public class DisableFilesCompressionWhenAddingAsEmbeddedResources {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Attachments/DisableFilesCompressionWhenAddingAsEmbeddedResources/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example disableFilesCompressionWhenAddingAsEmbeddedResources start");
        try {
            disableFilesCompressionWhenAddingAsEmbeddedResources(dataDir, outputDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Example disableFilesCompressionWhenAddingAsEmbeddedResources end");
    }

    private static void disableFilesCompressionWhenAddingAsEmbeddedResources(String dataDir, String outputDir)
            throws IOException {
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // setup new file to be added as attachment
            FileSpecification fileSpecification = new FileSpecification(dataDir + "test.txt", "Sample text file");
            // Specify Encoding property setting it to FileEncoding.None
            fileSpecification.setEncoding(FileEncoding.None);
            // add attachment to document's attachment collection
            doc.getEmbeddedFiles().add(fileSpecification);
            // save new output
            doc.save(outputDir + "outputNoCompression.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
