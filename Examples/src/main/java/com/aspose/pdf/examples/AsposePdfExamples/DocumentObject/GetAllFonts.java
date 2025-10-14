package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.Font;
import com.aspose.pdf.examples.Utils;

public class GetAllFonts {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/DocumentObject/GetAllFonts/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example getAllFonts start");
        getAllFonts(dataDir);
        System.out.println("Example getAllFonts end");
    }

    public static void getAllFonts(String dataDir) {
        // Initialize new document object
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Get all fonts from document
            Font[] fonts = doc.getFontUtilities().getAllFonts();
            for (Font f : fonts) {
                System.out.println(f.getFontName());
            }
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
