package com.aspose.pdf.examples.AsposePdfFacades.SecurityAndSignatures;

import com.aspose.pdf.PKCS1;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfFileSignature;

import java.awt.*;

public class SuppressLocationAndReason {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/SecurityAndSignatures/SuppressLocationAndReason/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example suppressLocationAndReason start");
        suppressLocationAndReason(dataDir, outputDir);
        System.out.println("Example suppressLocationAndReason end");
    }

    public static void suppressLocationAndReason(String dataDir, String outputDir) {
        PdfFileSignature fileSignature = new PdfFileSignature();
        try {
            fileSignature.bindPdf(dataDir + "input.pdf");
            // create a rectangle for signature location
            Rectangle rect = new Rectangle(100, 100, 200, 100);
            // create any of the three signature types
            PKCS1 signature = new PKCS1(dataDir + "certificate.pfx", "12345");
            // sign the PDF file
            fileSignature.sign(1, "", "Contact", "", true, rect, signature);
            // save output PDF file
            fileSignature.save(outputDir + "output.pdf");
        } finally {
            if (fileSignature != null)
                fileSignature.close();
        }
    }
}
