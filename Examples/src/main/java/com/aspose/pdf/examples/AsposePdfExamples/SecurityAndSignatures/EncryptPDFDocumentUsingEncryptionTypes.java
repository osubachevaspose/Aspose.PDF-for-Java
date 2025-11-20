package com.aspose.pdf.examples.AsposePdfExamples.SecurityAndSignatures;

import com.aspose.pdf.CryptoAlgorithm;
import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class EncryptPDFDocumentUsingEncryptionTypes {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/SecurityAndSignatures/EncryptPDFDocumentUsingEncryptionTypes/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example encryptPDFDocumentUsingEncryptionTypes start");
        encryptPDFDocumentUsingEncryptionTypes(dataDir, outputDir);
        System.out.println("Example encryptPDFDocumentUsingEncryptionTypes end");
    }

    public static void encryptPDFDocumentUsingEncryptionTypes(String dataDir, String outputDir) {
        // open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // encrypt PDF
            doc.encrypt("user", "owner", 0, CryptoAlgorithm.AESx256);
            // save updated PDF
            doc.save(outputDir + "Encrypted_output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
