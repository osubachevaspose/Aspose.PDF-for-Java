package com.aspose.pdf.examples.AsposePdfExamples.SecurityAndSignatures;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

public class DecryptPDFFileUsingOwnerPassword {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/SecurityAndSignatures/DecryptPDFFileUsingOwnerPassword/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example decryptPDFFileUsingOwnerPassword start");
        decryptPDFFileUsingOwnerPassword(dataDir, outputDir);
        System.out.println("Example decryptPDFFileUsingOwnerPassword end");
    }

    public static void decryptPDFFileUsingOwnerPassword(String dataDir, String outputDir) {
        // open encrypted document
        Document doc = new Document(dataDir + "PDFToHTML.qwerty.pdf", "qwerty");
        try {
            // decrypt PDF
            doc.decrypt();
            // save updated PDF
            doc.save(outputDir + "output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
