package com.aspose.pdf.examples.AsposePdfFacades.SecurityAndSignatures;

import com.aspose.pdf.PKCS1;
import com.aspose.pdf.facades.PdfFileSignature;

public class AddDigitalSignatureInAPDFFile {

    public static void main(String[] args) {
        // Path to Directory
        String myDir = "PathToDir";
        // create PdfFileSignature object
        PdfFileSignature fileSignature = new PdfFileSignature();
        try {
            // bind input PDF file
            fileSignature.bindPdf("input.pdf");
            // create a rectangle for signature location
            java.awt.Rectangle rect = new java.awt.Rectangle(100, 100, 200, 100);
            // set signature appearance
            fileSignature.setSignatureAppearance(myDir + "imgLogoPdf1.png");
            // create any of the three signature types
            PKCS1 signature = new PKCS1(myDir + "temp.pfx", "password");
            // PKCS7 signature = new PKCS7(myDir + "temp.pfx", "password"); // PKCS#7 or
            // PKCS7Detached signature = new PKCS7Detached("temp.pfx", "password"); //
            // PKCS#7 detached
            fileSignature.sign(1, "Signature Reason", "Contact", "Location", true, rect, signature);
            // save output PDF file
            fileSignature.save("output.pdf");
        } finally {
            if (fileSignature != null)
                fileSignature.close();
        }
    }
}
