package com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.FontStyles;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.TextStamp;
import com.aspose.pdf.VerticalAlignment;
import com.aspose.pdf.examples.Utils;

public class AddingTextInHeaderOrFooterOfPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/StampsAndWatermarks/AddingTextInHeaderOrFooterOfPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example addingTextInHeaderOrFooterOfPDFFile start");
        addingTextInHeaderOrFooterOfPDFFile(dataDir, outputDir);
        System.out.println("Example addingTextInHeaderOrFooterOfPDFFile end");
    }

    public static void addingTextInHeaderOrFooterOfPDFFile(String dataDir, String outputDir) {
        // open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // create text stamp
            TextStamp textStamp = new TextStamp("Sample Stamp");
            // set properties of the stamp
            textStamp.setTopMargin(10);
            textStamp.setHorizontalAlignment(HorizontalAlignment.Center);
            textStamp.setVerticalAlignment(VerticalAlignment.Top);
            // set text properties
            textStamp.getTextState().setFont(FontRepository.findFont("Arial"));
            textStamp.getTextState().setFontSize(14.0F);
            textStamp.getTextState().setFontStyle(FontStyles.Bold);
            textStamp.getTextState().setFontStyle(FontStyles.Italic);
            textStamp.getTextState().setForegroundColor(Color.getGreen());
            // iterate through all pages of PDF file
            for (int i = 1; i <= doc.getPages().size(); i++) {
                // add stamp to all pages of PDF file
                doc.getPages().get_Item(i).addStamp(textStamp);
            }
            // save output document
            doc.save(outputDir + "TextStamp_output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
