package com.aspose.pdf.examples.AsposePdfExamples.QuickStart;

public class SetLicenseFromStream {

    public void Run() {
        // Initialize License Object
        com.aspose.pdf.License license = new com.aspose.pdf.License();
        // Set license from Stream
        try {
            license.setLicense(new java.io.FileInputStream("Aspose.Pdf.Java.lic"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
