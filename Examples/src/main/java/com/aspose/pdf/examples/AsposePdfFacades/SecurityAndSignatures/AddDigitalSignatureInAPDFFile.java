package com.aspose.pdf.examples.AsposePdfFacades.SecurityAndSignatures;

import com.aspose.pdf.PKCS1;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfFileSignature;

import java.awt.Rectangle;
import java.io.File;

public class AddDigitalSignatureInAPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/SecurityAndSignatures/AddDigitalSignatureInAPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

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
            fileSignature.bindPdf(dataDir + "input.pdf");
            // create a rectangle for signature location
            Rectangle rect = new Rectangle(100, 100, 200, 100);
            // set signature appearance
            fileSignature.setSignatureAppearance(dataDir + "image.jpg");
            // create any of the three signature types
            PKCS1 signature = new PKCS1(dataDir + "LocalTestCert.qwerty.pfx", "qwerty");
            // PKCS7 signature = new PKCS7(myDir + "LocalTestCert.qwerty.pfx", "qwerty"); // PKCS#7 or
            // PKCS7Detached signature = new PKCS7Detached("LocalTestCert.qwerty.pfx", "qwerty"); // PKCS#7 detached
            fileSignature.sign(1, "Signature Reason", "Contact", "Location", true, rect, signature);
            // save output PDF file
            fileSignature.save(outputDir + "output.pdf");
        } finally {
            if (fileSignature != null)
                fileSignature.close();
        }
    }
}
