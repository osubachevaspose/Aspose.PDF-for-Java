package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class RemoveMetadataFromPDF {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/DocumentObject/RemoveMetadataFromPDF/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example removeMetadataFromPDF start");
        removeMetadataFromPDF(dataDir, outputDir);
        System.out.println("Example removeMetadataFromPDF end");
    }

    public static void removeMetadataFromPDF(String dataDir, String outputDir) {
        // Instantiate Document object
        Document doc = new Document(dataDir + "4pagesPdfA.pdf");
        try {
            if (doc.getMetadata().contains("pdfaid:part"))
                doc.getMetadata().removeItemByKey("pdfaid:part");
            else
                System.out.println("No metadata with key \"pdfaid:part\" found.");

            if (doc.getMetadata().contains("dc:format"))
                doc.getMetadata().removeItemByKey("dc:format");
            else
                System.out.println("No metadata with key \"dc:format\" found.");

            // Save updated document
            doc.save(outputDir + "output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
