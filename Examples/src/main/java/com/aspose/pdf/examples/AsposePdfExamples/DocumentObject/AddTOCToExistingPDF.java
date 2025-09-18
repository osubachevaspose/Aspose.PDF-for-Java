package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.FontStyles;
import com.aspose.pdf.Heading;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextSegment;
import com.aspose.pdf.TocInfo;
import com.aspose.pdf.examples.Utils;

public class AddTOCToExistingPDF {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/DocumentObject/AddTOCToExistingPDF/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example addTOCToExistingPDF start");
        addTOCToExistingPDF(dataDir, outputDir);
        System.out.println("Example addTOCToExistingPDF end");
    }

    public static void addTOCToExistingPDF(String dataDir, String outputDir) {
        // Load an existing PDF file
        Document doc = new Document(dataDir + "source.pdf");
        try {
            // Get access to first page of PDF file
            Page tocPage = doc.getPages().insert(1);
            // Create object to represent TOC information
            TocInfo tocInfo = new TocInfo();
            TextFragment title = new TextFragment("Table Of Contents");
            title.getTextState().setFontSize(20);
            title.getTextState().setFontStyle(FontStyles.Bold);
            // Set the title for TOC
            tocInfo.setTitle(title);
            tocPage.setTocInfo(tocInfo);
            // Create string objects which will be used as TOC elements
            String[] titles = new String[2];
            titles[0] = "First page";
            titles[1] = "Second page";
            for (int i = 0; i < 2; i++) {
                // Create Heading object
                Heading heading2 = new Heading(1);
                TextSegment segment2 = new TextSegment();
                heading2.setTocPage(tocPage);
                heading2.getSegments().add(segment2);
                // Specify the destination page for heading object
                heading2.setDestinationPage(doc.getPages().get_Item(i + 2));
                // Destination page
                heading2.setTop(doc.getPages().get_Item(i + 2).getRect().getHeight());
                // Destination coordinate
                segment2.setText(titles[i]);
                // Add heading to page containing TOC
                tocPage.getParagraphs().add(heading2);
            }
            // Save the updated document
            doc.save(outputDir + "TOC_Output_Java.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
