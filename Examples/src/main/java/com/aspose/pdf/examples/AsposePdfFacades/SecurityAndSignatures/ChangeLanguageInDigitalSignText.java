package com.aspose.pdf.examples.AsposePdfFacades.SecurityAndSignatures;

import com.aspose.pdf.PKCS7;
import com.aspose.pdf.SignatureCustomAppearance;
import com.aspose.pdf.facades.PdfFileSignature;

import java.awt.*;
import java.util.Date;

public class ChangeLanguageInDigitalSignText {

    public static void main(String[] args) {
        // Path to Directory
        String dataDir = "PathToDir";
        // create PdfFileSignature object and bind input PDF files
        String inPfxFile = dataDir + "certificate.pfx";
        String inFile = dataDir + "input.pdf";
        String outFile = dataDir + "output.pdf";
        PdfFileSignature fileSignature = new PdfFileSignature();
        try {
            fileSignature.bindPdf(inFile);
            // create a rectangle for signature location
            Rectangle rect = new Rectangle(310, 45, 200, 50);
            // create any of the three signature types
            PKCS7 pkcs = new PKCS7(inPfxFile, "12345");
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
            fileSignature.save(outFile);
        } finally {
            if (fileSignature != null)
                fileSignature.close();
        }
    }
}