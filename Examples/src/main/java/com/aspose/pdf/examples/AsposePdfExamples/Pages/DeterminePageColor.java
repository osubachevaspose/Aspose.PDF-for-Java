package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

public class DeterminePageColor {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Pages/DeterminePageColor/";
        String dataDir = Utils.getDataDir(testID);

        System.out.println("============================");
        System.out.println("Example determinePageColor start");
        determinePageColor(dataDir);
        System.out.println("Example determinePageColor end");
    }

    public static void determinePageColor(String dataDir) {
        // Open source PDF file
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // Iterate through all the page of PDF file
            for (int i = 1; i <= doc.getPages().size(); i++) {
                // Get the color type information for particular PDF page
                int pageColorType = doc.getPages().get_Item(i).getColorType();
                switch (pageColorType) {
                    case 2:
                        System.out.println("Page # -" + i + " is Black and white..");
                        break;
                    case 1:
                        System.out.println("Page # -" + i + " is Gray Scale...");
                        break;
                    case 0:
                        System.out.println("Page # -" + i + " is RGB..");
                        break;
                    case 3:
                        System.out.println("Page # -" + i + " Color is undefined..");
                        break;
                }
            }
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
