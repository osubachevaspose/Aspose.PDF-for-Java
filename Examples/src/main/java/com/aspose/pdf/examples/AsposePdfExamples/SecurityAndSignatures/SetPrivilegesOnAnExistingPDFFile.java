package com.aspose.pdf.examples.AsposePdfExamples.SecurityAndSignatures;

import com.aspose.pdf.CryptoAlgorithm;
import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.DocumentPrivilege;

import java.io.File;

public class SetPrivilegesOnAnExistingPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/SecurityAndSignatures/SetPrivilegesOnAnExistingPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example setPrivilegesOnAnExistingPDFFile start");
        setPrivilegesOnAnExistingPDFFile(dataDir, outputDir);
        System.out.println("Example setPrivilegesOnAnExistingPDFFile end");
    }

    public static void setPrivilegesOnAnExistingPDFFile(String dataDir, String outputDir) {
        Document doc = new Document(dataDir + "input.pdf");
        try {
            DocumentPrivilege documentPrivilege = DocumentPrivilege.getForbidAll();
            documentPrivilege.setAllowScreenReaders(true);
            documentPrivilege.setAllowPrint(true);
            doc.encrypt("user", "owner", documentPrivilege, CryptoAlgorithm.AESx128, false);
            doc.save(outputDir + "outputFile.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
