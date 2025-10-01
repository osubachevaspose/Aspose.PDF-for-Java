package com.aspose.pdf.examples.AsposePdfExamples.SecurityAndSignatures;

import com.aspose.pdf.Document;
import com.aspose.pdf.PasswordType;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.exceptions.InvalidPasswordException;
import com.aspose.pdf.facades.PdfFileInfo;

public class HowToDetermineIfTheSourcePDFIsPasswordProtected {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/SecurityAndSignatures/HowToDetermineIfTheSourcePDFIsPasswordProtected/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example howToDetermineIfTheSourcePDFIsPasswordProtected start");
        howToDetermineIfTheSourcePDFIsPasswordProtected(dataDir);
        System.out.println("Example howToDetermineIfTheSourcePDFIsPasswordProtected end");

        System.out.println("Example getInformationAboutPDFDocumentSecurity start");
        getInformationAboutPDFDocumentSecurity(dataDir);
        System.out.println("Example getInformationAboutPDFDocumentSecurity end");

        System.out.println("Example determineCorrectPasswordFromArray start");
        determineCorrectPasswordFromArray(dataDir);
        System.out.println("Example determineCorrectPasswordFromArray end");
    }

    public static void howToDetermineIfTheSourcePDFIsPasswordProtected(String dataDir) {
        // load the source PDF document
        PdfFileInfo fileInfo = new PdfFileInfo(dataDir + "PDFToHTML.qwerty.pdf");
        try {
            // determine that source PDF file is Encrypted with password
            Boolean encrypted = fileInfo.isEncrypted();
            // MessageBox displays the current status related to PDf encryption
            System.out.println(encrypted.toString());
        } finally {
            if (fileInfo != null)
                fileInfo.close();
        }
    }

    public static void getInformationAboutPDFDocumentSecurity(String dataDir) {
        // instantiate FielInfo object
        PdfFileInfo fileInfo1 = new PdfFileInfo();
        try {
            // bind source PDF file
            fileInfo1.bindPdf(dataDir + "source.pdf");
            // print if source file is password encrypted
            System.out.println("Is document encrypted = " + fileInfo1.isEncrypted());
            // determine if the password type for document is User
            if (fileInfo1.getPasswordType() == PasswordType.User)
                // print password type information
                System.out.println("Password type = " + fileInfo1.getPasswordType() + " (type = User)");
        } finally {
            if (fileInfo1 != null)
                fileInfo1.close();
        }

        PdfFileInfo fileInfo2 = new PdfFileInfo();
        try {
            fileInfo2.bindPdf(dataDir + "source.pdf", "user");
            // print if document is encrypted
            System.out.println("Document is encrypted = " + fileInfo2.isEncrypted());
            // determine if the password type for document is Owner
            if (fileInfo2.getPasswordType() == PasswordType.Owner)
                // print password type information
                System.out.println("Password type = " + fileInfo2.getPasswordType() + " (type = Owner)");
            // print if document has open password specified
            System.out.println("Document has Open Password = " + fileInfo2.hasOpenPassword());
            // print if document has edit password specified
            System.out.println("Document has Edit Password = " + fileInfo2.hasEditPassword());
        } finally {
            if (fileInfo2 != null)
                fileInfo2.close();
        }

        PdfFileInfo fileInfo3 = new PdfFileInfo();
        try {
            fileInfo3.bindPdf(dataDir + "PDFToHTML.qwerty.pdf");
            // print if document is encrypted
            System.out.println("Document is encrypted = " + fileInfo3.isEncrypted());
            if (fileInfo3.getPasswordType() == PasswordType.Inaccessible)
                // print password type information
                System.out.println("Password type = " + fileInfo3.getPasswordType() + " (type = Inaccessible)");
            if (fileInfo3.hasOpenPassword())
                // Document has open password enable
                System.out.println("Document has open password enabled = " + fileInfo3.hasOpenPassword());
            // When PasswordType is Inaccessible we can't read HasEditPassword property.
            // boolean hasEditPassword = fileInfo3.hasEditPassword();
        } finally {
            if (fileInfo3 != null)
                fileInfo3.close();
        }
    }

    public static void determineCorrectPasswordFromArray(String dataDir) {
        PdfFileInfo fileInfo = new PdfFileInfo();
        try {
            // load source PDF file
            fileInfo.bindPdf(dataDir + "PDFToHTML.qwerty.pdf");
            // determine if the source PDF is encrypted
            System.out.println("File is password protected " + fileInfo.isEncrypted());
        } finally {
            if (fileInfo != null)
                fileInfo.close();
        }
        String[] passwords = new String[] { "test", "test1", "user", "qwerty", "test3", "sample" };
        for (int i = 0; i < passwords.length; i++) {
            try {
                Document doc = new Document(dataDir + "PDFToHTML.qwerty.pdf", passwords[i]);
                try {
                    if (doc.getPages().size() > 0) {
                        System.out.println("Password = " + passwords[i] + " is correct");
                        System.out.println("Number of Pages in document is = " + doc.getPages().size());
                    }
                } finally {
                    if (doc != null)
                        doc.close();
                }
            } catch (InvalidPasswordException ex) {
                System.out.println("------------------------------------------");
                System.out.println("Password = " + passwords[i] + " is not correct");
            }
        }
    }
}
