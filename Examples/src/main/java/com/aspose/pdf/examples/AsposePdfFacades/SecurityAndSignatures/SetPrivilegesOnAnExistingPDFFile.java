package com.aspose.pdf.examples.AsposePdfFacades.SecurityAndSignatures;

import com.aspose.pdf.facades.DocumentPrivilege;
import com.aspose.pdf.facades.PdfFileSecurity;

public class SetPrivilegesOnAnExistingPDFFile {

    public static void main(String[] args) {
        // Create DocumentPrivileges object
        DocumentPrivilege privilege = DocumentPrivilege.getForbidAll();
        privilege.setChangeAllowLevel(1);
        privilege.setAllowPrint(true);
        privilege.setAllowCopy(true);
        PdfFileSecurity fileSecurity = new PdfFileSecurity();
        try {
            // Open PDF document
            fileSecurity.bindPdf("input.pdf");
            // Set document privileges
            fileSecurity.setPrivilege(privilege);
            fileSecurity.save("output.pdf");
        } finally {
            if (fileSecurity != null)
                fileSecurity.close();
        }
    }
}
