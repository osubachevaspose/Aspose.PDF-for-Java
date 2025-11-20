package com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.FontStyles;
import com.aspose.pdf.Rotation;
import com.aspose.pdf.TextStamp;
import com.aspose.pdf.examples.Utils;

import java.io.File;

public class AddingTextStampInPDFFile {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/StampsAndWatermarks/AddingTextStampInPDFFile/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example addingTextStampInPDFFile start");
        addingTextStampInPDFFile(dataDir, outputDir);
        System.out.println("Example addingTextStampInPDFFile end");
    }

    public static void addingTextStampInPDFFile(String dataDir, String outputDir) {
        // open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // create text stamp
            TextStamp textStamp = new TextStamp("Sample Stamp");
            // set whether stamp is background
            textStamp.setBackground(true);
            // set origin
            textStamp.setXIndent(100);
            textStamp.setYIndent(100);
            // rotate stamp
            textStamp.setRotate(Rotation.on90);
            // set text properties
            textStamp.getTextState().setFont(FontRepository.findFont("Arial"));
            textStamp.getTextState().setFontSize(14.0F);
            textStamp.getTextState().setFontStyle(FontStyles.Bold);
            textStamp.getTextState().setFontStyle(FontStyles.Italic);
            textStamp.getTextState().setForegroundColor(Color.getGreen());
            // add stamp to particular page
            doc.getPages().get_Item(1).addStamp(textStamp);
            // save output document
            doc.save(outputDir + "TextStamp_output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
