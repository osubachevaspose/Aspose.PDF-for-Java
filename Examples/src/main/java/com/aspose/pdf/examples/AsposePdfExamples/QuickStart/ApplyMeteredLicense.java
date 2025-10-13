package com.aspose.pdf.examples.AsposePdfExamples.QuickStart;

import com.aspose.pdf.Document;

public class ApplyMeteredLicense {

    @SuppressWarnings("static-access")
    public void Run() {
        String publicKey = "";
        String privateKey = "";
        com.aspose.pdf.Metered metered = new com.aspose.pdf.Metered();
        metered.setMeteredKey(publicKey, privateKey);
        // Optionally, the following lines return true if a valid license has been
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
