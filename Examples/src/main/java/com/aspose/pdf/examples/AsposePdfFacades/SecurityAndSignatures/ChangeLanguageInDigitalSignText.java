package com.aspose.pdf.examples.AsposePdfFacades.SecurityAndSignatures;

import com.aspose.pdf.PKCS7;
import com.aspose.pdf.SignatureCustomAppearance;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfFileSignature;

import java.awt.Rectangle;
import java.io.File;
import java.util.Date;

public class ChangeLanguageInDigitalSignText {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/SecurityAndSignatures/ChangeLanguageInDigitalSignText/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example changeLanguageInDigitalSignText start");
        changeLanguageInDigitalSignText(dataDir, outputDir);
        System.out.println("Example changeLanguageInDigitalSignText end");
    }

    public static void changeLanguageInDigitalSignText(String dataDir, String outputDir) {
        // create PdfFileSignature object and bind input PDF files
        PdfFileSignature fileSignature = new PdfFileSignature();
        try {
            fileSignature.bindPdf(dataDir + "input.pdf");
            // create a rectangle for signature location
            Rectangle rect = new Rectangle(310, 45, 200, 50);
            // create any of the three signature types
            PKCS7 pkcs = new PKCS7(dataDir + "LocalTestCert.qwerty.pfx", "qwerty");
            pkcs.setReason("Pruebas Firma");
            pkcs.setContactInfo("Contacto Pruebas");
            pkcs.setLocation("Población (Provincia)");
            pkcs.setDate(new Date());
            SignatureCustomAppearance signatureCustomAppearance = new SignatureCustomAppearance();
            signatureCustomAppearance.setDateSignedAtLabel("Fecha");
            signatureCustomAppearance.setDigitalSignedLabel("Digitalmente firmado por");
            signatureCustomAppearance.setReasonLabel("Razón");
            signatureCustomAppearance.setLocationLabel("Localización");
            signatureCustomAppearance.setFontFamilyName("Arial");
            signatureCustomAppearance.setFontSize(10d);
            signatureCustomAppearance.setDateTimeFormat("yyyy.MM.dd HH:mm:ss");
            pkcs.setCustomAppearance(signatureCustomAppearance);
            // sign the PDF file
            fileSignature.sign(1, true, rect, pkcs);
            // save output PDF file
            fileSignature.save(outputDir + "output.pdf");
        } finally {
            if (fileSignature != null)
                fileSignature.close();
        }
    }
}