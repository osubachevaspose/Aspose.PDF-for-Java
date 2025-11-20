package com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.FontStyles;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.PageNumberStamp;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class AddPageNumberStampInPDF {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/StampsAndWatermarks/AddPageNumberStampInPDF/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example addPageNumberStampInPDF start");
        addPageNumberStampInPDF(dataDir, outputDir);
        System.out.println("Example addPageNumberStampInPDF end");
    }

    public static void addPageNumberStampInPDF(String dataDir, String outputDir) {
        // open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // create page number stamp
            PageNumberStamp pageNumberStamp = new PageNumberStamp();
            // whether the stamp is background
            pageNumberStamp.setBackground(false);
            pageNumberStamp.setFormat("Page # of " + doc.getPages().size());
            pageNumberStamp.setBottomMargin(10);
            pageNumberStamp.setHorizontalAlignment(HorizontalAlignment.Center);
            pageNumberStamp.setStartingNumber(1);
            // set text properties
            pageNumberStamp.getTextState().setFont(FontRepository.findFont("Arial"));
            pageNumberStamp.getTextState().setFontSize(14.0F);
            pageNumberStamp.getTextState().setFontStyle(FontStyles.Bold);
            pageNumberStamp.getTextState().setFontStyle(FontStyles.Italic);
            pageNumberStamp.getTextState().setForegroundColor(Color.getBlue());
            // add stamp to particular page
            doc.getPages().get_Item(1).addStamp(pageNumberStamp);
            // save output document
            doc.save(outputDir + "PageNumberStamp_output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
