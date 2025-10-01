package com.aspose.pdf.examples.AsposePdfExamples.SecurityAndSignatures;

import com.aspose.pdf.Document;
import com.aspose.pdf.PKCS1;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfFileSignature;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class AddDigitalSignatureToPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/SecurityAndSignatures/AddDigitalSignatureToPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        // Create output directory if not exists
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
            PdfFileSignature signSingle = new PdfFileSignature();
            try {
                // Bind the source PDF by reading contents of Stream
                signSingle.bindPdf(new ByteArrayInputStream(out.toByteArray()));
                // Sign the PDF file using PKCS1 object
                signSingle.sign(1, true, new java.awt.Rectangle(100, 100, 150, 50),
                        new PKCS1(dataDir + "VirtualCabinetPortal (1).pfx", "password"));
                // Set image for signature appearance
                signSingle.setSignatureAppearance(dataDir + "im.jpg");
                // Save final output
                signSingle.save(outputDir + "out_PDFNEWJAVA_33311.pdf");
            } finally {
                if (signSingle != null)
                    signSingle.close();
            }
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
