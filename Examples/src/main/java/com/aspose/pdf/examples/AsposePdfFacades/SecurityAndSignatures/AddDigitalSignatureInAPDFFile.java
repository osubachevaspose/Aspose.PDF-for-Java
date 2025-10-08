package com.aspose.pdf.examples.AsposePdfFacades.SecurityAndSignatures;

import com.aspose.pdf.PKCS1;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfFileSignature;

public class AddDigitalSignatureInAPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/SecurityAndSignatures/AddDigitalSignatureInAPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example addDigitalSignatureInAPDFFile start");
        addDigitalSignatureInAPDFFile(dataDir, outputDir);
        System.out.println("Example addDigitalSignatureInAPDFFile end");
    }

    public static void addDigitalSignatureInAPDFFile(String dataDir, String outputDir) {
        // create PdfFileSignature object
        PdfFileSignature fileSignature = new PdfFileSignature();
        try {
            // bind input PDF file
            fileSignature.bindPdf("input.pdf");
            // create a rectangle for signature location
            java.awt.Rectangle rect = new java.awt.Rectangle(100, 100, 200, 100);
            // set signature appearance
            fileSignature.setSignatureAppearance(dataDir + "imgLogoPdf1.png");
            // create any of the three signature types
            PKCS1 signature = new PKCS1(dataDir + "temp.pfx", "password");
            // PKCS7 signature = new PKCS7(myDir + "temp.pfx", "password"); // PKCS#7 or
            // PKCS7Detached signature = new PKCS7Detached("temp.pfx", "password"); //
            // PKCS#7 detached
            fileSignature.sign(1, "Signature Reason", "Contact", "Location", true, rect, signature);
            // save output PDF file
            fileSignature.save(outputDir + "output.pdf");
        } finally {
            if (fileSignature != null)
                fileSignature.close();
        }
    }
}
