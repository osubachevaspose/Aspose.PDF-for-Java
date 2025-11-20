package com.aspose.pdf.examples.AsposePdfExamples.LinksAndActions;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class RemoveDocumentOpenActionFromPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/LinksAndActions/RemoveDocumentOpenActionFromPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example removeDocumentOpenActionFromPDFFile start");
        removeDocumentOpenActionFromPDFFile(dataDir, outputDir);
        System.out.println("Example removeDocumentOpenActionFromPDFFile end");
    }

    public static void removeDocumentOpenActionFromPDFFile(String dataDir, String outputDir) {
        // Open document
        Document doc = new Document(dataDir + "PdfWithOpenAction.pdf");
        try {
            // Remove document open action
            doc.setOpenAction(null);
            // Save updated document
            doc.save(outputDir + "output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
