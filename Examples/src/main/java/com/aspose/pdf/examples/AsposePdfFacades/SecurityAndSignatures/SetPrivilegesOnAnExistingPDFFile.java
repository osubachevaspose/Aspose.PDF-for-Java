package com.aspose.pdf.examples.AsposePdfFacades.SecurityAndSignatures;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.DocumentPrivilege;
import com.aspose.pdf.facades.PdfFileSecurity;

import java.io.File;

public class SetPrivilegesOnAnExistingPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdfFacades/SecurityAndSignatures/SetPrivilegesOnAnExistingPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example setPrivilegesOnAnExistingPDFFile start");
        setPrivilegesOnAnExistingPDFFile(dataDir, outputDir);
        System.out.println("Example setPrivilegesOnAnExistingPDFFile end");
    }

    public static void setPrivilegesOnAnExistingPDFFile(String dataDir, String outputDir) {
        // Create DocumentPrivileges object
        DocumentPrivilege privilege = DocumentPrivilege.getForbidAll();
        privilege.setChangeAllowLevel(1);
        privilege.setAllowPrint(true);
        privilege.setAllowCopy(true);
        PdfFileSecurity fileSecurity = new PdfFileSecurity();
        try {
            // Open PDF document
            fileSecurity.bindPdf(dataDir + "input.pdf");
            // Set document privileges
            fileSecurity.setPrivilege(privilege);
            fileSecurity.save(outputDir + "output.pdf");
        } finally {
            if (fileSecurity != null)
                fileSecurity.close();
        }
    }
}
