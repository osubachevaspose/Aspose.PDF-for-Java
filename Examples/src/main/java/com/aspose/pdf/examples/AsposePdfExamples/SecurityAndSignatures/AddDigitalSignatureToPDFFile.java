package com.aspose.pdf.examples.AsposePdfExamples.SecurityAndSignatures;

import com.aspose.pdf.Document;
import com.aspose.pdf.PKCS1;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfFileSignature;

import java.awt.Rectangle;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class AddDigitalSignatureToPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/SecurityAndSignatures/AddDigitalSignatureToPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example addDigitalSignatureToPDFFile start");
        addDigitalSignatureToPDFFile(dataDir, outputDir);
        System.out.println("Example addDigitalSignatureToPDFFile end");
    }

    public static void addDigitalSignatureToPDFFile(String dataDir, String outputDir) {
        // Instantiate Document object
        Document doc = new Document();
        try {
            // Add a page to PDF document
            doc.getPages().add();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            // Save document to Stream object
            doc.save(out);
            // Create PdfFileSignature instance
            PdfFileSignature fileSignature = new PdfFileSignature();
            try {
                // Bind the source PDF by reading contents of Stream
                fileSignature.bindPdf(new ByteArrayInputStream(out.toByteArray()));
                // Sign the PDF file using PKCS1 object
                fileSignature.sign(1, true, new Rectangle(100, 100, 150, 50),
                        new PKCS1(dataDir + "LocalTestCert.qwerty.pfx", "qwerty"));
                // Set image for signature appearance
                fileSignature.setSignatureAppearance(dataDir + "image.jpg");
                // Save final output
                fileSignature.save(outputDir + "PdfWithDigitalSignature_out.pdf");
            } finally {
                if (fileSignature != null)
                    fileSignature.close();
            }
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
