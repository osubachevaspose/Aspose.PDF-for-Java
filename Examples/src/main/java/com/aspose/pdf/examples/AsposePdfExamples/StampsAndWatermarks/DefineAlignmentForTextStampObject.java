package com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.TextStamp;
import com.aspose.pdf.VerticalAlignment;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.FormattedText;

import java.io.File;

public class DefineAlignmentForTextStampObject {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        String testID = "com/aspose/pdf/examples/AsposePdf/StampsAndWatermarks/DefineAlignmentForTextStampObject/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        new File(outputDir).mkdirs();

        System.out.println("============================");
        System.out.println("Example defineAlignmentForTextStampObject start");
        defineAlignmentForTextStampObject(dataDir, outputDir);
        System.out.println("Example defineAlignmentForTextStampObject end");
    }

    public static void defineAlignmentForTextStampObject(String dataDir, String outputDir) {
        // open document
        Document doc = new Document(dataDir + "input.pdf");
        try {
            // instantiate FormattedText object with sample string
            FormattedText text = new FormattedText("This");
            // add new text line to FormattedText
            text.addNewLineText("is sample");
            text.addNewLineText("Center Aligned");
            text.addNewLineText("TextStamp");
            text.addNewLineText("Object");
            // create TextStamp object using FormattedText
            TextStamp stamp = new TextStamp(text);
            // specify the Horizontal Alignment of text stamp as Center aligned
            stamp.setHorizontalAlignment(HorizontalAlignment.Center);
            // specify the Vertical Alignment of text stamp as Center aligned
            stamp.setVerticalAlignment(VerticalAlignment.Center);
            // specify the Text Horizontal Alignment of TextStamp as Center aligned
            stamp.setTextAlignment(HorizontalAlignment.Center);
            // set top margin for stamp object
            stamp.setTopMargin(20);
            // add stamp to all pages of PDF file
            doc.getPages().get_Item(1).addStamp(stamp);
            // save output document
            doc.save(outputDir + "TextStamp_output.pdf");
        } finally {
            if (doc != null)
                doc.close();
        }
    }
}
