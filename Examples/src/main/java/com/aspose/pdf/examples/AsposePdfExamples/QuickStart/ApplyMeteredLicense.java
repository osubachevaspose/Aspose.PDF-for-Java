package com.aspose.pdf.examples.AsposePdfExamples.QuickStart;

import com.aspose.pdf.Document;

public class ApplyMeteredLicense {

    public static void main(String[] args) {
    }

    @SuppressWarnings("static-access")
    public void Run() {
        String publicKey = "";
        String privateKey = "";
        com.aspose.pdf.Metered m = new com.aspose.pdf.Metered();
        m.setMeteredKey(publicKey, privateKey);
        // Optionally, the following two lines return true if a valid license has been
        // applied; false if the component is running in evaluation mode.
        Document doc = new Document();
        try {
            System.out.println("License is set = " + doc.isLicensed());
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
